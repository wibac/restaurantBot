package org.bot.restaurant;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/service")
public class Service {
	Polling polling = new Polling();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(Order order) {
		// System.out.println("test1" + order.getAmount());
		return "Got it!";
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String postIt(List<Order> orders) {
		if (orders != null)
			System.out.println("test1" + orders.size());
		return "Got it!";
	}

	@GET
	@Path("waiter")
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean callWaiter() {
		return callRobot();
	}
	
	@GET
	@Path("setup")
	public void startup(){
		System.out.println("starting up");
		Robot robot = new Robot();
		robot.setStatus(true);
		polling.getLstRobot().add(robot);
		polling.getLstRobot().add(new Robot());
		polling.getLstRobot().add(new Robot());
		polling.getLstRobot().add(new Robot());
		polling.getLstRobot().add(new Robot());
		System.out.println(polling.getLstRobot().size());
		//return "setup complete";
	}
	
	private boolean callRobot() {
		System.out.println(polling.getLstRobot().size());
		if(polling.getLstRobot().size()==0){
			System.out.println("set up not compeleted");
			return false;
		}
		while (true) {			
			for (Robot robot : polling.getLstRobot()) {
				System.out.println(robot.getStatus());
				if (robot.getStatus()) {
					robot.setStatus(false);
					return true;
				}
			}
		}
	}
}
