public class IndexEntry{
    private String word, lineNum;
    
    public IndexEntry(String word, String lineNum){
        this.word = word;
        this.lineNum = lineNum;
    }
    
    public String getWord(){
        return word;
    }
    
    public String getLineNum(){
        return lineNum;
    }
    
    public void setLineNum(String addNum){
        lineNum += addNum;
    }
    
    public String toString(){
        return word + " " + lineNum;
    }
}