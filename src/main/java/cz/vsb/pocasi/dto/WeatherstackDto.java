package cz.vsb.pocasi.dto;

public class WeatherstackDto {	
	public Request request;	
	public Location location;
	public Current current;
	
	
	//Request
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}//Request-End
	
	
	//Location
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}//Location-End
	
	
	//Current
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}//Current-End
}



