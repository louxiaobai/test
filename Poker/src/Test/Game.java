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

	// ����һ���˿���

	public void setPoker() {
		System.out.println("-------����һ���˿���--------");
		String[] suit = { "����", "����", "����", "��Ƭ" };
		String[] number = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {

				poker.add(new Poker(number[j], suit[i]));
			}
		}
		System.out.println("--------�����˿������-------");
	}

	// �����ƵĴ���
	public void shuffer() {
		System.out.println("-------��ʼϴ��--------");
		Collections.shuffle(poker);
		System.out.println("-------ϴ�ƽ���----------");

	}

	// �����������
	public void setPlayer() {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {

			System.out.println("�����" + (i + 1) + "����ҵ�id������");
			System.out.println("������id");
			String id = input.next();
			if (player.contains(new Player(id, null))) {
				System.out.println("id�ظ�����������");
				id = input.next();
			}
			System.out.println("����������");
			String name = input.next();
			player.add(new Player(id, name));

		}
		for (Player player2 : player) {
			System.out.println("��ӭ���:" + player2.name);
		}

	}

	// ����ҽ��з���
	public void dealPoker() {
		System.out.println("-------��ҽ��з���-------");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < player.size(); j++) {

				System.out.println(player.get(j).name + "�������");

				player.get(i).setCards(poker.get(0));
				poker.remove(0);

			}

		}

		System.out.println("----------���ƽ���---------");

	}

	// �Ƚ��ƵĴ�С
	public void compare_poker() {

		System.out.println("----��Ϸ��ʼ----");
		String name = null;
		for (int i = 0; i < player.size(); i++) {
			Collections.sort(player.get(i).pokers);
			System.out.println("���" + player.get(i) + "���������Ϊ" + player.get(i).pokers.get(1));
			int jude = player.get(0).pokers.get(1).compareTo(player.get(1).pokers.get(1));
			 name = jude > 0 ? player.get(0).name : player.get(1).name;
			
		}
              System.out.println("���" + name + "��ʤ");
	}

	public void showpoker() {

		System.out.println("----�������չʾ---");
		System.out.println(player.get(0).name + " " + player.get(0).pokers);
		System.out.println(player.get(1).name + " " + player.get(1).pokers);

	}

}
