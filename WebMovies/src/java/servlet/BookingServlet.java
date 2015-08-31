/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.BookingJpaController;
import controller.FilmJpaController;
import controller.exceptions.RollbackFailureException;
import entities.Booking;
import entities.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class BookingServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebMoviesPU")
    private EntityManagerFactory emf;
    @Resource
    private javax.transaction.UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FilmJpaController fjc = new FilmJpaController(utx, emf);
        BookingJpaController bjc = new BookingJpaController(utx, emf);
        String evt = request.getParameter("evt");
        switch (evt) {
            case "create":
                String name = request.getParameter("name");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String email = request.getParameter("email");
                int movieId = Integer.parseInt(request.getParameter("filmId"));
                int ql = Integer.parseInt(request.getParameter("ql"));
                String time = request.getParameter("time");
                Booking b = new Booking();
                b.setName(name);
                b.setPhone(phone);
                b.setEmail(email);
                b.setQualtity(ql);
                b.setMovieId(fjc.findFilm(movieId));
                b.setOpenTime(time);
                bjc.create(b);

                request.setAttribute("book", b);
                request.getRequestDispatcher("bookfinal.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                
                Booking b2 = bjc.findBooking(id);
                request.setAttribute("book", b2);
                
                List<Film> listF = fjc.findFilmEntities();
                request.setAttribute("listFilms", listF);
                
                request.getRequestDispatcher("admin/editBooking.jsp").forward(request, response);
                break;
            case "doEdit":
                int id2 = Integer.parseInt(request.getParameter("id"));
                Booking b3 = bjc.findBooking(id2);
                b3.setName(request.getParameter("name"));
                b3.setPhone(Integer.parseInt(request.getParameter("phone")));
                b3.setEmail(request.getParameter("email"));
                int movieId2 = Integer.parseInt(request.getParameter("filmId"));
                b3.setMovieId(fjc.findFilm(movieId2));
                b3.setQualtity(Integer.parseInt(request.getParameter("ql")));
                b3.setOpenTime(request.getParameter("time"));                
                bjc.edit(b3);
                response.sendRedirect("AllBookings");
                break;
            case "delete":
                int id3 = Integer.parseInt(request.getParameter("id"));
                bjc.destroy(id3);
                response.sendRedirect("AllBookings");
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
