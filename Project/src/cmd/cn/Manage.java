package cmd.cn;

import java.util.Map;
import java.util.Scanner;

public class Manage {
	public static Map<Integer, Person> map = null;
	public static Fountions s1;

	public Manage() {
		map = Filet.read();
		s1 = new Fountions();

	}

	// 管理员模式
	public void enter_Manage() {
		Fountions s1 = new Fountions();
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("管理员模式菜单");
		System.out.println("1.开卡\n2.查询所有开户账户\n3.用户注销\n0.退出");
		System.out.print("请输入菜单号:");
		try {
			n = input.nextInt();
		} catch (Exception e) {
			System.out.println("输入有误吗，请重新出入");
			n = input.nextInt();
		}

		if (n == 1) {
			// 进入开户模式
			s1.add_User(s1.open_Card());
			System.out.println("--------------------------------------------------");

		} else if (n == 2) {
			// 用户信息展示
			s1.show_User();
			System.out.println("--------------------------------------------------");

		} else if (n == 3) {
			s1.delete_information();
			enter_Manage();

		}

		else if (n == 0) {
			// 退出系统
			System.exit(0);

		}

	}
}