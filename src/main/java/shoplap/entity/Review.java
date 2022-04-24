package shoplap.entity;


//@Entity
//@Table(name = "REVIEWS")
public class Review {
//	@Id
//	@Column(name = "id_review")
	private int id;

//	@Column(name = "id")
	private int idProduct;

	private String username;
	private String title;
	private String star;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	private String content;

//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String createAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public Review(int id, int idProduct, String username, String title, String star, String content, String createAt) {
		super();
		this.id = id;
		this.idProduct = idProduct;
		this.username = username;
		this.title = title;
		this.star = star;
		this.content = content;
		this.createAt = createAt;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

}
