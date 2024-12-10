package model;

public class Customer {
	private String id;
	private String name;
	private String address;
	private String hp;
	
	public Customer(String id, String name, String address, String hp) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.hp = hp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public Customer build() {
		return new Customer(id, name, address, hp);
		// TODO Auto-generated method stub
		
	}

}
