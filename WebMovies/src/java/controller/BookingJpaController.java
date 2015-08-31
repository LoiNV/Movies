/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import entities.Booking;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Film;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Admin
 */
public class BookingJpaController implements Serializable {

    public BookingJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Booking booking) {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Query q = em.createNativeQuery("INSERT INTO tbl_Booking VALUES (?,?,?,?,?,?)");
            q.setParameter(1, booking.getName());
            q.setParameter(2, booking.getPhone());
            q.setParameter(3, booking.getEmail());
            q.setParameter(4, booking.getMovieId().getId());
            q.setParameter(5, booking.getQualtity());
            q.setParameter(6, booking.getOpenTime());
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

    public void edit(Booking booking) {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();            
            booking = em.merge(booking);            
            utx.commit();
        } catch (Exception ex) {
           ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Booking booking = em.getReference(Booking.class, id);            
            em.remove(booking);
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Booking> findBookingEntities() {
        return findBookingEntities(true, -1, -1);
    }

    public List<Booking> findBookingEntities(int maxResults, int firstResult) {
        return findBookingEntities(false, maxResults, firstResult);
    }

    private List<Booking> findBookingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Booking.class));
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

    public Booking findBooking(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Booking.class, id);
        } finally {
            em.close();
        }
    }

    public int getBookingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Booking> rt = cq.from(Booking.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
