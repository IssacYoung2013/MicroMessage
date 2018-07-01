package com.issac.servlet;

import com.issac.service.MaintainService;
import com.issac.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-06-30
 * @desc
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        QueryService queryService = new QueryService();
        out.write(queryService.queryByCommand(req.getParameter("content")));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
