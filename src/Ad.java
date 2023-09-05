import java.util.*;
public class Ad{
    private String name;
    private String time;
    private String text;
    private Vector<Answer> answer;

    public Ad(String name, String time, String text){
        this.name = name;
        this.time = time;
        this.text = text;
	answer = new Vector<Answer>();
    }
    public String getTitle(){
        StringBuilder str = new StringBuilder();
        str.append(name + " " + time);
        return str.toString();
    }
    public String getText(){
        return text;
    }
    public void addAnswer(Answer ans){
	answer.add(ans);
    }
public int getSizeAnswer(){
return answer.size();
}
public String getTitleAnswer(int i){
return answer.get(i).getTitle();
}
public String getTextAnswer(int i){
return answer.get(i).getText();
}
}
