import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class AnswerServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uri = request.getRequestURI();
		String s = uri.substring(21, uri.length());
		int id = Integer.parseInt(s);
        out.print(MainPage(id));
		out.close();
    }

    public String MainPage(int id){
		StringBuilder str = new StringBuilder();
		str.append("<html>\n");
		str.append("<head>\n");
   		str.append("<meta charset=\"ISO-8859-1\">\n");
		str.append("<link rel=\"stylesheet\" href=\"/style2.css\"/>\n");
		str.append("<title>Add an answer</title>\n");
		str.append("</head>\n");
		str.append("<body>\n");
		str.append("<h1>Bulletin board</h1>\n");
		str.append("<div class='header-line'>\n");
		str.append("<a class='nav-item' href=\"http://localhost:8080/lab15/MainPageServlet\">Main menu</a>\n");
		str.append("</div>\n");
		str.append("<h2>Add an answer</h2>\n");
		str.append("<form action=\"PutAnswerServlet\\" + id +"\" method=\"post\">\n");
		str.append("<input type=\"text\" name=\"text\" id=\"text\" placeholder=\"AD TEXT\"><br>\n");
		str.append("<input type=\"submit\" value=\"ADD\">\n");
		str.append("</form>\n");
		str.append("</body>\n");
		str.append("</html>\n");
		return str.toString();
    }

}
