import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = getServletContext().getRealPath("/WEB-INF/applicationContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext(path);

        HelloWorld hello = (HelloWorld) context.getBean("helloWorld");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println(hello.displayMessage());
    }
}
