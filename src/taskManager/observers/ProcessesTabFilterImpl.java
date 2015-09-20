package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

/** ProcessesTabFilterImpl -- 	Implements filter for ProcessesTab
 *   
 * @author Pravin Nagare
 */

public class ProcessesTabFilterImpl implements DashboardFilter{
	
	private Logger logger = Logger.getInstance();
	public ProcessesTabFilterImpl(){
		logger.printToStdout(3, "Constructor of ProcessesTabFilterImpl is called");
	}
	/** Checks filter for ProcessTab
	 * @param 		String
	 * @exception 	No Exception
	 * @return 		boolean
	 */
	public boolean check(String filter){
		logger.printToStdout(2, "Check of ProcessesTabFilterImpl is called");
		if(filter.startsWith("Processes:")){
			return true;
		}
		return false;
	}
}
