import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class ItemManager {

	Map<String, Item> items = new LinkedHashMap<String, Item>();

	public ItemManager() {
		String path = "csvdate/Items.csv";
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split(",");
				String name = datas[0];
				int price = Integer.parseInt(datas[1]);
				Item item = new Item(name, price);
				items.put(name, item);
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void drop() {
		System.out.print("お宝を見つけた！");
		Sleep.sleep();
		int r = new Random().nextInt(100);
		if (r <= 50) {
			getItem("銅");

		} else if (r >= 51 && r <= 80) {
			getItem("銀");
		} else if (r >= 81 && r <= 95) {
			getItem("金");
		} else {
			getItem("プラチナ");
		}

	}

	public void enemyDrop(Enemy e) {
		System.out.printf("\n%sは何かを落とした", e.name);
		Sleep.sleep();
		int r = new Random().nextInt(100);
		switch (e.name) {
		case ("スライム"):
			if (r <= 90) {
				getItem("スライムの粘液");
			} else {
				getItem("スライムコア");
			}
			break;
		case ("ゴブリン"):
			if (r <= 90) {
				getItem("ゴブリンの牙");
			} else {
				getItem("ゴブリンの肝");
			}
			break;
		case ("スケルトン"):
			if (r <= 90) {
				getItem("スケルトンの骨");
			} else {
				getItem("スケルトンの頭蓋骨");
			}
			break;
		case ("ドラゴン"):
			if (r <= 90) {
				getItem("竜骨");
			} else {
				getItem("竜の心臓");
			}
			break;
		}

	}

	public void getItem(String key) {
		this.items.get(key).number++;
		System.out.printf("%sを手に入れた\n", key);
	}

	public int result(Pleyer p) {
		int result = 0;
		//		if (p.hp > 0) {
		//			for (String key : items.keySet()) {
		//				if (items.get(key).number > 0) {
		//					Item item = items.get(key);
		//					System.out.println(key + " ・・・￥" + item.price + " ×" + item.number);
		//					result += item.price * item.number;
		//				}
		//			}
		//		} else if (p.hp <= 0) {
		//			Random r = new Random();
		//			String[] keys = new String[items.size()];
		//			List<String> removekey = new ArrayList<>();
		//			for (String key : items.keySet()) {
		//				int i = 0;
		//				keys[i] = key;
		//				i++;
		//			}
		//			for (int i = 0; i < items.size() / 2; i++) {
		//				for (int j = 0; j < removekey.size(); j++) {
		//					int rand = r.nextInt(items.size());
		//					items.remove(keys[rand]);
		//					removekey.add(keys[rand]);
		//				}
		//			}
		//			for (int k = 0; k < removekey.size(); k++) {
		//				System.out.println(removekey.get(k) + "を落とした");
		//			}
		for (String key : items.keySet()) {
			if (items.get(key).number > 0) {
				Item item = items.get(key);
				System.out.println(key + " ・・・￥" + item.price + " ×" + item.number);
				result += item.price * item.number;
			}
		}
		//		}
		return result;
	}
}
