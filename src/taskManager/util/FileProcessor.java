package taskManager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileProcessor {
	
	private String inFile=null;
	private String outFile=null;
	private FileInputStream input=null;
	private BufferedReader reader=null;
	private File file = null;
	private Logger logger = Logger.getInstance(); 
	public FileProcessor(String inFile, String outFile){
			logger.printToStdout(3, "Constructor of FileProcessor is called");
			this.inFile = inFile;
			this.outFile = outFile;
	}
	
	public void writeToFile(String output){
		logger.printToStdout(2, "writeToFile of FileProcessor is called");
		BufferedWriter bw=null;
		try {
	          File file = new File(outFile);
	          FileWriter fw;
	          if(file.exists()){    
	        	  fw = new FileWriter(file, true);
	          }
	          else{
	        	   fw = new FileWriter(file);
	          }
	          bw = new BufferedWriter(fw);
	          bw.write(output);
	    } 
		catch ( IOException e ) {
				logger.printToStdout(0, "IO exception occured.");
				System.err.println("IO exception occured.");
	    }
		finally{
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				logger.printToStdout(0, "Error in file closing.");
				System.err.println("Error in file closing.");
			}
	        
		}	
    }	
		
	
	public void openfile(){
		logger.printToStdout(2, "openfile of FileProcessor is called");
		try {
			File file = new File(inFile);
			input  = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(input));
		}catch(FileNotFoundException e){
			logger.printToStdout(0, "File Not Found.");
			System.err.println("File Not Found.");
			System.exit(1);
		}finally{
			
		}				
	}
	
	public String readLine(){
		logger.printToStdout(2, "readLine of FileProcessor is called");
		String fileLine = null;
		try{
			
			return (fileLine = reader.readLine());			
		}catch(Exception e){
			logger.printToStdout(0, "Could not read file");
			System.err.println("Could not read file.");
			return fileLine;		
		}finally{
			
		}
	}
	
	public void close(){
		try {
			reader.close();
		}catch (IOException e) {
			logger.printToStdout(0, "Error in file clossing");
			System.err.println("Error in file clossing");
		}finally{
			
		}		
	}
}
