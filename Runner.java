import java.io.*;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/araimbay/Personal/ACADEMY/Programming/P1/myText.txt");
        StringBuffer txt = new StringBuffer();
        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < args.length; i++) {
            txt.append(args[i] + "");
        }

        fos.write(txt.toString().getBytes());
        fos.close();
        FileInputStream fis = new FileInputStream("/Users/araimbay/Personal/ACADEMY/Programming/P1/myText.txt");
        InputStreamReader input = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(input);
        String data;

        String result = new String();
        StringBuffer txt1 = new StringBuffer();
        StringBuffer txt2 = new StringBuffer();
        File f1 = new File("even.txt");
        FileOutputStream fos1 = new FileOutputStream(f1);
        File f2 = new File("odd.txt");
        FileOutputStream fos2 = new FileOutputStream(f2);
        while ((data = br.readLine()) != null) {
            result = result.concat(data);
            String[] words = data.split(" ");
            for (int j = 0; j < words.length; j++) {
                if (j % 2 == 0) {
                    System.out.println(words[j]);
                    txt1.append(words[j] + " ");
                } else {
                    System.out.println(words[j]);
                    txt2.append(words[j] + " ");
                }
            }
        }
        fos1.write(txt1.toString().getBytes());
        fos1.close();
        fos2.write(txt2.toString().getBytes());
        fos2.close();
        br.close();
        
    public void compress(){
        String inputFileName = "/Users/araimbay/Personal/ACADEMY/Programming/P1/even.txt";
        String outputFileName = "/Users/araimbay/Personal/ACADEMY/Programming/P1/comprEven.txt";
        FileOutputStream fos = null; 
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream outputStream= null;    
        try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            outputStream = new  DeflaterOutputStream(byteArrayOutputStream); // GZIPOutputStream(byteArrayOutputStream) - use if you want unix .gz format
            outputStream.write(sb.toString().getBytes());
            String compressedText = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            fos=new FileOutputStream(outputFileName);
            fos.write(compressedText.getBytes());
            System.out.println("done compress");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if (outputStream != null) {
                    outputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if(fos != null){
                    fos.close();
                }
            }catch (Exception e) {
                    e.printStackTrace();
            }
            System.out.println("closed streams !!! "); 
        } 
    } 
} 