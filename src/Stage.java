import java.util.Random;
import java.util.Scanner;

public class Stage {

	public Stage(Pleyer p, Item i) {

		boolean a = true;
		do {
			System.out.print("1:探索を開始する　2:やっぱり帰る >");
			int s = new Scanner(System.in).nextInt();
			switch (s) {
			case 1:
				search(p, i);
				a = false;
				break;
			case 2:
				a = false;
				return;
			default:
				System.out.println("1か2を入力してください");
			}
		} while (a);
	}

	public void search(Pleyer p, Item i) {
		boolean b = true;
		do {
			Random r = new Random();
			int ran = r.nextInt(10) + 1;
			if (ran < 3) {
				//Battleクラス呼び出し、敵クラスの呼び出し
				Enemy e = new Enemy("敵");
				Battle.battleMove(p, e);
				if (p.hp != 0) {
					b = select(b);
				} else if (e.hp == 0) {
					i.drop();

				} else {
					b = false;
				}
			} else if (ran >= 3 && ran < 6) {
				//Itemクラス呼び出し
				i.drop();
				System.out.println("ドロップ");
				b = select(b);
			} else {
				System.out.println("何も...ながっだ！");
				b = select(b);
			}

		} while (b || p.hp == 0);
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
