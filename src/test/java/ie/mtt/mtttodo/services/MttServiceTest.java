package ie.mtt.mtttodo.services;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import ie.mtt.mtttodo.services.exception.MttServiceException;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MttServiceTest {
	
	private static IMttService mttService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ac = new FileSystemXmlApplicationContext("./src/test/resources/applicationContextTest.xml"); 
			mttService = (IMttService)ac.getBean("IMttService");
		} catch (Exception _e) {
			_e.printStackTrace();
			throw _e;
		}
	}

	@Test
	public void retrieveTasksForUser_Valid() {
		try {
			List<Task> tasks = mttService.retrieveTasksForUser(3);
			assertEquals("Task does not exist:", 1, tasks.size());
			assertEquals("Incorret TaskId:", 1001, tasks.get(0).getTaskId());
			assertEquals("Incorret Description:", "Task Description", tasks.get(0).getDescription());
		} catch (MttServiceException _ex) {
			fail("Unexpected Exception: " + _ex.getMessage());
		}
	}
	
	@Test
	public void retrieveTasksForUser_InvalidUser() {
		try {
			List<Task> tasks = mttService.retrieveTasksForUser(5);
			assertEquals("Invalid User contains tasks", false, tasks.size() > 0);
		} catch (MttServiceException _ex) {
			fail("Unexpected Exception: " + _ex.getMessage());
		}
	}
	
	@Test
	public void createTask() {
		try {
			Task task = new Task();
			task.setDescription("Test Description");
			mttService.createTask(10, task);
			List<Task> tasks = mttService.retrieveTasksForUser(10);
			assertEquals("Task was not created:", 1, tasks.size());
			assertEquals("Incorret Description:", "Test Description", tasks.get(0).getDescription());
			mttService.deleteTask(tasks.get(0).getTaskId());
		} catch (MttServiceException _ex) {
			fail("Unexpected Exception: " + _ex.getMessage());
		}
	}
	
	@Test
	public void deleteTask() {
		try {
			Task task = new Task();
			task.setDescription("Test Description");
			mttService.createTask(10, task);
			List<Task> tasks = mttService.retrieveTasksForUser(10);
			assertEquals("Task was not created:", 1, tasks.size());
			assertEquals("Incorret Description:", "Test Description", tasks.get(0).getDescription());
			mttService.deleteTask(tasks.get(0).getTaskId());
			tasks = mttService.retrieveTasksForUser(10);
			assertEquals("Task was not deleted:", 0, tasks.size());
		} catch (MttServiceException _ex) {
			fail("Unexpected Exception: " + _ex.getMessage());
		}
	}
	
	@Test
	public void updateTask() {
		try {
			Task task = new Task();
			task.setDescription("Test Description");
			mttService.createTask(10, task);
			List<Task> tasks = mttService.retrieveTasksForUser(10);
			assertEquals("Incorret Description:", "Test Description", tasks.get(0).getDescription());
			tasks.get(0).setDescription("New description");
			mttService.updateTask(tasks.get(0));
			tasks = mttService.retrieveTasksForUser(10);
			assertEquals("Incorret Description:", "New description", tasks.get(0).getDescription());
			mttService.deleteTask(tasks.get(0).getTaskId());
		} catch (MttServiceException _ex) {
			fail("Unexpected Exception: " + _ex.getMessage());
		}
	}
}
