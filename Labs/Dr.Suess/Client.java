public class Client{
    
    public static void main(String[] args){
        IndexMaker im = new IndexMaker("fish.txt");
        im.makeIndex();
        im.display();
    }
}
