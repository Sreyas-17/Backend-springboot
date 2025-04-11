import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        if (!isValidUsername(username)) {
            out.println("<h2>Invalid username. It must start with a capital letter and have at least 3 characters.</h2>");
        } else if (!isValidPassword(password)) {
            out.println("<h2>Invalid password. It must be at least 8 characters long, contain at least one uppercase letter, one digit, and exactly one special character.</h2>");
        } else {
            out.println("<h2>Login successful!</h2>");
        }

        out.println("</body></html>");
    }

    private boolean isValidUsername(String username) {
        return username != null && username.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int uppercaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCharCount++;
            }
        }

        return uppercaseCount >= 1 && digitCount >= 1 && specialCharCount == 1;
    }
}
