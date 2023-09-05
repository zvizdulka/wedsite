import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.Math;
import java.util.*;

public class LoginServlet extends HttpServlet {
    HashMap<String, String> data = new HashMap<String, String>();
    public void init(ServletConfig config) {
        try{
            FileReader in = new FileReader("password.txt");
            Scanner sc = new Scanner(in);
            while (sc.hasNext()) {
                String name = sc.nextLine();
                String pass = sc.nextLine();
                data.put(name, pass);
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if(passCheck(name, password)){
            request.getRequestDispatcher("generalLog.html").include(request, response);
            int i;
            do {
                i = (int) (Math.random() * (1000));
                i = i + (int) name.charAt(0);
            } while(MainPageServlet.haveId(i));
            HttpSession session = request.getSession();
	    out.println(MainPageServlet.MainPage(session));
            session.setAttribute("name", name);
            session.setAttribute("number", i);
            MainPageServlet.addId(name, i);
        }
        else{

            out.print("<h3>Sorry, username or password error!<h3>\n");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
    private boolean passCheck(String name, String pass){
	for(Iterator it = data.entrySet().iterator(); it.hasNext() == true;){
		Map.Entry entry = (Map.Entry)it.next();
		if(((String)entry.getValue()).equals(pass) && ((String)entry.getKey()).equals(name)){
			return true;
		}
	}
	return false;
    }
}
