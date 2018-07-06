package cmd.cn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Filet {
	public static Map<Integer, Person> read() {
		Map<Integer, Person> us = new HashMap<Integer, Person>();
		String filePath = "C://account.txt";
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		File f = new File(filePath);
		try {
			if (!f.exists()) {

				f.createNewFile();
			}
			FileReader fr = new FileReader(filePath);

			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String[] members = line.split(",");
				Person u = new Person();
				int id = Integer.parseInt(members[0].trim());
				u.setId(id);
				u.setName(members[1]);
				u.setTelephone(members[2]);
				u.setMoney(Double.parseDouble(members[3]));
				us.put(id, u);

			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return us;
	}

	public static void write(Map<Integer, Person> hs) {

		String filePath = "C://account.txt";
		File m = new File(filePath);
		if (m.exists()) {

			m.delete();
		}

		try {
			FileWriter writer = new FileWriter("C://account.txt", true);

			for (Object key : hs.keySet()) {
				Person s = hs.get(key);
				writer.write("" + s.getId() + ",");
				writer.write(s.getName() + ",");
				writer.write(s.getTelephone() + ",");
				String money = String.valueOf(s.getMoney());
				writer.write(money);
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
