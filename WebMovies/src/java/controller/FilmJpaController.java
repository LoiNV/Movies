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
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Category;
import entities.Booking;
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
public class FilmJpaController implements Serializable {

    public FilmJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Film film) {
        
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createNativeQuery("INSERT INTO tbl_Film VALUES (?,?,?,?,?,?,?,?)");
            q.setParameter(1, film.getName());
            q.setParameter(2, film.getOpenning());
            q.setParameter(3, film.getDescript());
            q.setParameter(4, film.getImg());
            q.setParameter(5, film.getLinkVideo());
            q.setParameter(6, film.getCategoryId().getId());
            q.setParameter(7, film.getIsHot());
            q.setParameter(8, film.getPrice());
            q.executeUpdate();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Film film){
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createNativeQuery("UPDATE tbl_Film  SET name = ?, openning = ?, descript = ?, img = ?,"
                                            + " linkVideo = ?, category_id = ?, price = ?, isHot = ? WHERE id = ?");
            
            q.setParameter(9, film.getId());
            q.setParameter(1, film.getName());
            q.setParameter(2, film.getOpenning());
            q.setParameter(3, film.getDescript());
            q.setParameter(4, film.getImg());
            q.setParameter(5, film.getLinkVideo());
            q.setParameter(6, film.getCategoryId().getId());
            q.setParameter(7, film.getPrice());
            q.setParameter(8, film.getIsHot());
            q.executeUpdate();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id){
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createQuery("DELETE FROM Film c WHERE c.id = :id");
            
            q.setParameter("id", id);
            q.executeUpdate();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Film> findFilmEntities() {
        return findFilmEntities(true, -1, -1);
    }

    public List<Film> findFilmEntities(int maxResults, int firstResult) {
        return findFilmEntities(false, maxResults, firstResult);
    }

    private List<Film> findFilmEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Film.class));
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

    public Film findFilm(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Film.class, id);
        } finally {
            em.close();
        }
    }

    public int getFilmCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Film> rt = cq.from(Film.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
