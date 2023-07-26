import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Item {

	Map<String,Integer> items = new HashMap<String,Integer>();
	List<Integer> getItem = new ArrayList<Integer>();
	
	int goldCount;
	int silverCount;
	int bronzeCount;
	int platinumCount;
	int heatCount;
	int bornCount;
	
	
	public Item() {
		items.put("銅",40);
		items.put("銀",70);
		items.put("金",100);
		items.put("プラチナ",150);
		items.put("骨",50);
		items.put("心臓",1000);

		this.goldCount = 0;
		this.silverCount= 0;
		this.bronzeCount= 0;
		this.platinumCount= 0;
		this.bornCount = 0;
		this.heatCount = 0;
	}

	public void drop() {
		System.out.println("お宝を見つけた！");
		int r = new Random().nextInt(100);
		if (r <= 50) {
			this.getItem.add(items.get("銅"));
			this.bronzeCount++;
			System.out.println("\n銅を手に入れた\n");
		} else if (r >= 51 && r <= 80) {
			this.getItem.add(items.get("銀"));
			this.silverCount++;
			System.out.println("\n銀を手に入れた\n");
		} else if (r >= 81 && r <= 95) {
			this.getItem.add(items.get("金"));
			this.goldCount++;
			System.out.println("\n金を手に入れた\n");
		} else {
			this.getItem.add(items.get("プラチナ"));
			this.platinumCount++;
			System.out.println("\nプラチナを手に入れた\n");
		}

	}
	

	public int result() {
		int result = 0;
		if (this.getItem.size() != 0) {
			for (int i : this.getItem) {
				result += i;
			}
		}
		return result;
	}
}
