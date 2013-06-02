/**
 * 
 */
package home.example.jersey;

import home.example.model.ToDo;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Jersey client JSON
 * 
 * @author Jeyakaran
 * 
 */
public class JerseyGsonClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Jersey client
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// JSON request
		String responseJson = service.path("rest").path("todo").path("getlist")
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		System.out.println(responseJson);

		// GSON to convert JSON response to respective object

		Gson gson = new Gson();

		// Collection type
		Type collectionType = new TypeToken<Collection<ToDo>>() {
		}.getType();

		// response list
		List<ToDo> toDoList = gson.fromJson(responseJson, collectionType);

		for (ToDo toDo : toDoList) {
			System.out.println(toDo);
		}

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTfulServerExample")
				.build();
	}

}
