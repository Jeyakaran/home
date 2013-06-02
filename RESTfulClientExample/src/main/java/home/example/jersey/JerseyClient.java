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
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * RESTful client
 * 
 * Can retrieve
 * 
 * Plain text, xml, html
 * 
 * @author Jeyakaran
 * 
 */
public class JerseyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		// Fluent interfaces
		System.out.println(service.path("rest").path("hello")
				.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class)
				.toString());
		// Get plain text
		System.out.println(service.path("rest").path("hello")
				.accept(MediaType.TEXT_PLAIN).get(String.class));
		// Get XML
		System.out.println(service.path("rest").path("hello")
				.accept(MediaType.TEXT_XML).get(String.class));
		// The HTML
		System.out.println(service.path("rest").path("hello")
				.accept(MediaType.TEXT_HTML).get(String.class));

		// XML and JSON
		// Get XML
		System.out.println(service.path("rest").path("todo").path("gethtml")
				.accept(MediaType.TEXT_XML).get(String.class));
		// Get XML for application
		System.out.println(service.path("rest").path("todo").path("getxml")
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		// Get JSON for application
		System.out.println(service.path("rest").path("todo").path("getxml")
				.accept(MediaType.APPLICATION_XML).get(String.class));
		// Get JSON for application
		String out = service.path("rest").path("todo").path("getlist")
				.accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(out);
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<ToDo>>() {
		}.getType();
		Collection<ToDo> ints2 = gson.fromJson(out, collectionType);

		System.out.println(ints2);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTfulServerExample")
				.build();
	}

}
