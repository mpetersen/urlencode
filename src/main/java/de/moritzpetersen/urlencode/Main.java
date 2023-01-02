package de.moritzpetersen.urlencode;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.Console;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Main {
  public static void main(String[] args) throws IOException, UnsupportedFlavorException {
    if (args.length == 0) {
      Console console = System.console();
      if (console == null) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String data = (String) clipboard.getData(DataFlavor.stringFlavor);
        execute(data);
      }
      else {
        String line = console.readLine();
        execute(line);
      }
    }
    else {
      for (String arg : args) {
        execute(arg);
      }
    }
    System.exit(0);
  }

  private static void execute(String arg) {
    String encoded = URLEncoder.encode(arg, Charset.defaultCharset());
    System.out.println(encoded);
  }
}
