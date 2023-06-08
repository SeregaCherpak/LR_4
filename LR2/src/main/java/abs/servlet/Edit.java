package abs.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import com.mysql.cj.jdbc.Driver;
@WebServlet("/edit")
public class Edit {
    Connection connection;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver(); 
            DriverManager.registerDriver(driver); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/servlet_war", "root", ""); 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = String.format("select * from series where mark=" + request.getParameter("mark"));
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Car car = new Car(resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("price"),
                        resultSet.getString("year"),
                        resultSet.getString("engine_capacity");
                request.setAttribute("Car", car);
            }
            sc.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
