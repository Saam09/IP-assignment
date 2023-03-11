import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class p2 extends HttpServlet {

    String stud_list[][] = { { "4051", "ABC", "99", "1" }, { "4043", "DEF", "95", "3" }, { "4062", "GHI", "89", "5" },
            { "4060", "JKL", "93", "4" },
            { "4003", "MNO", "98", "2" } };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String x = request.getParameter("reg_no");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        for (int i = 0; i < 5; i++) {
            if (x.equals(stud_list[i][0])) {
                out.println("<html><body>");
                out.println("<h1>Data of " + x + ":</h1><br/>");
                out.println("<h1>Name: " + stud_list[i][1] + "</h1>");
                out.println("<h1>Mark: " + stud_list[i][2] + "</h1>");
                out.println("<h1>Rank: " + stud_list[i][3] + "</h1>");
                out.println("</body></html>");
                return;
            }
        }
        out.println("<html><head></head><body><h1>Register number not found</h1></body></html>");
    }
}
