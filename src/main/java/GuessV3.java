import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(value="/guess3")
public class GuessV3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random r = new Random();
        int number= r.nextInt(10)+1;

        HttpSession session = req.getSession();
        session.setAttribute("secretNumber", number);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/guess3.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int numero = Integer.parseInt(req.getParameter("num"));
        int n = 0;

        HttpSession session = req.getSession();
        n = (Integer) session.getAttribute("secretNumber");

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

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/guess3.jsp");
        dispatcher.forward(req, resp);
    }
}
