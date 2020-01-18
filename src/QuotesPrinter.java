import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuotesPrinter {

  public static void main(String[] args) throws Exception {

    final String quotesFile = "Quotes.txt";

    // read the file Quotes.txt using a BufferedReader
    FileReader in = new FileReader(quotesFile);
    BufferedReader quotesRead = new BufferedReader(in);

    // reformat the file
    reformat(quotesRead);

  }

  public static void reformat(BufferedReader input) throws IOException {

    // read lines from the input
    String quote = input.readLine();
    while (quote != null) {

      // reformat as appropriate
      String[] result = quote.split(";");

      // print to System.out
      for (String newline : result) {
        System.out.println(newline);
        }

      quote = input.readLine();
    }
  }
}
