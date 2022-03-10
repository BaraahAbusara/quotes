/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quoteApp;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static quoteApp.App.fileDemoReader;
import static quoteApp.App.randomQoutePicker;

class AppTest {
    @Test
  void testRandomQuote()
    {
        String dataJson= fileDemoReader();
        Gson gson = new Gson();
        Quote[] quoteArray = gson.fromJson(dataJson , Quote[].class);
        Quote randomAns = randomQoutePicker(dataJson);
        ArrayList <Quote> arrQ = new ArrayList<Quote>();
        boolean flag = false;

        for(Quote quote : quoteArray) {
            arrQ.add(quote);
            if(quote.toString().equals(randomAns.toString()));
            flag= true ;
        }

        assertTrue(flag);
    }
}
