package shoplap.entity;

//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

public class Product {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private float rate;
	private int sale;
	private String description;
	private int quantity;
//	@Column(name = "quantity_sold")
	private int quantitySold;

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

//	@Column(name = "link_img")
	private String img;

//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@Column(name = "update_at")
//	private Date updateAt;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_category")
	private Category category;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_brand")
	private Brand brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	private String id_cartegory;
	private String id_brand;

	public String getId_cartegory() {
		return id_cartegory;
	}

	public void setId_cartegory(String id_cartegory) {
		this.id_cartegory = id_cartegory;
	}

	public String getId_brand() {
		return id_brand;
	}

	public void setId_brand(String id_brand) {
		this.id_brand = id_brand;
	}

	public Product(int id, String name, int price, float rate, int sale, String description, int quantity,
			int quantitySold, String img, Category category, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rate = rate;
		this.sale = sale;
		this.description = description;
		this.quantity = quantity;
		this.quantitySold = quantitySold;
		this.img = img;
		this.category = category;
		this.brand = brand;
		
	}

	public Product() {

		super();
		// TODO Auto-generated constructor stub
	}

}
