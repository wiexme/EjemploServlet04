/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje04.controlador;

import eje04.modelo.dao.PersonaDao;
import eje04.modelo.dao.impl.PersonaDaoImpl;
import eje04.modelo.entidad.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WIEXME
 */
@WebServlet(name = "Crud", urlPatterns = {"/crud"})
public class Crud extends HttpServlet {

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
        
        PersonaDao dao = new PersonaDaoImpl();
        Persona persona = new Persona();
        
        String idpersona = request.getParameter("idpersona");idpersona = idpersona == null?"":idpersona;
        String nombre = request.getParameter("nombre");nombre = nombre == null?"":nombre;
        String apellido_pat = request.getParameter("apellido_pat");apellido_pat = apellido_pat == null?"":apellido_pat;
        String apellido_mat = request.getParameter("apellido_mat");apellido_mat = apellido_mat == null?"":apellido_mat;
        String dni = request.getParameter("dni");dni = dni == null?"":dni;
        String action = request.getParameter("action");action = action == null?"":action;
        String mensaje = "";
        
        switch(action){
            case"insertar":
                persona.setIdpersona(idpersona);
                persona.setNombre(nombre);
                persona.setApellidoPat(apellido_pat);
                persona.setApellidoMat(apellido_mat);
                persona.setDni(dni);
                if ( dao.agregarPersona(persona)) {
                    mensaje = "Se Registro Satisfactoriamente...";
                } else {
                     mensaje = "Orrorrrrrr al Registrar...";
                }
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("agregar.jsp").forward(request, response);
                break;
            case"listar":
                request.setAttribute("listaPersona", dao.listarPersona(""));
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            case"eliminar":
                if (dao.eliminarPersona(idpersona)) {
                    mensaje = "Se Elimino Satisfactoriamente...";
                    
                } else {
                    mensaje = "Orrorrrrrr No se Elimino...";
                }
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("listaPersona", dao.listarPersona(""));
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            default:
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
