package org.usfirst.frc.team4536.robot;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author Liam
 * The following link was used as we were learning to write to and read from text documents.
 *{@link}http://www.homeandlearn.co.uk/java/write_to_textfile.html
 * A class containing methods for writing to text files.
 */
public class FileWrite {
  
  private String path;
  private boolean appendToFile = false;
  
  public FileWrite(String filePath) {
    
    path = filePath;
  }
  
  /**
   * @author Liam
   * @param filePath - The name of the path of the text file document you will be writing to.
   * @param appendValue - A boolean value deciding if you will add text to the end of the last text printed on the document or whether you will overwrite the document. Overwriting will erase all text on the document and display the text you have written.
   */
  public FileWrite(String filePath, boolean appendValue) {
    
    path = filePath;
    appendToFile = appendValue;
  }
  
  /**
   * @author Liam
   * @param textLine The line of text the user wants to be printed.
   * @throws IOException An IOException will be thrown if the method is using an invalid file path.
   * This method writes to the file whose filepath is passed to the constructor.
   */
  public void writeToFile (String textLine) throws IOException {
  
    FileWriter write = new FileWriter(path, appendToFile);
    PrintWriter printLine = new PrintWriter(write);
    
    printLine.printf("%s" + "%n", textLine);
    printLine.close();
  }
  
}