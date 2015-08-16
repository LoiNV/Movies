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

    public void create(Film film) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (film.getBookingCollection() == null) {
            film.setBookingCollection(new ArrayList<Booking>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Category categoryId = film.getCategoryId();
            if (categoryId != null) {
                categoryId = em.getReference(categoryId.getClass(), categoryId.getId());
                film.setCategoryId(categoryId);
            }
            Collection<Booking> attachedBookingCollection = new ArrayList<Booking>();
            for (Booking bookingCollectionBookingToAttach : film.getBookingCollection()) {
                bookingCollectionBookingToAttach = em.getReference(bookingCollectionBookingToAttach.getClass(), bookingCollectionBookingToAttach.getId());
                attachedBookingCollection.add(bookingCollectionBookingToAttach);
            }
            film.setBookingCollection(attachedBookingCollection);
            em.persist(film);
            if (categoryId != null) {
                categoryId.getFilmCollection().add(film);
                categoryId = em.merge(categoryId);
            }
            for (Booking bookingCollectionBooking : film.getBookingCollection()) {
                Film oldMovieIdOfBookingCollectionBooking = bookingCollectionBooking.getMovieId();
                bookingCollectionBooking.setMovieId(film);
                bookingCollectionBooking = em.merge(bookingCollectionBooking);
                if (oldMovieIdOfBookingCollectionBooking != null) {
                    oldMovieIdOfBookingCollectionBooking.getBookingCollection().remove(bookingCollectionBooking);
                    oldMovieIdOfBookingCollectionBooking = em.merge(oldMovieIdOfBookingCollectionBooking);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findFilm(film.getId()) != null) {
                throw new PreexistingEntityException("Film " + film + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Film film) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Film persistentFilm = em.find(Film.class, film.getId());
            Category categoryIdOld = persistentFilm.getCategoryId();
            Category categoryIdNew = film.getCategoryId();
            Collection<Booking> bookingCollectionOld = persistentFilm.getBookingCollection();
            Collection<Booking> bookingCollectionNew = film.getBookingCollection();
            List<String> illegalOrphanMessages = null;
            for (Booking bookingCollectionOldBooking : bookingCollectionOld) {
                if (!bookingCollectionNew.contains(bookingCollectionOldBooking)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Booking " + bookingCollectionOldBooking + " since its movieId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (categoryIdNew != null) {
                categoryIdNew = em.getReference(categoryIdNew.getClass(), categoryIdNew.getId());
                film.setCategoryId(categoryIdNew);
            }
            Collection<Booking> attachedBookingCollectionNew = new ArrayList<Booking>();
            for (Booking bookingCollectionNewBookingToAttach : bookingCollectionNew) {
                bookingCollectionNewBookingToAttach = em.getReference(bookingCollectionNewBookingToAttach.getClass(), bookingCollectionNewBookingToAttach.getId());
                attachedBookingCollectionNew.add(bookingCollectionNewBookingToAttach);
            }
            bookingCollectionNew = attachedBookingCollectionNew;
            film.setBookingCollection(bookingCollectionNew);
            film = em.merge(film);
            if (categoryIdOld != null && !categoryIdOld.equals(categoryIdNew)) {
                categoryIdOld.getFilmCollection().remove(film);
                categoryIdOld = em.merge(categoryIdOld);
            }
            if (categoryIdNew != null && !categoryIdNew.equals(categoryIdOld)) {
                categoryIdNew.getFilmCollection().add(film);
                categoryIdNew = em.merge(categoryIdNew);
            }
            for (Booking bookingCollectionNewBooking : bookingCollectionNew) {
                if (!bookingCollectionOld.contains(bookingCollectionNewBooking)) {
                    Film oldMovieIdOfBookingCollectionNewBooking = bookingCollectionNewBooking.getMovieId();
                    bookingCollectionNewBooking.setMovieId(film);
                    bookingCollectionNewBooking = em.merge(bookingCollectionNewBooking);
                    if (oldMovieIdOfBookingCollectionNewBooking != null && !oldMovieIdOfBookingCollectionNewBooking.equals(film)) {
                        oldMovieIdOfBookingCollectionNewBooking.getBookingCollection().remove(bookingCollectionNewBooking);
                        oldMovieIdOfBookingCollectionNewBooking = em.merge(oldMovieIdOfBookingCollectionNewBooking);
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
                Integer id = film.getId();
                if (findFilm(id) == null) {
                    throw new NonexistentEntityException("The film with id " + id + " no longer exists.");
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
            Film film;
            try {
                film = em.getReference(Film.class, id);
                film.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The film with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Booking> bookingCollectionOrphanCheck = film.getBookingCollection();
            for (Booking bookingCollectionOrphanCheckBooking : bookingCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Film (" + film + ") cannot be destroyed since the Booking " + bookingCollectionOrphanCheckBooking + " in its bookingCollection field has a non-nullable movieId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Category categoryId = film.getCategoryId();
            if (categoryId != null) {
                categoryId.getFilmCollection().remove(film);
                categoryId = em.merge(categoryId);
            }
            em.remove(film);
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
