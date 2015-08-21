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
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CreateFilmServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebMoviesPU")
    private EntityManagerFactory emf;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FilmJpaController fjc = new FilmJpaController(utx, emf);
        CategoryJpaController cjc = new CategoryJpaController(utx, emf);

        String evt = request.getParameter("evt");
        switch (evt) {
            case "create":
                Film f = new Film();
                f.setName(request.getParameter("name"));
                f.setOpenning(request.getParameter("openDay"));
                f.setCategoryId(cjc.findCategory(Integer.parseInt(request.getParameter("category"))));
                f.setImg(request.getParameter("imgPath"));
                f.setLinkVideo(request.getParameter("linkTrailer"));
                f.setPrice(Float.parseFloat(request.getParameter("price")));
                if (request.getParameter("hot")!=null && request.getParameter("hot").equals("true")) {
                    f.setIsHot(true);
                } else {
                    f.setIsHot(false);
                }
                f.setDescript(request.getParameter("description"));

                fjc.create(f);
                
                response.sendRedirect("AllFilms");
                break;
                
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                
                Film f2 = fjc.findFilm(id);
                request.setAttribute("film", f2);
                
                List<Category> listC = cjc.findCategoryEntities();
                request.setAttribute("listCategories", listC);
                
                RequestDispatcher rd = request.getRequestDispatcher("admin/editFilm.jsp");
                rd.forward(request, response);
                break;
                
            case "doEdit":
                int id2 = Integer.parseInt(request.getParameter("id"));
                
                Film f3 = fjc.findFilm(id2);
                f3.setName(request.getParameter("name"));
                f3.setOpenning(request.getParameter("openDay"));
                f3.setCategoryId(cjc.findCategory(Integer.parseInt(request.getParameter("category"))));
                f3.setImg(request.getParameter("imgPath"));
                f3.setLinkVideo(request.getParameter("linkTrailer"));
                f3.setPrice(Float.parseFloat(request.getParameter("price")));
                if (request.getParameter("hot")!=null && request.getParameter("hot").equals("true")) {
                    f3.setIsHot(true);
                } else {
                    f3.setIsHot(false);
                }
                f3.setDescript(request.getParameter("description"));
                fjc.edit(f3);
                
                response.sendRedirect("AllFilms");
                break;
                
            case "delete":
                int id3 = Integer.parseInt(request.getParameter("id"));
                fjc.destroy(id3);
                
                response.sendRedirect("AllFilms");
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
