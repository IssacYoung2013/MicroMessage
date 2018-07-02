package com.issac.servlet;

import com.issac.entity.Page;
import com.issac.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

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
        String currentPage = req.getParameter("currentPage");
        // 创建分页对象
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if(currentPage == null || !pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }
        else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }

        QueryService listService = new QueryService();

        // 查询消息列表并传给页面
        req.setAttribute("messageList", listService.queryMessageListByPage(command, description,page));
        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        req.setAttribute("page", page);

        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}