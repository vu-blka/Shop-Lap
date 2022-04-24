package shoplap.entity;

import java.util.List;

public class Ordered {
	private int idOrdered;
	private String idAdmin;
	private int idBill;
	private List<Cart> cart;

	public int getIdOrdered() {
		return idOrdered;
	}

	public void setIdOrdered(int idOrdered) {
		this.idOrdered = idOrdered;
	}

	public String getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Ordered(int idOrdered, String idAdmin, int idBill, List<Cart> cart) {
		super();
		this.idOrdered = idOrdered;
		this.idAdmin = idAdmin;
		this.idBill = idBill;
		this.cart = cart;
	}

	public Ordered() {
		super();
		// TODO Auto-generated constructor stub
	}

}
