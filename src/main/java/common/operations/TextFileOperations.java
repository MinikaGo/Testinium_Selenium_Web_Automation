package common.operations;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileOperations {

    private static BufferedWriter bufferedWriter;
    private static String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/ProductInformations.txt";

    static {
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            //bufferedWriter = new BufferedWriter(outputStreamWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeToTextFile(String productName, String productDescription, String productPrice) throws IOException {

        bufferedWriter.append(productName);
        bufferedWriter.newLine();
        bufferedWriter.append(productDescription);
        bufferedWriter.newLine();
        bufferedWriter.append(productPrice);
        bufferedWriter.newLine();
        bufferedWriter.append("--------------------------------------");

        bufferedWriter.close();
    }

    public static String getProductPrice() throws IOException {

        return Files.readAllLines(Paths.get(filePath)).get(2);
    }
}
