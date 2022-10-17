<%-- 
    Document   : index
    Created on : 16 oct. de 2022, 18:19:40
    Author     : RONALD ALEJO MAMANI
--%>
<%@page import="java.util.ArrayList"%>
<%
    //VERIFICACION SI EXISTE LA COLECCION EN EL OBJETO SESSION
    if (session.getAttribute("lista") == null) {
            //INICIALIZAR LA LISTA AUXILIAR
            ArrayList<String> lis = new ArrayList<String>();
            //CREANDO UN ARRAY ATRIBUTO CON UNA COLECCION VASIA
            session.setAttribute("lista", lis);
        }
        //SE OBTIENE LA COLLECION LISTA QUE ESTA COMO ATRIBUTO DE SESSION
    ArrayList<String> lista = (ArrayList<String>)session.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CARRITO DE COMPRAS</h1>
        <p>INGRESE LOS PRODUCTOS QUE DEASEA</p>
        <form action="ProcesaServlet" method="POST">
            Producto: <input type="text" name="producto"> 
            <input type="submit" value="enviar">
        </form>
        <br>
        <a href="ProcesaServlet">VACIAR EL CARRITO</a>
        <h3>CONTENIDO DEL CARRITO:</h3>
        <ul>
            <%
                if (lista != null) {
                        for (String item : lista) {
            %>            
                                <li><%= item %></li>
            <%                    
                            }
                    }
            %>
            
        </ul>
        
    </body>
</html>
