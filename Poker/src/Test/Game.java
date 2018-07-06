package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

	public static ArrayList<Player> player = null;
	public static ArrayList<Poker> poker = null;

	public Game() {

		player = new ArrayList();
		poker = new ArrayList();
	}

	// 创建一个扑克牌

	public void setPoker() {
		System.out.println("-------创建一副扑克牌--------");
		String[] suit = { "黑桃", "红桃", "花块", "方片" };
		String[] number = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {

				poker.add(new Poker(number[j], suit[i]));
			}
		}
		System.out.println("--------创建扑克牌完成-------");
	}

	// 打乱牌的次序
	public void shuffer() {
		System.out.println("-------开始洗牌--------");
		Collections.shuffle(poker);
		System.out.println("-------洗牌结束----------");

	}

	// 创建俩个玩家
	public void setPlayer() {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {

			System.out.println("请输第" + (i + 1) + "个玩家的id和姓名");
			System.out.println("请输入id");
			String id = input.next();
			if (player.contains(new Player(id, null))) {
				System.out.println("id重复请重新输入");
				id = input.next();
			}
			System.out.println("请输入姓名");
			String name = input.next();
			player.add(new Player(id, name));

		}
		for (Player player2 : player) {
			System.out.println("欢迎玩家:" + player2.name);
		}

	}

	// 给玩家进行发牌
	public void dealPoker() {
		System.out.println("-------玩家进行发牌-------");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < player.size(); j++) {

				System.out.println(player.get(j).name + "玩家拿牌");

				player.get(i).setCards(poker.get(0));
				poker.remove(0);

			}

		}

		System.out.println("----------发牌结束---------");

	}

	// 比较牌的大小
	public void compare_poker() {

		System.out.println("----游戏开始----");
		String name = null;
		for (int i = 0; i < player.size(); i++) {
			Collections.sort(player.get(i).pokers);
			System.out.println("玩家" + player.get(i) + "的最大手牌为" + player.get(i).pokers.get(1));
			int jude = player.get(0).pokers.get(1).compareTo(player.get(1).pokers.get(1));
			 name = jude > 0 ? player.get(0).name : player.get(1).name;
			
		}
              System.out.println("玩家" + name + "获胜");
	}

	public void showpoker() {

		System.out.println("----玩家手牌展示---");
		System.out.println(player.get(0).name + " " + player.get(0).pokers);
		System.out.println(player.get(1).name + " " + player.get(1).pokers);

	}

}
