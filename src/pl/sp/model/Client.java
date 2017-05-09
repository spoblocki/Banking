package pl.sp.model;

public class Client extends Account {

	private String name;
	private String surname;
	private String address;

	public Client(String name, String surname, String address,
			String accountNumber) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.accountNumber = accountNumber;

	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", address="
				+ address + ", accountNumber=" + accountNumber + ", balance="
				+ balance +  "]";
	}

	

}
