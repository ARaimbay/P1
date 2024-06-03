import java.io.*;
import java.util.*;

public class Compress {

    public String inputFilePath = "/Users/araimbay/Personal/ACADEMY/Programming/P1/input.txt";
    public String outputFilePath = "/Users/araimbay/Personal/ACADEMY/Programming/P1/output.sc";

    public HashMap <String, Integer> compress() {
        HashMap <String, Integer> textMap = new HashMap<>();
        try {
            //Reading input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder inputText = new StringBuilder();
            String byLine;
            while ((byLine = reader.readLine()) != null) {
                inputText.append(byLine).append("\n");
            }
            reader.close();

            // Assigning codes to the each word

            int code = 0;
            String[] wordStrings = inputText.toString().split("\\s+");
            for (String wordString : wordStrings) {
                if (!textMap.containsKey(wordString)) {
                    textMap.put(wordString, code++);
                }
            }

            //Compress to output.sc

            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFilePath));
            for (String wordString : wordStrings) {
                int textCode = textMap.get(wordString);
                dataOutputStream.writeInt(textCode);
            }
            dataOutputStream.close();

        } catch (IOException e) {
            System.out.println("Successfully compressed"); 
        }
        return textMap;
    }

    public static void main(String[] args) {
    }
}