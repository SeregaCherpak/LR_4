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

@WebServlet("/main")
public class Write extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathStr = "C:\\Users\\Сергей\\Desktop\\Институт\\4\\LR2\\src\\main\\webapp\\car.json";
        Path path = Paths.get(pathStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Car> Car = new ArrayList<>();
        String jsonArrayString = "1";
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        jsonArrayString = Files.readString(path);
        if (jsonArrayString != "") {
            Type list = new TypeToken<ArrayList<Car>>() {}.getType();
            Car = gson.fromJson(jsonArrayString, list);
        }
        String data = request.getReader().readLine();
        Car.add(gson.fromJson(data, Car.class));
        Files.write(path, gson.toJson(Car).getBytes());
    }
}