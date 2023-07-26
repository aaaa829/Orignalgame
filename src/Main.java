import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("名前を入力してください＞");
		String name = s.nextLine();
		Pleyer p = new Pleyer(name);
		Item item = new Item();

		System.out.print("1:ゲームスタート、2:ゲームを終了する >");
		while (true) {
			int select = s.nextInt();
			switch (select) {
			case 1:
				System.out.println("これからダンジョンを探索して、報酬を手に入れよう");
				Stage a = new Stage(p, item);
				//Resulクラス呼び出し
				int result = item.result();
				System.out.println("\n手に入れたものを換金します。");
				for(String key : item.items.keySet()) {
					int value = item.items.get(key);
					System.out.println(key+" ・・・￥"+value);
					
				}
//				System.out.println("銅"+"    ×"+item.bronzeCount);
//				System.out.println("銀　　　　×"+item.silverCount);
//				System.out.println("金　　　　×"+item.goldCount);
//				System.out.println("プラチナ　×"+item.platinumCount);
				System.out.println("今回の報酬額は￥"+result+"でした");
				return;

			case 2:
				return;

			default:
				System.out.println("1か2を入力してください >");

			}
		}

	}

}
