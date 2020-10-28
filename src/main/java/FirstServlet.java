import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(value="/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<String> ips = new HashSet<>();
        String ip = req.getRemoteAddr();
        String msg;

        if(ips.contains(ip)){
            msg = "No es su primera vez";
        } else {
            ips.add(ip);
            msg = "Bienvenido por primera vez";
        }

        req.setAttribute("msg", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/first.jsp");
        dispatcher.forward(req, resp);
    }
}
