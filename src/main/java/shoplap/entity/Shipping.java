package shoplap.entity;

public class Shipping {
	private int idShipping;
	private String method;
	private int fee;

	public int getIdShipping() {
		return idShipping;
	}

	public void setIdShipping(int idShipping) {
		this.idShipping = idShipping;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Shipping(int idShipping, String method, int fee) {
		super();
		this.idShipping = idShipping;
		this.method = method;
		this.fee = fee;
	}

	public Shipping() {
		super();
		// TODO Auto-generated constructor stub
	}

}
