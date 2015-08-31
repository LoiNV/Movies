/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.CategoryJpaController;
import controller.FilmJpaController;
import entities.Category;
import entities.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
public class SearchFilmServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebMoviesPU")
    private EntityManagerFactory emf;
    @Resource
    private javax.transaction.UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FilmJpaController fjc = new FilmJpaController(utx, emf);
        List<Film> list = new LinkedList();
        String sort = request.getParameter("sorting");
        String query = request.getParameter("query");
        if (sort.equals("name")) {
            for (Film f : fjc.findFilmEntities()) {
                if ((f.getName().toLowerCase()).contains(query.toLowerCase())) {
                    list.add(f);
                }
            }
        }
        if (sort.equals("category")) {
            for (Film f : fjc.findFilmEntities()) {
                if ((f.getCategoryId().toString().toLowerCase()).contains(query.toLowerCase())) {
                    list.add(f);
                }
            }
        }

        request.setAttribute("listFilms", list);
        request.getRequestDispatcher("result.jsp").forward(request, response);
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