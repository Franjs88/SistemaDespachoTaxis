/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.accesodatos.Taxi;
import modelo.logicanegocio.FachadaDeSesion;
import modelo.logicanegocio.InfoTaxi;

/**
 *
 * @author fran
 */
@WebServlet(name = "ControladorServlet", urlPatterns = {"/ControladorServlet"})
public class ControladorServlet extends HttpServlet {

    @EJB
    FachadaDeSesion ejb;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String peticion = request.getParameter("solicitud");

        if (peticion.equals("crearSolicitud")) {

            String nombre = request.getParameter("Nombre");
            String direccion = request.getParameter("Direccion");
            String telefono = request.getParameter("Telefono");
            //Taxi taxiOptimo = new Taxi("libre", "", "Avenida de Oporto 5, Madrid", 1);
            //Solicitud solicitud = new Solicitud(3, nombre, "04/05/2013", direccion, telefono, 1);
            //obtenerTaxi()
            //insertarSolicitud()
            //request.setAttribute("taxi", taxiOptimo);
            //request.setAttribute("solicitud", solicitud);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/taxiOptimo.jsp");
            dispatcher.forward(request, response);

        } else if (peticion.equals("mostrarMensaje")) {
            String nombreCliente = (String) request.getParameter("nombreCliente");
            String destino = (String) request.getParameter("destino");
            String telefono = (String) request.getParameter("telefono");
            //Solicitud solicitud = new Solicitud(3, nombreCliente, "04/05/2013", destino, telefono, 1);
            //Taxi taxiOptimo = new Taxi("libre", "", "Avenida de Oporto 5, Madrid", 1);
            //request.setAttribute("taxi", taxiOptimo);
            //request.setAttribute("solicitud", solicitud);
            //request.setAttribute("nombreCliente", nombreCliente);
            //request.setAttribute("destino", destino);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mensaje.jsp");
            dispatcher.forward(request, response);
        } else if (peticion.equals("infoTaxi")) {
            //consultaInfoTaxi();
            String idTaxi = request.getParameter("id");
            String direccion = request.getParameter("direccion");
            request.setAttribute("id", idTaxi);
            request.setAttribute("direccion", direccion);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/infoTaxi.jsp");
            dispatcher.forward(request, response);
        } else if (peticion.equals("obtenerTaxis")) {
            List<Integer> listaTaxis = ejb.consultaListaTaxis();
            //listaTaxis.add(1);
            
            ArrayList<InfoTaxi> listaInfoTaxis = new ArrayList<InfoTaxi>();
            /*for(int i = 0;i < listaTaxis.size();i++){
                listaInfoTaxis.add(ejb.consultaInfoTaxi(listaTaxis.get(i)));
            }
            //InfoTaxi if1 = new InfoTaxi("libre","Paseo de la Castellana 101, Madrid",1);
            //listaInfoTaxis.add(if1);
            request.setAttribute("infoTaxis",listaInfoTaxis);*/
            request.setAttribute("taxis", listaTaxis);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listaTaxis.jsp");
            dispatcher.forward(request, response);
        } else if (peticion.equals("enviarMensaje")) {
            //enviarMensaje()
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
