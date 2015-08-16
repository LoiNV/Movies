/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import entities.Category;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Film;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Admin
 */
public class CategoryJpaController implements Serializable {

    public CategoryJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Category category) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (category.getFilmCollection() == null) {
            category.setFilmCollection(new ArrayList<Film>());
        }
        EntityManager em = null;
        System.out.println(category.getId()+"");
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Film> attachedFilmCollection = new ArrayList<Film>();
            for (Film filmCollectionFilmToAttach : category.getFilmCollection()) {
                filmCollectionFilmToAttach = em.getReference(filmCollectionFilmToAttach.getClass(), filmCollectionFilmToAttach.getId());
                attachedFilmCollection.add(filmCollectionFilmToAttach);
            }
            category.setFilmCollection(attachedFilmCollection);
            em.persist(category);
            for (Film filmCollectionFilm : category.getFilmCollection()) {
                Category oldCategoryIdOfFilmCollectionFilm = filmCollectionFilm.getCategoryId();
                filmCollectionFilm.setCategoryId(category);
                filmCollectionFilm = em.merge(filmCollectionFilm);
                if (oldCategoryIdOfFilmCollectionFilm != null) {
                    oldCategoryIdOfFilmCollectionFilm.getFilmCollection().remove(filmCollectionFilm);
                    oldCategoryIdOfFilmCollectionFilm = em.merge(oldCategoryIdOfFilmCollectionFilm);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCategory(category.getId()) != null) {
                throw new PreexistingEntityException("Category " + category + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Category category) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Category persistentCategory = em.find(Category.class, category.getId());
            Collection<Film> filmCollectionOld = persistentCategory.getFilmCollection();
            Collection<Film> filmCollectionNew = category.getFilmCollection();
            List<String> illegalOrphanMessages = null;
            for (Film filmCollectionOldFilm : filmCollectionOld) {
                if (!filmCollectionNew.contains(filmCollectionOldFilm)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Film " + filmCollectionOldFilm + " since its categoryId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Film> attachedFilmCollectionNew = new ArrayList<Film>();
            for (Film filmCollectionNewFilmToAttach : filmCollectionNew) {
                filmCollectionNewFilmToAttach = em.getReference(filmCollectionNewFilmToAttach.getClass(), filmCollectionNewFilmToAttach.getId());
                attachedFilmCollectionNew.add(filmCollectionNewFilmToAttach);
            }
            filmCollectionNew = attachedFilmCollectionNew;
            category.setFilmCollection(filmCollectionNew);
            category = em.merge(category);
            for (Film filmCollectionNewFilm : filmCollectionNew) {
                if (!filmCollectionOld.contains(filmCollectionNewFilm)) {
                    Category oldCategoryIdOfFilmCollectionNewFilm = filmCollectionNewFilm.getCategoryId();
                    filmCollectionNewFilm.setCategoryId(category);
                    filmCollectionNewFilm = em.merge(filmCollectionNewFilm);
                    if (oldCategoryIdOfFilmCollectionNewFilm != null && !oldCategoryIdOfFilmCollectionNewFilm.equals(category)) {
                        oldCategoryIdOfFilmCollectionNewFilm.getFilmCollection().remove(filmCollectionNewFilm);
                        oldCategoryIdOfFilmCollectionNewFilm = em.merge(oldCategoryIdOfFilmCollectionNewFilm);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = category.getId();
                if (findCategory(id) == null) {
                    throw new NonexistentEntityException("The category with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Category category;
            try {
                category = em.getReference(Category.class, id);
                category.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The category with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Film> filmCollectionOrphanCheck = category.getFilmCollection();
            for (Film filmCollectionOrphanCheckFilm : filmCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Category (" + category + ") cannot be destroyed since the Film " + filmCollectionOrphanCheckFilm + " in its filmCollection field has a non-nullable categoryId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(category);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Category> findCategoryEntities() {
        return findCategoryEntities(true, -1, -1);
    }

    public List<Category> findCategoryEntities(int maxResults, int firstResult) {
        return findCategoryEntities(false, maxResults, firstResult);
    }

    private List<Category> findCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Category.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Category findCategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Category> rt = cq.from(Category.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
