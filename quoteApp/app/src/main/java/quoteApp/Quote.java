package quoteApp;

import java.util.Arrays;

public class Quote {
    String author ;
    String likes;
    String text ;

    public Quote( String author, String likes, String text) {
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", likes='" + likes + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
