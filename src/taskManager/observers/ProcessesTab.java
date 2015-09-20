package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;
import taskManager.util.Message;

/** ProcessTab -- 	Class implements update and displayDashboard
 * 
 * @author Pravin Nagare
 */

public class ProcessesTab implements Observer, DisplayFile{
	
	private String users = null; 
	private List<String> L = null;
	private FileProcessor fp = null;
	Logger logger = Logger.getInstance();
	public ProcessesTab(FileProcessor fp) {		
		this.fp=fp;
		logger.printToStdout(3, "Constructor of ProcessTab is called");
	}

	/** Update corrosponding observers
	 * @param 		Message
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void update(Message m){
		logger.printToStdout(2, "update of ProcessTab is called");
		L = new ArrayList<String>();
		String[] colon = null;
		
		users  = m.getMessage();
		users = users.substring(10);
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
		logger.printToStdout(2, "displayDashboard of ProcessTab is called");
		fp.writeToFile("---PROCESSES---\n");
		logger.printToStdout(1, "---PROCESSES---\n");
		fp.writeToFile("  PID COMMAND         USER     %CPU %MEM\n");
		logger.printToStdout(1, "  PID COMMAND         USER     %CPU %MEM\n");
		String output = null, pid, command, user, cpu, memory;
		for(Integer i=0; i<L.size();i+=5){
			pid = L.get(i);
			command = L.get(i+1);
			user = L.get(i+2);
			cpu = L.get(i+3);
			memory = L.get(i+4);
			output=String.format("%5s %-16s%-8s  %s  %s",  pid, command, user, cpu, memory+"\n");

			fp.writeToFile(output);
			logger.printToStdout(1, output);
		}
		fp.writeToFile("\n");
		
	}

}
