import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
public class Runner {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/araimbay/Personal/ACADEMY/Programming/P1/myText.txt");
        Scanner scan = new Scanner(file);
        //get rid of other characters like numbers use delimeter
        scan.useDelimiter("[^A-Za-z]+"); \\regular expressions

        String fileContent = "";
        while(scan.hasNextLine()) {
            //fileContent = fileContent.concat(scan.next() + "\n");
            System.out.println(scan.next());
        }


        FileWriter writer = new FileWriter("/Users/araimbay/Personal/ACADEMY/Programming/P1/Output.txt");
        writer.write(fileContent);
        writer.close();
    
    }

}