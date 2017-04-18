package org.bot.restaurant;

import java.net.URI;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Test {
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();

		Order order = new Order();
		order.setAmount("21");
		order.setId("2");
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		String response = target.path("rest").path("setup").request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class)
				.toString();

		//Invocation.Builder invocationBuilder =  target.path("rest").path("service").request(MediaType.APPLICATION_JSON);
		
		//Response response = invocationBuilder.post(Entity.entity(order, MediaType.APPLICATION_JSON));
		
	//	String plainAnswer = target.path("rest").path("service").request().accept(MediaType.TEXT_PLAIN).get(String.class);
//		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
//		String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println(response);
		//System.out.println(plainAnswer);
//		System.out.println(xmlAnswer);
//		System.out.println(htmlAnswer);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RestaurantBot").build();
	}

}
