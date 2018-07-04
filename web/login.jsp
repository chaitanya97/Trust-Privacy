<%-- 
    Document   : login
    Created on : May 9, 2018, 5:45:09 PM
    Author     : Sathvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("lemail");    
    String pwd = request.getParameter("lpassword");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auth",
            "root", "8341341280");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from user where email='" + userid + "' and passcode='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("SelectOption.html");
    } else {
        out.println("Invalid password <a href='index.html'>try again</a>");
    }
%>