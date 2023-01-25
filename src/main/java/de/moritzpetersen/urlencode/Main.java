package de.moritzpetersen.urlencode;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.Console;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Main {
  private static final Function<String, String> ENCODER = str -> URLEncoder.encode(str, StandardCharsets.UTF_8);
  private static final Function<String, String> DECODER = str -> URLDecoder.decode(str, StandardCharsets.UTF_8);

  public static void main(String[] args) throws IOException, UnsupportedFlavorException {
    Function<String, String> processor = ENCODER;
    if (args.length > 0) {
      if (args[0].equals("-d")) {
        processor = DECODER;
        String[] tmp = new String[args.length - 1];
        System.arraycopy(args, 1, tmp, 0, tmp.length);
        args = tmp;
      }
    }
    if (args.length == 0) {
      Console console = System.console();
      if (console == null) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String data = (String) clipboard.getData(DataFlavor.stringFlavor);
        execute(processor, data);
      }
      else {
        String line = console.readLine();
        execute(processor, line);
      }
    }
    else {
      for (String arg : args) {
        execute(processor, arg);
      }
    }
    System.exit(0);
  }

  private static void execute(Function<String, String> processor, String arg) {
    String encoded = processor.apply(arg);
    System.out.println(encoded);
  }
}
