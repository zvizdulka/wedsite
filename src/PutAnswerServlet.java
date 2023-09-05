import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.lang.Object;
public class PutAnswerServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String text = request.getParameter("text");
        Date data = new Date();
        HttpSession session = request.getSession(false);
        String name = (String)session.getAttribute("name");
	String uri = request.getRequestURI();
	String s = uri.substring(38, uri.length());
	int id = Integer.parseInt(s);
        Answer a = new Answer(name, data.toString(), text);
        MainPageServlet.addAnswer(a, id);
	String path = request.getContextPath() + "/MainPageServlet";
	response.sendRedirect(path);
    }
}
