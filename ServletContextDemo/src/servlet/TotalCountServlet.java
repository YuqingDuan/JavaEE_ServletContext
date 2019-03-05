package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TotalCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取值(这次不会出现空指针异常)
        int totalCount = (int) getServletContext().getAttribute("totalCount");
        // 输出到页面
        resp.getWriter().write("totalCount: " + totalCount);
    }
}
