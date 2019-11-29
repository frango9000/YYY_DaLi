package auxp.ch37;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx03 extends HttpServlet {

    private static int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Servlet</title>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("You are visitor #" + ++count);
        pw.println("<br>");
        pw.println(request.getRemoteHost());
        pw.println("<br>");
        pw.println(request.getRemoteAddr());
        pw.println("<br>");
        pw.println("");

        pw.println("</body>");
        pw.println("</html>");
    }
}
