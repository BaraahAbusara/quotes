package quoteApp;

import java.util.Arrays;

public class Quote extends QuotesParent{
    String author ;
    String text ;

    public Quote( String quoteText, String quoteAuthor) {
        this.author = quoteAuthor;
        this.text = quoteText;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
