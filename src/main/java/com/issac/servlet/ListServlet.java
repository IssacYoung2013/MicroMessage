package com.issac.servlet;

import com.issac.bean.Message;
import com.issac.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author:  ywy
 * date:  2018-06-29
 * desc:
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 设置编码
        req.setCharacterEncoding("UTF-8");

        // 接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");

        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        ListService listService = new ListService();

        // 查询消息列表并传给页面
        req.setAttribute("messageList", listService.queryMessageList(command, description));

        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}