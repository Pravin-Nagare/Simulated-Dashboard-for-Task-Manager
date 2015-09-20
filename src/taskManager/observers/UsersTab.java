package taskManager.observers;

import java.util.List;
import java.util.ArrayList;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Message;
import taskManager.util.Logger;

/** UsersTab -- 	Class implements update and displayDashboard
 * 
 * @author Pravin Nagare
 */

public class UsersTab implements Observer, DisplayFile{
	
	private String users = null; 
	private List<String> L = null;
	private FileProcessor fp = null;
	Logger logger = Logger.getInstance();
	public UsersTab(FileProcessor fp) {
		this.fp = fp;
		logger.printToStdout(3, "Constructor of UsersTab is called");
	}
	
	/** Update corrosponding observers
	 * @param 		Message
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void update(Message m){
		logger.printToStdout(2, "Update of UsersTab is called");
		L = new ArrayList<String>();
		String[] colon = null;
		users  = m.getMessage();
		users = users.substring(6);
		String[] userStatus = users.split("\\-");
		for(Integer len=0; len<userStatus.length; len++){
			colon = userStatus[len].split("\\:");
			L.add(colon[0]);
			L.add(colon[1]);						
		}
		displayDashboard();
	}
	
	/** Display result to an output file
	 * @param 		String argument from command line
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void displayDashboard(){
		logger.printToStdout(2, "displayDashboard of UsersTab is called");
		fp.writeToFile("---USERS---\n");
		logger.printToStdout(1, "---USERS---\n");
		String output = null;
		for(Integer i=0; i<L.size();i+=2){
			output = "User: "+L.get(i) + "  Status: "+L.get(i+1)+"\n";
			fp.writeToFile(output);
			logger.printToStdout(1, output);
		}
		fp.writeToFile("\n");			
	}
}
