import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.lang.Object;
public class PutAdServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String text = request.getParameter("text");
        Date data = new Date();
        HttpSession session = request.getSession(false);
        String name = (String)session.getAttribute("name");
        Ad a = new Ad(name, data.toString(), text);
        MainPageServlet.addAd(a);
	String path = request.getContextPath() + "/MainPageServlet";
	response.sendRedirect(path);
    }
}
