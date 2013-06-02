/**
 * 
 */
package home.example.model;

import java.util.List;

import home.example.model.ToDo;

/**
 * @author Jeyakaran
 * 
 */
public class ToDo {
	private String summary;
	private String description;
	private List<Task> tasks;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Summary :");
		stringBuilder.append(summary);
		stringBuilder.append("\n");
		stringBuilder.append("Description :");
		stringBuilder.append(description);
		stringBuilder.append("Number of Tasks: ");

		for (Task task : tasks) {
			stringBuilder.append("\n");
			stringBuilder.append(task);
		}

		return stringBuilder.toString();
	}
}
