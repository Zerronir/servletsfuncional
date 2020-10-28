import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/post")
public class postServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String dni = req.getParameter("dni");

        if(isDNIValid(dni)) {
            req.setAttribute("nom", nom);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/post2.jsp");
        dispatcher.forward(req, resp);
    }

    private boolean isDNIValid(String dni) {

        Pattern pattern = Pattern.compile("^(\\d{8})(.)($)");
        Matcher matcher = pattern.matcher(dni);

        if(matcher.matches()){
            char lletra = matcher.group(2).toUpperCase().charAt(0);
            int numero = Integer.parseInt(matcher.group(1));
            int modulo = numero % 23;
            char lletraCalc = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(modulo);

            if(lletra == lletraCalc) {
                return true;
            }
            return false;
        }

        return false;
    }
}
