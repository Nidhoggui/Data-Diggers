import java.util.ArrayList;

public class Text {
    private ArrayList<String> startText = new ArrayList<String>();
    private ArrayList<String> DescriptionText = new ArrayList<String>();
    private ArrayList<String> CrystalText = new ArrayList<String>();
    private ArrayList<ChamberContent> ContentObject = new ArrayList<ChamberContent>();

    public void addStartText(String text){
        startText.add(text);
    }
    public String getStartText(int num){
        return startText.get(num);
    }
    public void addDescriptionText(String text){
        DescriptionText.add(text);
    }
    public String getDescriptionText(int num){
        return DescriptionText.get(num);
    }
    public void addContentObject(ChamberContent content){
        ContentObject.add(content);
    }
    public ChamberContent getContentObject(int num){
        return ContentObject.get(num);
    }
    public int getStartTextLenght(){
        return startText.size()-1;
    }
    public void addCrystalText(String text) {
        CrystalText.add(text);
    }
    public String getCrystalText(int num) {
        return CrystalText.get(num);
    }}