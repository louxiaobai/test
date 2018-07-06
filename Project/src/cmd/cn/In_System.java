package cmd.cn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class In_System {

	Manage manage = new Manage();
	User user = new User();

	public void enter_System() {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("请选择: 1-管理员模式 2-用户 0-退出");
		try {
			n = input.nextInt();
		} catch (InputMismatchException e) {
			Scanner input1 = new Scanner(System.in);
			System.out.println("输入有误,请输入正整数d");
			n = input1.nextInt();

		}
		if (n == 1) {
			// 进入管理员模式
			manage.enter_Manage();
			enter_System();

		} else if (n == 2) {
			// 进入用户模式
			user.enter_User();
			enter_System();

		} else if (n == 0) {
            //退出系统
			System.exit(0);

		}

	}

}
