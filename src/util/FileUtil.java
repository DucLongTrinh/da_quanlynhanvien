package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
  public static void writeToFile(String fileName, String data) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
      writer.write(data);
      writer.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readFromFile(String fileName) {
    StringBuilder content = new StringBuilder();
    try {
      Path path = Paths.get(fileName);
      Files.lines(path).forEach(line -> content.append(line).append(System.lineSeparator()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content.toString();
  }
}
