package shoplap.entity;

public class Contact {
	private int branch;
	private String mail1;
	private String mail2;
	private String location;
	private String phone1;
	private String phone2;
	private String map;

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public String getMail1() {
		return mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Contact(int branch, String mail1, String mail2, String location, String phone1, String phone2, String map) {
		super();
		this.branch = branch;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.location = location;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.map = map;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

}
