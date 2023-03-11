import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class p1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final Object[][] objArr = new Object[3][2];

        objArr[0][0] = "John";
        objArr[0][1] = 25;

        objArr[1][0] = "Jack";
        objArr[1][1] = 30;

        objArr[2][0] = "Jill";
        objArr[2][1] = 45;

        int x = Integer.parseInt(request.getParameter("sel"));
        x = x - 1;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Data of " + x + ":</h1><br/>");
        out.println("<h1>" + objArr[x][0] + "</h1>");
        out.println("<h1>" + objArr[x][1] + "</h1>");
        out.println("</body></html>");
    }
}
