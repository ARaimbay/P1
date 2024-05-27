
import java.io.*;
public class ReadingFromFile {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/Users/araimbay/Personal/ACADEMY/Programming/P1/myText.txt");
        int i;
        while ((i=fr.read()) != -1){
            System.out.print((char) i);
        }
    }
}