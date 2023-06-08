package abs.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class Read extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathStr = "C:\\Users\\Сергей\\Desktop\\Институт\\4\\LR2\\src\\main\\webapp\\car.json";
        Path path = Paths.get(pathStr);
        response.setContentType("application/json");
        String jsonArrayString = "";
        if (Files.exists(path)) {
            jsonArrayString = Files.readString(path);
        }
        PrintWriter out = response.getWriter();
        out.print(jsonArrayString);
        out.close();
    }
}