package shoplap.entity;

public class Payment {
	private int idPayment;
	private String method;

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Payment(int idPayment, String method) {
		super();
		this.idPayment = idPayment;
		this.method = method;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
