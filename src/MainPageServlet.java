import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MainPageServlet extends HttpServlet {
   static  Vector<Ad> ad = new Vector<>();
    static HashMap<String, Integer> id = new HashMap<String, Integer>();

    static public int sizeAd(){
	return ad.size();
    }
    static public void addAd(Ad advertisement){
        ad.add(advertisement);
    }
    static public void addAnswer(Answer ans, int i){
        ad.get(i).addAnswer(ans);
    }
    synchronized static public void addId(String name, int number){
        id.put(name, number);
    }
    synchronized static public boolean haveId(int number){
        for(Iterator it = id.entrySet().iterator(); it.hasNext() == true;){
		Map.Entry entry = (Map.Entry)it.next();
		if((int)entry.getValue() == number){
			return true;
		}
	}
	return false;
    }
    synchronized static public String MainPage(HttpSession session){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < ad.size(); i++){
	    str.append("<fieldset class='norm'>\n");
            str.append("<legend>" + ad.get(i).getTitle() + "</legend>\n");
	    str.append(ad.get(i).getText() + "\n</fieldset>\n");
	    if(session != null){
	    	str.append("<div class='ans-line'>\n");
	    	str.append("<a class='ans-item' href=\"AnswerServlet/" + i + "\">Answer</a>\n");
	    	str.append("</div>\n");
	    }
	    for(int j = 0; j < ad.get(i).getSizeAnswer(); j++){
		str.append("<fieldset class='ans'>\n");
           	str.append("<legend>" + ad.get(i).getTitleAnswer(j) + "</legend>\n");
            	str.append(ad.get(i).getTextAnswer(j) + "\n</fieldset>\n");
	    }
        }
        return str.toString();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
	if(session == null){
		request.getRequestDispatcher("general.html").include(request, response);
           	out.print(MainPage(session));
	}
	else{
		if(haveId((int)session.getAttribute("number"))){
            		request.getRequestDispatcher("generalLog.html").include(request, response);
            		out.print(MainPage(session));
        	}
		else{
            		request.getRequestDispatcher("general.html").include(request, response);
            		out.print(MainPage(session));
        	}
	}
        out.close();
    }
}
