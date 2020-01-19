import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PickYourQuote {

  public static void main(String[] args) throws Exception {

    // Extract appropriate parameters from command line
    final String quotesFile = args[0];
    final int quote_no = Integer.parseInt(args[1]);

    // read the file (Quotes.txt) using a BufferedReader
    FileReader in = new FileReader(quotesFile);
    BufferedReader quotesRead = new BufferedReader(in);

    // reformat the file
    reformat(quote_no, quotesRead);

    quotesRead.close();
  }

  public static void reformat(int i, BufferedReader in) throws IOException {

    // read lines up to specified line from the Buffered Reader
    String quote = "";

    for (int line = 0; line < i; line++) {

      quote = in.readLine();

      // If range exceeded avoid "null pointer exception"
      if (quote == null) {
        quote = "";
      }
    }

    // reformat as appropriate
    String[] result = quote.split(";");

    // print to System.out
    for (String newline : result) {
      System.out.println(newline);
    }
  }
}
