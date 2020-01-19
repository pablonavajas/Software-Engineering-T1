public class Quote {

    String quotation;
    String context;

    Quote(String text) {
        String[] result = text.split(";");

        quotation = result[0];
        context = result[1];
    }

    String getQuote() {

        return quotation;
    }

    String getContext() {

        return context;
    }

    @Override
    public String toString() {
        return "`" + quotation + '\''
                + " by " + context;
    }
}

