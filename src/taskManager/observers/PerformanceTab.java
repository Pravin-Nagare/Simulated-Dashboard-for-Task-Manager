package taskManager.observers;

import java.util.ArrayList;
import java.util.List;
import taskManager.util.Logger;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Message;

/** PerformanceTab -- 	Class implements update and displayDashboard
 * 
 * @author Pravin Nagare
 */

public class PerformanceTab implements Observer, DisplayFile{
	private String users = null; 
	private List<String> L = null;
	private FileProcessor fp = null;
	Logger logger = Logger.getInstance();
	public PerformanceTab(FileProcessor fp) {
		logger.printToStdout(3, "Constructor of PerformanceTab is called");
		this.fp=fp;
	}


	/** Update corrosponding observers
	 * @param 		Message
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void update(Message m){
		logger.printToStdout(2, "Update of PerformanceTab is called");
		L= new ArrayList<String>();
		String[] colon = null;
		users  = m.getMessage();
		users = users.substring(12);
		String[] userStatus = users.split("\\-");
		for(Integer len=0; len<userStatus.length; len++){
			colon = userStatus[len].split("\\:");
			for(Integer i=0;i<colon.length;i++){
				L.add(colon[i]);
				
			}
		}
		displayDashboard();
	}

	/** Display result to an output file
	 * @param 		String argument from command line
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void displayDashboard(){
		String output = null;
		logger.printToStdout(2, "displayDashboard of PerformanceTab is called");
		fp.writeToFile("---PERFORMANCE---\n");
		logger.printToStdout(1,"---PERFORMANCE---\n");
		for(Integer i=0; i<L.size();i+=7){
			output = "Memory Total: "+L.get(i) + "  Memory Used: "+L.get(i+1)+"  Memory  Free: "+L.get(i+2)+"  Memory  Cached: "+L.get(i+3)+"\n"+"CPU Idle: "
					+L.get(i+4)+"  CPU User Level: "+L.get(i+5)+"  CPU System Level: "+L.get(i+6)+"\n";
			fp.writeToFile(output);		
			logger.printToStdout(1,output);
		}	
		fp.writeToFile("\n");		
		
	}
}
