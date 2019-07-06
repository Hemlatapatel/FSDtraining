package fileReaderwriter;

import java.io.*;

public class FileReaderWriter {

	public static void main(String args[]) throws IOException {
		File inFile = new File("first.txt");
		File outFile = new File("second.txt");
 
		// FileReader and FileWriter is used to read and write the char
		FileReader in = new FileReader(inFile);
		FileWriter out = new FileWriter(outFile);

		// copy by char ----------------------------------------------------
//		int c;
//		while((c = in.read()) != -1) {
//			System.out.println(c);
//			out.write(c);
//		}
//		
//		System.out.println("Filereader is used to read a file and filewriter is used for writing");
		// -------------------------------------------------------------
		
		BufferedReader inputStream = new BufferedReader(in);
//		PrintWriter outputStream = new PrintWriter(out);
		BufferedWriter outputStream = new BufferedWriter(out);
		
		String l;
		
		while((l = inputStream.readLine()) != null) {
			System.out.println(l);
//			outputStream.println(l); // used for PrintWriter()
			outputStream.write(l);
		}
		in.close();
		out.close();
	}
}
