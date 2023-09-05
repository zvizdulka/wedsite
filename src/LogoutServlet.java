import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.invalidate();
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("general.html").include(request, response);
	out.println(MainPageServlet.MainPage(null));
        out.close();
    }
}
