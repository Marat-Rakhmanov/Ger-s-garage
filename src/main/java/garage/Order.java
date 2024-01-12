package garage;

public class Order extends Product{

	private int orderId;
	private String email;
	private int quantity;
	private String date;
	
	public Order() {
		
	}

	public Order(int orderId, String email, int qunatity, String date) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.quantity = qunatity;
		this.date = date;
	}

	public Order(String email, int quantity, String date) {
		super();
		this.email = email;
		this.quantity = quantity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", email=" + email + ", qunatity=" + quantity + ", date=" + date + "]";
	}
	
	
}
