package ie.mtt.mtttodo.services;

import java.io.Serializable;
import java.util.Date;

public final class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int taskId;
	private String description;
	private Date entryDate;
	private boolean checked;
	
	public int getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public boolean isChecked() {
		return this.checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
