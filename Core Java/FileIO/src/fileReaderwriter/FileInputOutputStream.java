package fileReaderwriter;

import java.io.*;

public class FileInputOutputStream {
	
	public static void main(String args[]) throws IOException {
		File inFile = new File("first.txt");
		File outFile = new File("second.txt");
		
		// FileInputStream and FileOutputStream is used to read and write the byte
		FileInputStream in = new FileInputStream(inFile);
		FileOutputStream out = new FileOutputStream(outFile);
		
		int c;
		while((c = in.read()) != -1) {
			System.out.println((char)c);
			out.write(c);
		}
		
		System.out.println("FileInputStream is used to read file and FileOutputStream is used for writing");
		in.close();
		out.close();
	}
}
