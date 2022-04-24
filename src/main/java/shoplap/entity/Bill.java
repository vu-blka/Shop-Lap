package shoplap.entity;

public class Bill {
	private int idBill;
	private String username;
	private String fullname;
	private String phone;
	private String mail;
	private String address;
	private String note;
	private Payment payment;
	private String money;
	private String date;
	private Shipping shipping;

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Bill(int idBill, String username, String fullname, String phone, String mail, String address, String note,
			Payment payment, String money, String date, Shipping shipping) {
		super();
		this.idBill = idBill;
		this.username = username;
		this.fullname = fullname;
		this.phone = phone;
		this.mail = mail;
		this.address = address;
		this.note = note;
		this.payment = payment;
		this.money = money;
		this.date = date;
		this.shipping = shipping;

	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
