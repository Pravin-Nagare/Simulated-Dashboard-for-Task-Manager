package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

/** PerformanceTabFilterImpl -- 	Implements filter for PerformanceTabFilterImpl
 *   
 * @author Pravin Nagare
 */
public class PerformanceTabFilterImpl implements DashboardFilter{

	private Logger logger = Logger.getInstance();
	public PerformanceTabFilterImpl(){
		logger.printToStdout(3, "Constructor of PerformanceTabFilterImpl is called");
	}
	
	/** Checks filter for UsersTab
	 * @param 		String
	 * @exception 	No Exception
	 * @return 		boolean
	 */
	
	public boolean check(String filter){
		logger.printToStdout(2, "Check of PerformanceTabFilterImpl is called");
		if(filter.startsWith("Performance:")){
			return true;
		}
		return false;
	}
}
