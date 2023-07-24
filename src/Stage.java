import java.util.Random;
import java.util.Scanner;

public class Stage {

	public Stage(int hp) {
		boolean a = true;
		do {
			System.out.print("1:探索を開始する　2:やっぱり帰る >");
			int s = new Scanner(System.in).nextInt();
			switch (s) {
			case 1:
				search(hp);
				a = false;
				break;
			case 2:
				a = false;
				return;
			default:
				System.out.println("1か2を入力してください");
			}
		}while (a);
	}

	public static void search(int hp) {
		boolean b = true;
		do {
			int r = new Random().nextInt(10) + 1;
			if (r < 3) {
				//Battleクラス呼び出し
				System.out.println("Battle");
				b = select(b);
			} else if (r >= 3 && r < 6) {
				//Itemクラス呼び出し
				System.out.println("ドロップ");
				b = select(b);
			} else {
				System.out.println("何も...ながっだ！");
				b = select(b);
			}

		} while (b || hp == 0);
	}

	public static boolean select(boolean b) {
		while (true) {
			System.out.println("1:探索を続ける　2:探索をやめる >");
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				b = true;
				return b;
			case 2:
				b = false;
				return b;
			default:
				System.out.println("1か2を入力してください");
			}
		}
	}
}
