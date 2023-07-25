import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {

	int gold;
	int silver;
	int bronze;
	int platinum;
	List<Integer> item = new ArrayList<Integer>();
	List<String> itemi = new ArrayList<String>();

	public Item() {
		this.platinum = 150;
		this.gold = 100;
		this.silver = 70;
		this.bronze = 40;
	}

	public void drop() {
		int r = new Random().nextInt(100);
		if (r <= 50) {
			item.add(this.bronze);
			itemi.add("銅");
			System.out.println("銅を手に入れた");
		} else if (r >= 51 && r <= 80) {
			item.add(this.silver);
			itemi.add("銀");
			System.out.println("銀を手に入れた");
		} else if (r >= 81 && r <= 95) {
			item.add(this.gold);
			itemi.add("金");
			System.out.println("金を手に入れた");
		} else {
			item.add(this.platinum);
			itemi.add("プラチナ");
			System.out.println("プラチナを手に入れた");
		}

	}

	public int result() {
		int result = 0;
		if (item.size() != 0) {
			for (int i : item) {
				result += item.get(i);
			}
		}
		return result;
	}
}
