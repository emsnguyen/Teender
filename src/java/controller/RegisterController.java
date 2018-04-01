/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import utils.InputValidator;
@MultipartConfig(fileSizeThreshold = 1024*1024*2,//2MB
        maxFileSize = 1024*1024*10, //10MB
        maxRequestSize = 1024*1024*50 //50MB
)
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        String username = "";
        String password = "";
        String passwordcf = "";
        PrintWriter out = response.getWriter();
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
                    switch (fieldName) {
                        case "username":
                            username = item.getString();
                            name = username;
                            break;
                        case "password":
                            password = item.getString();
                            break;
                        case "passwordcf":
                            passwordcf = item.getString();
                            break;
                        default:
                            break;
                    }
                } else {
                    //must be an uploaded file, save to disk
                    File fullFile = new File(item.getName());
                    System.out.println("item.name:" + item.getName());
                    
                    String realPath = getServletContext().getRealPath("/");
                    System.out.println("real context path in register controller: " + getServletContext().getRealPath("/"));
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
                    
                    if (item.getName().contains("png")) {
                        savedFile = new File(realPath, "" + name + ".png");
                    } else if (item.getName().contains("jpg")) {
                        savedFile = new File(realPath, "" + name + ".jpg");
                    } else if (item.getName().contains("jpeg")) {
                        savedFile = new File(realPath, "" + name + ".jpeg");
                    } else {
                        request.setAttribute("error", "Vui lòng chỉ tải lên file .png, .jpeg hoặc .jpg");
                        doGet(request, response);
                    }
                    try {
                        item.write(savedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(ChangeAvatarController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    log("new images saved successfully to " + savedFile.getPath());
                }
            }
        }
        UserDAO userDB = new UserDAO();
        String checkUsername = InputValidator.isUsernameValid(username);
        String checkPassword = InputValidator.isPasswordValid(password);
        if (!checkUsername.equals("") || !checkPassword.equals("")) {
            request.setAttribute("wrongUsername", checkUsername);
            request.setAttribute("wrongPassword", checkPassword);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (userDB.isUsernameExisted(username.trim())) {
            request.setAttribute("wrongUsername", "Tên đăng nhập đã tồn tại!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }  else if (!passwordcf.equals(password)) {
            request.setAttribute("wrongPasswordCf", "Mật khẩu không khớp");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            if (userDB.insert(u)) {
                 //set avatar path 
                String realPath = getServletContext().getRealPath("/");
                String jpg = realPath + u.getUsername()+ ".jpg";
                File fileJpg = new File(jpg);
                String png = realPath + u.getUsername() + ".png";
                File filePng = new File(png);
                String jpeg = realPath + u.getUsername() + ".jpeg";
                File fileJpeg = new File(jpeg);
                if (fileJpg.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpg");
                } else if (filePng.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".png");
                } else if (fileJpeg.exists()) {
                    request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpeg");
                } else {
                    request.getSession().setAttribute("avatarPath", "img/logo.jpg");
                }
                //get user id
                int id = userDB.getID(username);
                u.setUserID(id);
                //set user attribute
                request.getSession().setAttribute("user", u);
                request.getSession().setAttribute("userID", id);
                response.sendRedirect("setting");
            } else {
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

}
