package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

/** UsersTabFilterImpl -- 	Implements filter for UsersTab
 *   
 * @author Pravin Nagare
 */
public class UsersTabFilterImpl implements DashboardFilter{

	private Logger logger = Logger.getInstance();
	public UsersTabFilterImpl(){
		logger.printToStdout(3, "Constructor of UsersTabFilterImpl is called");
	}
	
	/** Checks filter for UsersTab
	 * @param 		String
	 * @exception 	No Exception
	 * @return 		boolean
	 */
	public boolean check(String filter){
		logger.printToStdout(2, "Check of UsersTabFilterImpl is called");
		if(filter.startsWith("Users:")){
			return true;
		}
		return false;
	}
}
