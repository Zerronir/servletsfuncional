import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/get")
public class getServlet extends HttpServlet {
    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));

        req.setAttribute("suma", n1+n2);
        req.setAttribute("resta", n1-n2);
        req.setAttribute("multiplicacion", n1*n2);
        req.setAttribute("division", n1/n2);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/get.jsp");
        dispatcher.forward(req, resp);

    }
}
