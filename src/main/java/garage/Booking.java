package garage;

public class Booking {
	
	
	private String vehiclePlate;
	private String message;
	private String service_type;
	private String booking_date;
	
	public Booking() {
		
		vehiclePlate = "";
		message = "";
		service_type = "";
		booking_date = "";
	}
	
	

	public Booking(String vehiclePlate, String message, String service_type, String booking_date) {
		super();
		this.vehiclePlate = vehiclePlate;
		this.message = message;
		this.service_type = service_type;
		this.booking_date = booking_date;
	}



	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	
	

}
