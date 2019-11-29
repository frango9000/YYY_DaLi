package auxp.ch37;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx02 extends HttpServlet {

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
        int temp = 1;
        for (int i = 1; i < 10; i++) {
            pw.println("<tr>");

            pw.println("<td>" + i + "</td>");
            for (int j = 1; j < 10; j++) {
                pw.println("<td>" + i * j + "</td>");
            }

            pw.println("</tr>");
        }
        pw.println("</table>");

        pw.println("</body>");
        pw.println("</html>");
    }
}
