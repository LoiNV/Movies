/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.CategoryJpaController;
import entities.Category;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebMoviesPU")
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryJpaController cjc = new CategoryJpaController(utx, emf);
        String evt = request.getParameter("evt");
        switch (evt) {
            case "create":
                Category c = new Category();
                c.setName(request.getParameter("createName"));
                cjc.create(c);
                response.sendRedirect("AllCategories");
                break;
                
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));                
                Category c2 = cjc.findCategory(id);
                request.setAttribute("category", c2);
                RequestDispatcher rd = request.getRequestDispatcher("admin/editCategory.jsp");
                rd.forward(request, response);
                break;
                
            case "doEdit":
                int id2 = Integer.parseInt(request.getParameter("id"));                
                String name = request.getParameter("editName");                
                cjc.edit(id2, name);
                response.sendRedirect("AllCategories");
                break;
                
            case "delete":
                int id3 = Integer.parseInt(request.getParameter("id")); 
                cjc.destroy(id3);
                response.sendRedirect("AllCategories");
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
