package Test;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public String id;
	public String name;
	public List<Poker> pokers = null;

	public Player(String id, String name) {

		this.id = id;
		this.name = name;
		pokers = new ArrayList<Poker>();

	}

	public void setCards(Poker s) {

		pokers.add(s);

	}

	public String toString() {

		return "Name:" + name;

	}
    //重写equals方法可以实现后面的contians的判断。
	public boolean equals(Object s) {

		if (this == s) {

			return true;

		}
		if (s == null) {

			return false;

		}
		Player p = (Player) s;
		return this.id.equals(p.id);

	}

}
