package ie.mtt.mtttodo.services.data.dao;

import java.util.List;

import ie.mtt.mtttodo.services.Task;

public interface ITaskDAO {
	
	public List<Task> retrieveTasksForUser(int internalId);
	
	public Task get(int taskId);
	
	public void create(int internalId, Task task);
	
	public void update(Task task);
	
	public void delete(int taskId);
}
