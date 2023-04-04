import java.util.ArrayList;

public class Text {
    private ArrayList<String> start = new ArrayList<String>();

    public void addStartText(String text){
        start.add(text);
    }
    public String getStartText(int num){
        return start.get(num);
    }
    public int getStartTextLenght(){
        return start.size()-1;
    }
}