/**
 * 
 */
package home.example.model;

import home.example.model.ToDo;

/**
 * @author Jeyakaran
 * 
 */
public class ToDo {
	private String summary;
	private String description;

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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Summary :");
		stringBuilder.append(summary);
		stringBuilder.append("\n");
		stringBuilder.append("Description :");
		stringBuilder.append(description);

		return stringBuilder.toString();
	}
}
