package com.issac.servlet;

import com.issac.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-06-30
 * @desc
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 设置编码
        req.setCharacterEncoding("UTF-8");

        // 接收页面的值
        String[] ids = req.getParameterValues("id");
        MaintainService maintainService = new MaintainService();
        maintainService.deleteBatch(ids);

        //向页面跳转
        req.getRequestDispatcher("/List.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
