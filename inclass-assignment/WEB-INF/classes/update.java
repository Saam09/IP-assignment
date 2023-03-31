import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/movies";
        Connection conn = null;
        String title = request.getParameter("title");
        String comments = request.getParameter("comments");

        String query = "UPDATE movies SET comments = ? WHERE title = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, comments);
            stmt.setString(2, title);

            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " rows updated");

            conn.close();

            response.sendRedirect(request.getContextPath() + "/db1");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
