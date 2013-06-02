/**
 * 
 */
package home.example.model;

/**
 * @author Jeyakaran
 * 
 */
public class Task {

	private String taskName;
	private String taskDescription;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Task Name :");
		stringBuilder.append(taskName);
		stringBuilder.append("\n");
		stringBuilder.append("Task Description :");
		stringBuilder.append(taskDescription);

		return stringBuilder.toString();
	}

}
