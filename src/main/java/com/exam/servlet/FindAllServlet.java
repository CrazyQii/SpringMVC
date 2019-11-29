package com.exam.servlet;

import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.service.serviceImpl.UserServiceImpl;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllServlet", urlPatterns = "/FindAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 调用业务层
        UserService userService = new UserServiceImpl();
        List<User> userList =  userService.findAll();
        // 设置session
        HttpSession session = request.getSession();
        session.setAttribute("userList", userList);
        response.sendRedirect("admin/web/main.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
