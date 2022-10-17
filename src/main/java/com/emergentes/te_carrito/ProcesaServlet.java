/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.te_carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //OBTENER ACCESO AL OBJETO SESSION    
        HttpSession ses = request.getSession();
        // SE ELIMINA LA SESSION
        ses.invalidate();
        //TRANSFIERE EL CONTROL A index.jsp
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //RECUPERAR EL PRODUCTO ENVIADO DESDE FORMULARIO
        String producto = request.getParameter("producto");
        // SE OBTIENE      EL ACCESO A LA SESSION
        HttpSession ses = request.getSession();
        // SE OBTIENE LA LISTA QUE ESTA COMO ATRIBUTO DE SESSION
        ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
        // A LA COLECCION SE ADICIONA EL ELEMENTO PRODUCTO
        lista.add(producto);
        // SE REDIRECIONA A  index.jsp
        response.sendRedirect("index.jsp");
    }

   

}
