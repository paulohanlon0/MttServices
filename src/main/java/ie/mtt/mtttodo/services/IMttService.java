package ie.mtt.mtttodo.services;

import java.util.List;

import ie.mtt.mtttodo.services.data.dao.ITaskDAO;
import ie.mtt.mtttodo.services.exception.MttServiceException;

public interface IMttService {
	
	public void setDao(ITaskDAO dao);

	public List<Task> retrieveTasksForUser( int internalId) throws MttServiceException;
	
	public Task getTask(int taskId) throws MttServiceException;
	
	public void createTask(int internalId, Task task) throws MttServiceException;
	
	public void updateTask(Task task) throws MttServiceException;
	
	public void deleteTask(int taskId) throws MttServiceException;
}
