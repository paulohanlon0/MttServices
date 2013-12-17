package ie.mtt.mtttodo.services.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import ie.mtt.mtttodo.services.Task;

public class TaskMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setTaskId(rs.getInt(1));
		task.setDescription(rs.getString(2));
		task.setEntryDate(rs.getDate(3));
		task.setChecked(rs.getBoolean(4));
		return task;
	}
}
