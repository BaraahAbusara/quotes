package quoteApp;

public class QuoteAPI extends QuotesParent{
    String quoteAuthor;
    String quoteText;

    public QuoteAPI(String quoteAuthor, String quoteText) {
        this.quoteAuthor = quoteAuthor;
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return "QuoteAPI{" +
                "quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteText='" + quoteText + '\'' +
                '}';
    }
}
