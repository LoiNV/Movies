/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.CategoryJpaController;
import controller.FilmJpaController;
import entities.Film;
import java.io.IOException;
import java.util.Map;
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
public class DoEditServlet extends HttpServlet {
    @PersistenceUnit(unitName = "WebMoviesPU")
    private EntityManagerFactory emf;
    @Resource
    private javax.transaction.UserTransaction utx;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map map = UploadFile.upload(request);
        
        if (map != null) {
            FilmJpaController fjc = new FilmJpaController(utx, emf);
            CategoryJpaController cjc = new CategoryJpaController(utx, emf);
            
            Film f = fjc.findFilm(Integer.parseInt(map.get("id").toString()));
            f.setName(map.get("name").toString());
            f.setOpenning(map.get("openDay").toString());
            f.setCategoryId(cjc.findCategory(Integer.parseInt(map.get("category").toString()))); 
            
            if ((map.get("img").toString()).equals("changed")) {
                String imgPath = map.get("imgPath").toString();
                String src = imgPath.substring(imgPath.indexOf("images"));
                f.setImg(src);
            }
            if (!(map.get("linkVideo").toString().trim()).equals("")) {                
                f.setLinkVideo(map.get("linkVideo").toString());
            }
            
            f.setPrice(Float.parseFloat(map.get("price").toString()));
            try {
                f.setIsHot(Boolean.parseBoolean(map.get("hot").toString()));
            } catch (Exception e) {
                f.setIsHot(false);
            }            
            f.setDescript(map.get("description").toString());

            fjc.edit(f);
        }
       
        response.sendRedirect("admin");
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
