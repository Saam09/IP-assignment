import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            if (conn != null) {
                out.println("<h1> No issues in Connection</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            // display all the students' marks
            sql = "SELECT * FROM movies";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            out.println("<html><head><title>Movie List</title></head><body>");
            out.println("Movie List");
            out.println(
                    "<table border=\"1\"><tr><th>Title</th><th>Year</th><th>Rating</th><th>Country</th><th>Comments</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("title") + "</td>");
                out.println("<td>" + rs.getInt("year") + "</td>");
                out.println("<td>" + rs.getDouble("rating") + "</td>");
                out.println("<td>" + rs.getString("country") + "</td>");
                out.println("<td>" + rs.getString("comments") + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}