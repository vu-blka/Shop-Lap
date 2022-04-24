package shoplap.entity;

public class Message {
	private String idMessage;
	private String name;
	private String email;
	private String phone;
	private String subject;
	private String msg;
	private String seen;
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}

	public String getSeen() {
		return seen;
	}

	public void setSeen(String seen) {
		this.seen = seen;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Message(String idMessage, String name, String mail, String phone, String subject, String message,
			String seen, String date) {
		super();
		this.idMessage = idMessage;
		this.name = name;
		this.email = mail;
		this.phone = phone;
		this.subject = subject;
		this.msg = message;
		this.seen = seen;
		this.date = date;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

}
