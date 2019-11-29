package com.exam.servlet;

import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(id, username, password);

        // 调用业务层修改信息
        UserService userService = new UserServiceImpl();
        int n = userService.updateUser(user);
        if (n > 0) {
            response.sendRedirect("/FindAllServlet");
        } else {
            request.setAttribute("error", "修改信息失败");
            response.sendRedirect("/FindAllServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        this.doPost(request, response);
    }
}
