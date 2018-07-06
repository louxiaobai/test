package cmd.cn;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Fountions implements Funtion_Interface {

	public static Map<Integer, Person> map = null;

	public Fountions() {
		map = Manage.map;
	}

	@Override
	// 用户开户
	public Person open_Card() {
		// TODO Auto-generated method stub
		String name;
		int id;
		String telephone;
		double money;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入开户人的姓名:");
		name = input.next();
		System.out.println("请输入账户id:");
		id = input.nextInt();
		while (true) {
			if (boolean_id(id)) {
				System.out.println("id出现重复，请输入一个新的id");
				id = input.nextInt();
			}
				if (!boolean_id(id)) {
					break;
				}
			
		}
		System.out.println("请输入电话号码:");
		telephone = input.next();
		System.out.println("请输入预存入金额:");
		try {
			money = input.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("输入有误请重新输入");
			Scanner input1 = new Scanner(System.in);
			money = input1.nextDouble();

		}
		return new Person(id, name, telephone, money);
	}

	@Override
	// 添加用户
	public void add_User(Person s) {
		// TODO Auto-generated method stub
		map.put(s.getId(), s);
		Filet.write(map);
		System.out.println("开户成功请牢记您的id:" + s.getId() + ",牢记该id便于以后的登陆。");

	}

	// 浏览用户信息
	public void show_User() {
		// TODO Auto-generated method stub
		System.out.println("用户信息:\n账户id\t姓名\t电话号码\t账户余额\t");
		Set keySet = map.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);
			System.out.println(value);

		}

	}

	@Override
	// 注销用户信息
	public void delete_information() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要注销的id:");
		int id = input.nextInt();
		if (map.containsKey(id)) {
			map.remove(id);
			Filet.write(map);
			System.out.println("用户注销成功!");
			System.out
					.println("--------------------------------------------------");

		} else {

			System.out.println("你要注销的用户不存在！");
			System.out
					.println("--------------------------------------------------");

		}

	}

	@Override
	// 用户充钱
	public void charge_money(int id) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		if (map.containsKey(id)) {
			Person s = (Person) map.get(id);
			System.out.println("请输入要充值的钱数:");
			double money = input.nextDouble();
			s.setMoney(s.getMoney() + money);
			Filet.write(map);
			System.out.println("充值成功!\n" + s.getName() + "充值" + money + "元!");

		}

	}

	@Override
	// 查询用户余额
	public void lookMoney(int id) {
		// TODO Auto-generated method stub
		if (map.containsKey(id)) {
			Person s = (Person) map.get(id);
			System.out.println("用户余额为:" + s.getMoney() + "元。");

		}

	}

	@Override
	// 判断id是否存在
	public boolean boolean_id(int id) {

		if (map.containsKey(id)) {

			return true;

		}
		return false;
	}

}
