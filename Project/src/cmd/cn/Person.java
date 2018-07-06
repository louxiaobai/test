package cmd.cn;

public class Person {
	private int id;
	private String name;
	private String telephone;
	private double money;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Person() {
	}

	public Person(int id, String name, String telephone, double money) {

		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.money = money;

	}

	public String toString() {

		return id + "\t" + name + "\t" + telephone + "\t" + money + "\t";

	}

}
