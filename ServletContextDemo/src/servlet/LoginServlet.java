package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前台用户输入的数据
        String username = req.getParameter("un");
        String password = req.getParameter("pw");
        System.out.println("username: " + username + ", password: " + password);

        // 数据校验
        PrintWriter pw = resp.getWriter();
        if ("admin".equals(username) && "123".equals(password)) {
            // 成功次数的累加
            int totalCount = 0;
            ServletContext context = getServletContext();
            Object obj = context.getAttribute("totalCount");
            if (obj != null) {
                totalCount = (int) obj;
            }
            context.setAttribute("totalCount", ++totalCount);

            // 要想重定向到其他页面, 先要设置状态码
            resp.setStatus(302);
            // 设置要跳转的页面
            resp.setHeader("Location", "success.html");
        } else {
            pw.write("login failed!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
