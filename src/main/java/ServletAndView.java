import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value="/mvc")
public class ServletAndView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = "Bill";
        req.setAttribute("nom", nom);

        int temp = 26;
        req.setAttribute("temperature", temp);

        int money = 1_000_000;
        req.setAttribute("money", money);

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(23, "Raul"));
        personas.add(new Persona(22, "Pedro"));
        personas.add(new Persona(21, "Monica"));
        personas.add(new Persona(25, "Anna"));

        req.setAttribute("personas", personas);


        Map<String, Integer> clasesperdia = new HashMap<>();
        clasesperdia.put("Dilluns", 5);
        clasesperdia.put("Dimarts", 5);
        clasesperdia.put("Dimecres", 5);
        clasesperdia.put("Dijous", 5);
        clasesperdia.put("Divendres", 5);

        req.setAttribute("clases", clasesperdia);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view.jsp");
        dispatcher.forward(req, resp);
    }
}
