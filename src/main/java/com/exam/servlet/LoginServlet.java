package com.exam.servlet;

import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 接收表单数据
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        // 调用业务层完成登录
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        // 根据登录是否成功进行页面跳转
        if (user != null) { // 登录成功
            System.out.println("登录成功");
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //req.getRequestDispatcher("/admin/web/main.html").forward(req, res);
            res.sendRedirect("/admin/web/main.html");
        } else { // 登录失败
            System.out.println("登录失败");
            // 重定向
            res.sendRedirect("/admin/login/login.html");
        }
    }

    public void  doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        this.doGet(req, res);
    }
}
