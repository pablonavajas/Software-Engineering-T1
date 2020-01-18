import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Quote {

  String quotation;
  String context;

  Quote (String text)
  {
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
    return "`" + quotation + '\'' +
            " by " + context;
  }
}

public class PickManyQuotes {

  public static void main(String[] args) throws Exception {

    // Use file name and quote numbers in args
    // to first create a list of quotes using loadQuotes
    // and then print to System.out the chosen quotes.

    final String quotesFile = args[0];

    // read the file Quotes.txt using a BufferedReader
    FileReader in = new FileReader(quotesFile);
    BufferedReader allQuotes = new BufferedReader(in);
    List<Quote> quotesList = loadQuotes(allQuotes);

    int[] choices = new int[args.length - 1];

    for (int i = 1; i < args.length; i++) {

      choices[i - 1] = Integer.parseInt(args[i]);
    }

    reformat(quotesList, choices);
  }


  public static void reformat(List<Quote> quotes, int[] choices) {

    // Print to System.out quotes according to choices.
    for (int i = 0; i < choices.length; i++) {

      System.out.println(quotes.get(choices[i] - 1).toString());
    }
  }

  public static List<Quote> loadQuotes(BufferedReader in) throws IOException {

    List<Quote> quotes = new ArrayList<Quote>();

    // Read lines from the input// Create a Quote object for each line and store in list.

    String line = in.readLine();
    int i = 0;
    while (line != null) {

      quotes.add(new Quote(line));

      line = in.readLine();
      i++;
    }

    return quotes;
  }

}
