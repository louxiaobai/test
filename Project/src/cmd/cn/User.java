package cmd.cn;

import java.util.Map;
import java.util.Scanner;

public class User {
	public static Map<Integer, Person> map = null;

	public User() {
		Manage s = new Manage();
		map = s.map;
	}

	// 用户模式
	public void enter_User() {
		Fountions s1 = new Fountions();
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("用户模式菜单");
		System.out.println("1.充值\n2.查看本账户余额\n0.退出");
		System.out.println("请先输入一个id");
		int id = input.nextInt();
		if (map.containsKey(id)) {
			System.out.println("用户信息:\n账户id\t姓名\t电话号码\t账户余额\t");
			System.out.println(map.get(id));
			System.out.println("请输入菜单号:");
			try {
				n = input.nextInt();
			} catch (Exception e) {
				System.out.println("输入有误,请重新输入");
				n = input.nextInt();
			}

			if (n == 1) {
				// 进入充值系统
				s1.charge_money(id);
				System.out
						.println("--------------------------------------------------");
			} else if (n == 2) {
				// 用户查询模式
				s1.lookMoney(id);
				System.out
						.println("--------------------------------------------------");
			}

		} else {
			System.out.println("此用户不存在！");

		}

	}

}
