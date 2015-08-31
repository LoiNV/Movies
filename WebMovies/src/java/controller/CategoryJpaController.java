/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    private EntityManagerFactory emf = null;
    
    private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Category category) {
        
        EntityManager em = null;
        
        try {            
            utx.begin();
            em = getEntityManager();
            Query q = em.createNativeQuery("INSERT INTO tbl_Category VALUES (?)");
            q.setParameter(1, category.getName());
            int i = q.executeUpdate();
            if (i>0) {
                utx.commit();
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return false;
    }

    public boolean edit(int id ,String name) {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createQuery("UPDATE Category c SET c.name = :name WHERE c.id =:id");
            
            q.setParameter("id", id);
            q.setParameter("name", name);
            int i = q.executeUpdate();
            if (i>0) {
                utx.commit();
                return true;
            }
        } catch (Exception ex) {
            
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return false;
    }

    public boolean destroy(Integer id) {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createQuery("DELETE FROM Category c WHERE c.id = :id");
            
            q.setParameter("id", id);
            int i = q.executeUpdate();
            if (i>0) {
                utx.commit();
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return false;
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
