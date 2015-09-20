package taskManager.driver;

import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.filter.DashboardFilter;
import taskManager.observers.UsersTab;
import taskManager.subject.DashBoardSubject;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

/** Driver-- 	Driver class to drive the program
 * 
 * @author Pravin Nagare
 */

public class Driver {

	public static void main(String[] args) {
		
		if(args.length < 3) {
			System.err.println("Number of arguments should be 3\n");
			System.exit(1);
		}
		Logger.setLoggerValue(args[2]);
		
		FileProcessor fp  = new FileProcessor(args[0], args[1]);
		DashBoardSubject dashBoard = new DashBoardSubject(fp);
		
		Observer user = new UsersTab(fp);
		DashboardFilter userFilter = new UsersTabFilterImpl();
		dashBoard.register(user, userFilter);
		
		Observer performance = new PerformanceTab(fp);
		DashboardFilter performnceFilter = new PerformanceTabFilterImpl();
		dashBoard.register(performance, performnceFilter);
	
		Observer processes = new ProcessesTab(fp);
		DashboardFilter processFilter = new ProcessesTabFilterImpl();
		dashBoard.register(processes, processFilter);
	
		dashBoard.startProcessing();				
		
	}

}
