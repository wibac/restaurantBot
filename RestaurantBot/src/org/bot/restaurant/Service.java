package org.bot.restaurant;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "service" path)
 */
@Path("/service")
public class Service {
	Polling polling = Polling.getPollingObj();

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
	public String placeOrder(OrderInput orders) {
		if (orders != null){
			System.out.println("test1" + orders.getOrders().size());
			//set the robot status as available
			polling.getLstRobot().get(Integer.parseInt(orders.getRobotID())).setStatus(true);
			
			//add the order to the list
			for(Order order : orders.getOrders()){
				polling.getLstOrder().add(order);
			}
			System.out.println("status of robot 1" + polling.getLstRobot().get(1).getId());
		}
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
		robot.setId("1");
		robot.setStatus(true);
		polling.getLstRobot().add(robot);
		polling.getLstRobot().add(new Robot("2", true));
		polling.getLstRobot().add(new Robot("3", true));
		polling.getLstRobot().add(new Robot("4", true));
		polling.getLstRobot().add(new Robot("5", true));
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
