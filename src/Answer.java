public class Answer{
    private String name;
    private String time;
    private String text;
   
    public Answer(String name, String time, String text){
        this.name = name;
        this.time = time;
        this.text = text;
    }
    public String getTitle(){
        StringBuilder str = new StringBuilder();
        str.append(name + " " + time);
        return str.toString();
    }
    public String getText(){
        return text;
    }
}
