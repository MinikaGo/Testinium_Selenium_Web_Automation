package common.operations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextLogger {

    String textFolderPath = System.getProperty("user.dir") + "/src/test/resources/testdata/";
    private String filePath;

    public TextLogger(String loggerType) {

        if (loggerType.equals("Beymen")) {
            filePath = textFolderPath + "BeymenProducts.txt";
        } else if (loggerType.equals("Trello")) {
            filePath = textFolderPath + "TrelloData.txt";
        }

        //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        //bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));

        //FileWriter fw = new FileWriter(filePath);
        //bufferedWriter = new BufferedWriter(fw);

        //FileWriter fileWriter = new FileWriter(filePath, false);


    }

    public void beymenTextLogger(String productName, String productDescription, String productPrice) throws IOException {

        try {

            FileWriter fw = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            bufferedWriter.write(productName);
            bufferedWriter.newLine();
            bufferedWriter.append(productDescription);
            bufferedWriter.newLine();
            bufferedWriter.append(productPrice);
            bufferedWriter.newLine();
            bufferedWriter.append("--------------------------------------");
            bufferedWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getBeymenProductPrice() throws IOException {

        //fileReader = new FileReader(filePath);

        return Files.readAllLines(Paths.get(filePath)).get(2);
    }

    public void trelloTextLogger(String boardId) {

        try {

            FileWriter fw = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            bufferedWriter.write(boardId);
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getTrelloBoardId() throws IOException {
        return Files.readAllLines(Paths.get(filePath)).get(0);
    }
}
