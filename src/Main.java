import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("名前を入力してください＞");
		String name = s.nextLine();
		Pleyer p = new Pleyer(name);
		ItemManager item = new ItemManager();

		System.out.print("1:ゲームスタート、2:ゲームを終了する >");
		while (true) {
			int select = Integer.parseInt(s.nextLine());
			switch (select) {
			case 1:
				System.out.println("これからダンジョンを探索して、報酬を手に入れよう");
				Stage a = new Stage(p, item);
				//Resulクラス呼び出し
				System.out.println("\n手に入れたものを換金します。");
				int result = item.result();
				System.out.println("\n今回の報酬額は￥"+result+"でした");
				return;

			case 2:
				return;

			default:
				System.out.println("1か2を入力してください >");

			}
		}

	}

}
