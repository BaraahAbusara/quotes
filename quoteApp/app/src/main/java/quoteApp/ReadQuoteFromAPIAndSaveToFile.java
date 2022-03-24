package quoteApp;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import static quoteApp.ReadFromFile.fileDemoReader;
import static quoteApp.ReadFromFile.randomQuotePicker;

public class ReadQuoteFromAPIAndSaveToFile {

   public static void saveQuoteToFile(QuoteAPI data) throws IOException {
//       System.out.println("in save data");
       //step 1 : read data we already have
       String firstJsonData = fileDemoReader();
//       System.out.println("-------------firstDataJson ---------\n "+firstJsonData);
       //step 2 : parse the data from JSON format to ArrayList of objects
       Gson gsonData = new Gson();
       Quote[] quoteArray = gsonData.fromJson(firstJsonData , Quote[].class);
       ArrayList <Quote> quoteArrayList = new ArrayList<Quote>();
       quoteArrayList.addAll(Arrays.asList(quoteArray));
//       System.out.println("-------------firstDataJava ---------\n "+quoteArrayList.toString());

       //step 3 : add the quote to the ArrayList
       Quote newQuote = new Quote(data.quoteText,data.quoteAuthor);
       quoteArrayList.add(newQuote);

       //step 4 : return it to JSON format and  write it in the file.
        File file = new File("./recentquotes.json");
        try (FileWriter fileWriter = new FileWriter(file)) {
            gsonData.toJson(quoteArrayList, fileWriter);
        }




// https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html#:~:text=You%20can%20append%20text%20into,the%20file%20in%20append%20mode.
//       try (FileWriter fileWriter = new FileWriter("./quotesFile.json",true)) { // the problem is that we add object not as array of objects.
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            PrintWriter printWriter = new PrintWriter(writer);
//            Quote quoteQuote = new Quote(data.quoteText, data.quoteAuthor);
//            String jsonFormat = gson.toJson(quoteQuote);
//            printWriter.println(jsonFormat);
//            printWriter.flush();
//        }
    }
       public static void ReadQuoteFromAPI(){

        try{ //when we are online bring a random quote from the API
            QuoteAPI quote;
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader input = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(input);
            String quoteDataJson = reader.readLine();

            Gson gson = new Gson();
            quote  = gson.fromJson(quoteDataJson,QuoteAPI.class) ;
            System.out.println(quote.quoteText+"\n"+quote.quoteAuthor);
            Quote quoteToSave = new Quote(quote.quoteText,quote.quoteAuthor);

            saveQuoteToFile(quote); //save the quote to our data file .



        }catch (IOException err) { //when we loose the connection
            Quote quote;
//            System.out.println("From the catch in ReadQuoteFromAPI");
            String dataJson = fileDemoReader(); // this is going to read from the qoutesFile.json
            quote = randomQuotePicker(dataJson);

            System.out.println(quote.text+"\n"+quote.author);
        }

    }

}
