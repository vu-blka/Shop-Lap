package shoplap.entity;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "CATEGORIES")
public class Category {
//	@Id
//	@Column(name="id_category")
	private String id;
	private String category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Category(String id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
