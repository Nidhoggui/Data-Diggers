import java.util.ArrayList;

public class Text {
    private ArrayList<String> startText = new ArrayList<String>();
    private ArrayList<String> DescriptionText = new ArrayList<String>();
    private ArrayList<String> NameText = new ArrayList<String>();
    private ArrayList<String> StaminaText = new ArrayList<String>();
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

    public void addNameText(String text) {
        NameText.add(text);
    }
    public void addStaminaText(String text){
        StaminaText.add(text);
    }
    public String getNameText(int num) {
        return NameText.get(num);
    }
    public String getStaminaText(int num) {
        return StaminaText.get(num);
    }
    public String getCrystalText(int num) {
        return CrystalText.get(num);
    }
    public ArrayList<String> getDescriptionList(){
        return DescriptionText;
    }
    public ArrayList<ChamberContent> getContentList(){
        return ContentObject;
    }
    public ArrayList<String> getNameList(){
        return NameText;
    }
    public ArrayList<String> getStaminaList(){
        return StaminaText;
    }
}