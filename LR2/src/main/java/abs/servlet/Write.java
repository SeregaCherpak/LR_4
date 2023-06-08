package abs.servlet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver; // Класс для установления подключения к БД

@WebServlet("/main")
public class Write extends HttpServlet {
    private Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver(); 
            DriverManager.registerDriver(driver); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/servlet_war","Admin","0000"); 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = request.getReader().readLine();
        Car car = gson.fromJson(data, Car.class);
        String query = String.format("insert into Car(mark, model, price, year, engine_capacity) values ('%s','%s','%s','%s','%s')",
                series.getmark(),
                series.getmodel(),
                series.getprice(),
                series.getyear(),
                series.getengine_capacity());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // Выполнение SQL инструкции
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
