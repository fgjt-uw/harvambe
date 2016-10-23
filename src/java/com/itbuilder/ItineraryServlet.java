
package com.itbuilder;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alyacarina
 */
public class ItineraryServlet extends HttpServlet {

    private ServletContext context;
    private Itinerary it = null;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }
    
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
        
        String action = request.getParameter("action");
        String id = request.getParameter("actid");
        
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try { 
            if(it!=null && !it.isValid()){
                it = null;
            }
            
            if(action.equals("submit")){
                if(id.equals("add")){
                    double latitude = Double.parseDouble(request.getParameter("lat"));
                    double longitude = Double.parseDouble(request.getParameter("long"));
                    if(it == null){
                        it = new Itinerary(latitude, longitude);
                    } else {
                        it.addNode(latitude, longitude);
                    }
                } else if(id.equals("remove")) {
                    if(it == null){
                        // do nothing
                    } else {
                        it.removeNode(Integer.parseInt(request.getParameter("id")));
                    }
                }
                if(it == null){
                    out.println("<p> null </p>");
                } else {
                    out.println("<p>"+it.getJSONString()+"</p>");
                }
            } else {
                out.println("<p> umm </p>");
            }
        } finally {
            out.close();
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
