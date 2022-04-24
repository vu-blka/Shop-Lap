package shoplap.entity;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "BRANDS")
public class Brand {
//	@Id
//	@Column(name = "id_brand")
	private int id;
	private String brand;
	private String img;
	private int countProduct;
	private int sold;
	
	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Brand(int id, String brand,String img) {
		super();
		this.id = id;
		this.brand = brand;
		this.img=img;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
