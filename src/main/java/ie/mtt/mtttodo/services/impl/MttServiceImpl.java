package ie.mtt.mtttodo.services.impl;

import java.util.List;

import ie.mtt.mtttodo.services.Task;
import ie.mtt.mtttodo.services.IMttService;
import ie.mtt.mtttodo.services.data.dao.ITaskDAO;
import ie.mtt.mtttodo.services.exception.MttServiceException;

public class MttServiceImpl implements IMttService {

	private ITaskDAO taskDAO;
	
	public void setDao(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
		
	}
	
	public List<Task> retrieveTasksForUser( int internalId) throws MttServiceException {
		try {
			return taskDAO.retrieveTasksForUser(internalId);
		}catch (Exception _ex) {
			throw new MttServiceException("Internal Service Error:", _ex);
		}
	}
	
	public Task getTask( int taskId) throws MttServiceException {
		try {
			return taskDAO.get(taskId);
		}catch (Exception _ex) {
			throw new MttServiceException("Internal Service Error:", _ex);
		}
	}
	
	public void createTask(int internalId, Task task) throws MttServiceException {
		try {
			taskDAO.create(internalId, task);
		} catch (Exception _ex) {
			throw new MttServiceException("Internal Service Error:", _ex);
		}
	}
	
	public void updateTask(Task task) throws MttServiceException {
		try {
			taskDAO.update(task);
		} catch (Exception _ex) {
			throw new MttServiceException("Internal Service Error:", _ex);
		}
	}
	
	public void deleteTask(int taskId) throws MttServiceException {
		try {
			taskDAO.delete(taskId);
		} catch (Exception _ex) {
			throw new MttServiceException("Internal Service Error:", _ex);
		}
	}
}
