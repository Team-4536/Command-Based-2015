package org.usfirst.frc.team4536.robot;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * @author Liam
 *The following link was used as we were learning to write to and read from text documents.
 *{@link}http://www.homeandlearn.co.uk/java/write_to_textfile.html
 * A class for reading from text documents.
 */
public class FileRead {
  
  private String path;
  
  public FileRead (String filePath) {
    
    path = filePath;
  }
  
  /**
   * @author Liam
   * @return numberOfLines - an integer value representing the number of lines in the read text file document.
   * @throws IOException An IOException will be thrown if the method is using an invalid file path.
   */
  public int readLines() throws IOException {
    
    FileReader fileToRead = new FileReader(path);
    BufferedReader bf = new BufferedReader(fileToRead);
    
    String aLine;
    int numberOfLines = 0;
    
    while ((aLine = bf.readLine()) != null) {
      
      numberOfLines++;
    }
    bf.close();
    
    return numberOfLines;
  }
  
  /**
   * @author Liam
   * @return textData - A string array with the text collected from every line of the text document.
   * @throws IOException An IOException will be thrown if the method is using an invalid file path.
   */
  public String[] openFile() throws IOException {
    
    FileReader fr = new FileReader(path);
    BufferedReader textReader = new BufferedReader (fr);
    
    int numberOfLines = readLines();
    String[] textData = new String[numberOfLines];
    
    int i;
    
    for (i=0; i < numberOfLines; i++) {
      
      textData[i] = textReader.readLine();
    }
    
    textReader.close();
    return textData;
  }
  
}