package taskManager.subject;

import java.util.HashMap;

import java.util.Map;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.util.Message;
import taskManager.util.MessageImpl;
import taskManager.util.Logger;


/** DashBoardSubject -- 	Class implements register, notifyAll, register and starts processing
 * 
 * @author Pravin Nagare
 */

public class DashBoardSubject implements Subject{

	private Map<Observer, DashboardFilter> map = new HashMap<Observer, DashboardFilter>();
	private String line=null;
	private FileProcessor fp = null;
	Logger logger = Logger.getInstance();
	Message message = new MessageImpl();
	public DashBoardSubject(FileProcessor fp){
		this.fp = fp;
		logger.printToStdout(3, "Constructor of DashBoardSubject is called");
	}
	

	/** Register observer to notify
	 * @param 		Observer, DashboardFilter
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void register(Observer o, DashboardFilter f) {
		logger.printToStdout(2, "register of DashBoardSubject is called");
		map.put(o, f);		
	}
	

	/** Remove observer from map
	 * @param 		Observer
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void removeObserver(Observer o) {
		logger.printToStdout(2, "removeObserver of DashBoardSubject is called");
		if(map.containsKey(o)){
			map.remove(o);		
		}
		else{
			System.out.println("Observer not present");
		}
	}
	

	/**check and notify observer 
	 * @param 		String
	 * @exception 	No Exception
	 * @return 		No return value
	 */
	public void notifyObservers(String line) {
		logger.printToStdout(2, "notifyObservers of DashBoardSubject is called");
		for (Map.Entry<Observer, DashboardFilter> entry : map.entrySet()) {
		    Observer key = entry.getKey();
		    DashboardFilter value = entry.getValue();
		    if(value.check(line)){
		    	message.setMessage(line);
		    	key.update(message);
		    }
		    
		}
	}


	/** Starts processing on file
	 * @param 		No Arguments
	 */
	public void startProcessing() {
		logger.printToStdout(2, "startProcessing of DashBoardSubject is called");
		fp.openfile();
		while((line = fp.readLine()) != null){
			fp.writeToFile("---TAB(s) BEGIN---\n");		
			logger.printToStdout(1, "---TAB(s) BEGIN---\n");
			String[] tabs = line.split("\\*");
			for(Integer i=0; i<tabs.length; i++){
				notifyObservers(tabs[i]);
			}
			fp.writeToFile("---TAB(s) END---\n");
			logger.printToStdout(1, "---TAB(s) END---\n");
		}
		fp.close();
	}
		
}

