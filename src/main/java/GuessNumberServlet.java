import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(value="/guess")
public class GuessNumberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random r = new Random();
        int number= r.nextInt(10)+1;

        req.setAttribute("numero", number);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/guess.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int numero = Integer.parseInt(req.getParameter("numero"));
        int n = Integer.parseInt(req.getParameter("num"));
        String msg = "";

        if(n == numero) {
            req.setAttribute("finish", true);
        } else if(n < numero) {
            msg = "El número es más pequeño";
        } else {
            msg = "El número es más grande";
        }

        req.setAttribute("msg", msg);
        req.setAttribute("numero", numero);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/guess.jsp");
        dispatcher.forward(req, resp);
    }
}
