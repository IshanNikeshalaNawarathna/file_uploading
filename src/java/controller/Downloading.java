/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ishan
 */
@WebServlet(name = "Downloading", urlPatterns = {"/Downloading"})
public class Downloading extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String application = request.getServletContext().getRealPath("");
        File newFile = new File(application + "//files//hello.png");
        
        OutputStream outputStream = response.getOutputStream();
        
        response.setHeader("Content-Disposition", "attachment;filename=new.png");

        Files.copy(newFile.toPath(),outputStream);
        
    }

}
