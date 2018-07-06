package cmd.cn;

public interface Funtion_Interface {
	// 用户开户
	public Person open_Card();

	// 添加用户
	public void add_User(Person s);

	// 用户注销
	public void delete_information();

	// 浏览用户信息
	public void show_User();

	// 用户充值话费
	public void charge_money(int id);

	// 查询用户余额
	public void lookMoney(int id);

	// 判断id是否存在
	public boolean boolean_id(int id);

}
