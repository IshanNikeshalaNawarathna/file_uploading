/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Ishan
 */
@MultipartConfig
@WebServlet(name = "Uploading", urlPatterns = {"/Uploading"})
public class Uploading extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        
        String application = request.getServletContext().getRealPath("");
        File newFile = new File(application+"//files//hello.png");

        Part part = request.getPart("file");
        InputStream inputStream = part.getInputStream();

        Files.copy(inputStream, newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
