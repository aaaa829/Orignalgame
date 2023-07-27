import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Item {

	Map<String, Integer> items = new LinkedHashMap<String, Integer>();
	List<Integer> getItem = new ArrayList<Integer>();
	int[] counts = new int[12];

	public Item() {
		items.put("銅", 500);
		items.put("銀", 800);
		items.put("金", 1000);
		items.put("プラチナ", 2000);
		items.put("スライムの粘液", 1000);
		items.put("スライムコア", 3000);
		items.put("ゴブリンの牙", 1200);
		items.put("ゴブリンの肝", 4000);
		items.put("スケルトンの骨", 1500);
		items.put("スケルトンの頭蓋骨", 4500);
		items.put("竜骨", 5000);
		items.put("竜の心臓", 10000);

		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}
	}

	public void drop() {
		System.out.print("\nお宝を見つけた！");
		Sleep.sleep();
		int r = new Random().nextInt(100);
		if (r <= 50) {
			this.getItem.add(items.get("銅"));
			counts[0] += 1;
			System.out.println("銅を手に入れた\n");
		} else if (r >= 51 && r <= 80) {
			this.getItem.add(items.get("銀"));
			counts[1] += 1;
			System.out.println("銀を手に入れた\n");
		} else if (r >= 81 && r <= 95) {
			this.getItem.add(items.get("金"));
			counts[2] += 1;
			System.out.println("金を手に入れた\n");
		} else {
			this.getItem.add(items.get("プラチナ"));
			counts[3] += 1;
			System.out.println("プラチナを手に入れた\n");
		}

	}

	public void enemyDrop(Enemy e) {
		System.out.printf("\n%sは何かを落とした", e.name);
		Sleep.sleep();
		int r = new Random().nextInt(100);
		switch (e.name) {
		case ("スライム"):
			if (r <= 90) {
				this.getItem.add(items.get("スライムの粘液"));
				counts[4] += 1;
				System.out.println("スライムの粘液を手に入れた\n");
			} else {
				this.getItem.add(items.get("スライムコア"));
				counts[5] += 1;
				System.out.println("スライムコアを手に入れた\n");
			}
			break;
		case ("ゴブリン"):
			if (r <= 90) {
				this.getItem.add(items.get("ゴブリンの牙"));
				counts[7] += 1;
				System.out.println("ゴブリンの牙を手に入れた\n");
			} else {
				this.getItem.add(items.get("ゴブリンの肝"));
				counts[8] += 1;
				System.out.println("ゴブリンの肝を手に入れた\n");
			}
			break;
		case ("スケルトン"):
			if (r <= 90) {
				this.getItem.add(items.get("スケルトンの骨"));
				counts[9] += 1;
				System.out.println("スケルトンの骨を手に入れた\n");
			} else {
				this.getItem.add(items.get("スケルトンの頭蓋骨"));
				counts[10] += 1;
				System.out.println("スケルトンの頭蓋骨を手に入れた\n");
			}
			break;
		case ("ドラゴン"):
			if (r <= 90) {
				this.getItem.add(items.get("竜骨"));
				counts[11] += 1;
				System.out.println("竜骨を手に入れた\n");
			} else {
				this.getItem.add(items.get("竜の心臓"));
				counts[12] += 1;
				System.out.println("竜の心臓を手に入れた\n");
			}
		break;
		}

	}

	public int result() {
		int result = 0;
		if (this.getItem.size() != 0) {
			for (int i : this.getItem) {
				result += i;
			}
		}
		int i = 0;
		for (String key : items.keySet()) {
			int value = items.get(key);
			if (counts[i] >= 1) {
				System.out.println(key + " ・・・￥" + value + " ×" + counts[i]);
			}
			i++;
		}
		return result;
	}
}
