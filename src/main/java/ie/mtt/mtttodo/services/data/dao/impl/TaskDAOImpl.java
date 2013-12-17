package ie.mtt.mtttodo.services.data.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import ie.mtt.mtttodo.services.Task;
import ie.mtt.mtttodo.services.data.dao.ITaskDAO;

public class TaskDAOImpl extends NamedParameterJdbcDaoSupport implements ITaskDAO {
	
	public List<Task> retrieveTasksForUser(int internalId) {
		String sql = "SELECT TASK_ID, DESCRIPTION, ENTRY_DATE, CHECKED "
				+ "FROM MTTDB.TBTASK "
				+ "WHERE INTERNAL_ID = :internalId";
		
		NamedParameterJdbcTemplate template = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource params = new MapSqlParameterSource("internalId", internalId);
		return template.query(sql, params, new TaskMapper());
	}
	
	public Task get(int taskId) {
		String sql = "SELECT TASK_ID, DESCRIPTION, ENTRY_DATE, CHECKED "
				+ "FROM MTTDB.TBTASK "
				+ "WHERE TASK_ID = :taskId";
		
		NamedParameterJdbcTemplate template = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource params = new MapSqlParameterSource("taskId", taskId);
		return (Task)template.queryForObject(sql, params, new TaskMapper());
	}
	
	public void create(int internalId, Task task) {
		String sql = "INSERT INTO MTTDB.TBTASK "
				+ "(INTERNAL_ID, DESCRIPTION) "
				+ "VALUES (?, ?)";
		JdbcTemplate template = this.getJdbcTemplate();
		template.update(sql, internalId, task.getDescription());
	}
	
	public void update(Task task) {
		String sql = "UPDATE MTTDB.TBTASK "
				+ "SET DESCRIPTION = ?, CHECKED = ? "
				+ "WHERE TASK_ID = ?";
		
		JdbcTemplate template = this.getJdbcTemplate();
		template.update(sql, task.getDescription(), task.isChecked(), task.getTaskId());
	}
	
	public void delete(int taskId) {
		String sql = "DELETE FROM MTTDB.TBTASK "
				+ "WHERE TASK_ID = ?";
		
		JdbcTemplate template = this.getJdbcTemplate();
		template.update(sql, taskId);
		
	}
}
