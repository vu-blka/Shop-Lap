package shoplap.entity;

public class OrderedItem {
	private Product product;
	private int idOrdered;
	private int quantity;

	public int getIdOrdered() {
		return idOrdered;
	}

	public void setIdOrdered(int idOrdered) {
		this.idOrdered = idOrdered;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderedItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderedItem(Product product, int idOrdered, int quantity) {
		super();
		this.product = product;
		this.idOrdered = idOrdered;
		this.quantity = quantity;
	}

}
