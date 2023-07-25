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
				System.out.println(result);

				return;

			case 2:
				return;

			default:
				System.out.println("1か2を入力してください >");

			}
		}

	}

}
