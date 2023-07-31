import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ItemManager {

	Map<String, Integer> items = new LinkedHashMap<String, Integer>();
	List<Integer> getItem = new ArrayList<Integer>();
	int[] counts = new int[12];

	public ItemManager() {
		String path = "c:/Users/0609PM/Desktop/eclips_workspace/Dungeon/csvdate/Items.csv";
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split(",");
				String name = datas[0];
				int price = Integer.parseInt(datas[1]);
				items.put(name, price);
			}
			br.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		for (int i : counts) {
			counts[i] = 0;
		}
	}

	public void drop() {
		System.out.print("\nお宝を見つけた！");
		Sleep.sleep();
		int r = new Random().nextInt(100);
		if (r <= 50) {
			getItem("銅");
			counts[0]++;
		} else if (r >= 51 && r <= 80) {
			getItem("銀");
			counts[1]++;
		} else if (r >= 81 && r <= 95) {
			getItem("金");
			counts[2]++;
		} else {
			getItem("プラチナ");
			counts[3]++;
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
				counts[4]++;
			} else {
				getItem("スライムコア");
				counts[5]++;
			}
			break;
		case ("ゴブリン"):
			if (r <= 90) {
				getItem("ゴブリンの牙");
				counts[6]++;
			} else {
				getItem("ゴブリンの肝");
				counts[7]++;
			}
			break;
		case ("スケルトン"):
			if (r <= 90) {
				getItem("スケルトンの骨");
				counts[8]++;
			} else {
				getItem("スケルトンの頭蓋骨");
				counts[9]++;
			}
			break;
		case ("ドラゴン"):
			if (r <= 90) {
				getItem("竜骨");
				counts[10]++;
			} else {
				getItem("竜の心臓");
				counts[11]++;
			}
			break;
		}

	}
	
	public void getItem(String key) { 
		this.getItem.add(items.get(key));
		System.out.printf("%sを手に入れた\n",key);
	}
	
	
	public int result() {
		int result = 0;
		if (this.getItem.size() > 0) {
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
