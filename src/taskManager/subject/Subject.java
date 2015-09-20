package taskManager.subject;

import taskManager.observers.Observer;

import taskManager.filter.DashboardFilter;

public interface Subject {
	public void register(Observer o, DashboardFilter f);
	public void notifyObservers(String s);
	public void removeObserver(Observer o);
}
