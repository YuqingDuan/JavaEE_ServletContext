package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext context = getServletContext();
        // 获取给定资源在服务器上的绝对路径
        String path = context.getRealPath("file/config.properties");
        // 创建Properties对象
        Properties properties = new Properties();
        InputStream is = new FileInputStream(path);
        properties.load(is);
        // 获取name属性对应的值
        String nameValue = properties.getProperty("name");
        // 打印结果
        System.out.println("name: " + nameValue);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
