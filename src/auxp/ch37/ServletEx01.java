package auxp.ch37;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Servlet</title>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("<table border = 1>");
        pw.println("<tr><th>Number</th><th>Factorial</th></tr>");
        int temp = 1;
        for (int i = 0; i < 11; i++) {
            pw.println("<tr><td>" + i + " </td><td>" + temp + "</td></tr>");
            temp *= i + 1;

        }
        pw.println("</table>");

        pw.println("</body>");
        pw.println("</html>");
    }
}
