import java.io.*;
import java.util.*;

public class decompress {
    public String outputFilePath = "/Users/araimbay/Personal/ACADEMY/Programming/P1/output.sc";
    public String decompressFilePath = "/Users/araimbay/Personal/ACADEMY/Programming/P1/decompress.txt";
    //decompress(textMap);
    public static void main(String[] args) {}

    public void decompress(HashMap<Integer, String> textMap) {
        /*HashMap<Integer, String> textMap = new HashMap<>();
        for (String wordString : textMap.keySet()) {
            textMap.put(textMap.get(wordString), wordString);
        }*/

        try {
            //Reading decompressed file
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outputFilePath));
            StringBuilder decompressedText = new StringBuilder();
            try {
                while (true) {
                    int textCode = dataInputStream.readInt();
                    String wordString = textMap.get(textCode);
                    if (wordString != null) {
                        decompressedText.append(wordString).append(" ");
                    } else {
                        throw new IOException("Decompression error: " + textCode);
                    }
                }
            } catch (EOFException e) {
                
            }
            dataInputStream.close();
            // Write decompress.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter(decompressFilePath));
            writer.write(decompressedText.toString().trim());
            writer.close();
        } catch (IOException e) {
            System.out.println("Successfully decompressed");
        }
    }
}