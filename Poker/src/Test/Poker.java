package Test;

public class Poker implements Comparable<Poker> {

	public String number;
	public String suit;

	public Poker(String number, String suit) {

		this.number = number;
		this.suit = suit;

	}

	public String toString() {

		return number + "---" + suit;

	}

	public int compareTo(Poker s) {


		if (this.getNumberNum() == s.getNumberNum()) {

			return this.getSuitNum() - s.getSuitNum();

		} else {

			return this.getNumberNum() - s.getNumberNum();

		}

	}

	// »ñÈ¡ÅÆµãÊıÅÅĞò
	public int getNumberNum() {

		String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].equals(number)) {

				return i;

			}
		}
		return -1;

	}

	public int getSuitNum() {

		String[] suits = { "ºÚÌÒ", "ºìÌÒ", "»¨¿é", "·½Æ¬" };
		for (int i = 0; i < suits.length; i++) {

			if (suits[i].equals(suit)) {

				return (3-i);

			}

		}

		return -1;
	}

}
