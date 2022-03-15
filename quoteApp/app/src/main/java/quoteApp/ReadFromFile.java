package quoteApp;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ReadFromFile {
    public static String fileDemoReader() { // from instructor's code

        ClassLoader classLoader = App.class.getClassLoader();
        String path = classLoader.getResource("recentquotes.json").getPath();
//        String path = classLoader.getResource("quotesFile.json").getPath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path) );
            String line = reader.readLine();
            String lines ="";
            while (line != null) {
                lines+=line;
                line = reader.readLine();
            }

            reader.close();
            return lines ;

        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        } finally {
            System.out.println("Program executed");
        }
        return "";
    }
    public static Quote randomQuotePicker (String dataJson)
    {
//      https://howtodoinjava.com/gson/gson-parse-json-array/?fbclid=IwAR3hOnoSCa9CVVfDaAosBRn0uPI7wTm3Bks3V47rCAirBgnxzoBt5HWNQ58
        Gson gson = new Gson();
        Quote[] quoteArray = gson.fromJson(dataJson , Quote[].class);

//        for(Quote quote : quoteArray) {
//            System.out.println(quote.toString());
//        }

//        // https://www.w3schools.in/java-program/generate-random-numbers/
        Random rand = new Random();
        int minRange = 0, maxRange= quoteArray.length ;
        int randomIdx = rand.nextInt(maxRange - minRange) + minRange;
        return quoteArray[randomIdx];

    }
}
