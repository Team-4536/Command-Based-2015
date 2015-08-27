package org.usfirst.frc.team4536.robot;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileWrite {

	private String path;
	private boolean appendToFile = false;
	
	public FileWrite(String filePath) {
		
		path = filePath;
	}
	
	public FileWrite(String filePath, boolean appendFile) {
		
		path = filePath;
		appendToFile = appendFile;
	}
	
	public void writeToFile(String text) throws IOException {
		
		FileWriter write = new FileWriter(path, appendToFile);
		PrintWriter printer = new PrintWriter(write);
		
		printer.printf("%s" + "%n", text);
		printer.close();
	}

}
