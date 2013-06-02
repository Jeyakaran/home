/**
 * 
 */
package home.example.restful;

import home.example.model.ToDo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

/**
 * @author Jeyakaran
 * 
 */
@Path("/todo")
public class TodoResource {
	// This method is called if XML is request
	@GET
	@Path("/getxml")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ToDo getXML() {
		ToDo todo = new ToDo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo");
		return todo;
	}

	@GET
	@Path("/getlist")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getListOfTodoJson() {

		List<ToDo> todoList = new ArrayList<ToDo>();
		ToDo toDoOne = new ToDo();
		toDoOne.setSummary("This is my first todo");
		toDoOne.setDescription("This is my first todo");
		todoList.add(toDoOne);

		ToDo toDoTwo = new ToDo();
		toDoTwo.setSummary("This is my Second todo");
		toDoTwo.setDescription("This is my Second todo");
		todoList.add(toDoTwo);

		GenericEntity entity = new GenericEntity<List<ToDo>>(todoList) {
		};

		return Response.ok(entity).build();

	}

	// This can be used to test the integration with the browser
	@GET
	@Path("/gethtml")
	@Produces({ MediaType.TEXT_XML })
	public ToDo getHTML() {
		ToDo todo = new ToDo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo");
		return todo;
	}

}