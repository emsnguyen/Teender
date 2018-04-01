/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.*;

/**
 *
 * @author emsnguyen
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2,//2MB
        maxFileSize = 1024*1024*10, //10MB
        maxRequestSize = 1024*1024*50 //50MB
)
public class ChangeAvatarController extends BaseAuthenticationController {

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User u = (User) request.getSession().getAttribute("user");
        request.getRequestDispatcher("changeavatar.jsp").forward(request, response);
    }
    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        User u = (User) request.getSession().getAttribute("user");
        boolean isMultipart = FileUpload.isMultipartContent(request);
        log("content-length: " + request.getContentLength());
        log("method: " + request.getMethod());
        log("character encoding: " + request.getCharacterEncoding());
        String name = "name";
        if (isMultipart) {
            log("is multipart");
            DiskFileUpload upload = new DiskFileUpload();
            List items = null;
            try {
                items = upload.parseRequest(request);
                log("items: " + items.toString());
            } catch(FileUploadException ex) {
                log("failed to parse request", ex);
            }
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                //check if the current item is a form field or an upload file
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("username")) {
                        name = item.getString();
                    }
                } else {
                    //must be an uploaded file, save to disk
                    File fullFile = new File(item.getName());
                    String realPath = getServletContext().getRealPath("/");
//                    System.out.println("real path: " + realPath);
                    File savedFile = null;
                    File prevFile;
                    prevFile = new File(realPath, "" + name + ".png");
                    if (prevFile.exists()) {
                        if (prevFile.delete()){
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }
                    prevFile = new File(realPath, "" + name + ".jpeg");
                    if (prevFile.exists()) {
                        if (prevFile.delete()){
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }
                    prevFile = new File(realPath, "" + name + ".jpg");
                    if (prevFile.exists()) {
                        if (prevFile.delete()){
                            log("old file deleted " + prevFile.getPath());
                        } else {
                            log("error deleting " + prevFile.getPath());
                        }
                    }
                    String avatarPath = "";
                    if (item.getName().contains("png")) {
                        savedFile = new File(realPath, "" + name + ".png");
                        avatarPath = u.getUsername() + ".png";
                    } else if (item.getName().contains("jpg")) {
                        savedFile = new File(realPath, "" + name + ".jpg");
                        avatarPath = u.getUsername() + ".jpg";
                    } else if (item.getName().contains("jpeg")) {
                        savedFile = new File(realPath, "" + name + ".jpeg");
                        avatarPath = u.getUsername() + ".jpeg";
                    } else {
                        request.setAttribute("error", "Vui lòng chỉ tải lên file .png, .jpeg hoặc .jpg");
                        doGet(request, response);
                    }
                    request.getSession().setAttribute("avatarPath", avatarPath);
                    try {
                        item.write(savedFile);
                        Thread.sleep(2000);
                    } catch (Exception ex) {
                        Logger.getLogger(ChangeAvatarController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    log("new images saved successfully to " + savedFile.getPath());
                }
            }
        }
        response.sendRedirect("home2.jsp");
    }
}
