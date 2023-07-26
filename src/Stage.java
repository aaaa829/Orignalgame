import java.util.Random;
import java.util.Scanner;

public class Stage {

	public Stage(Pleyer p, Item i) {

		boolean a = true;
		do {
			System.out.print("\n1:探索を開始する　2:やっぱり帰る >");
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
		int count = 0;
		do {
			Random r = new Random();
			int ran = r.nextInt(10);
			if (count >= 20) {
				b = false;
				System.out.println("これ以上奥に進めない\n帰って今回手に入れたお宝を換金します");
			} else {
				if (ran <= 2) {
					//Battleクラス呼び出し、敵クラスの呼び出し
					Enemy e = new Enemy("敵");
					Battle.battleMove(p, e);
					if (e.hp <= 0) {
						System.out.printf("%sから何かが出てきた...",e.name);
						i.drop();
						b = select(b, p);
					} else if (p.hp <= 0) {
						b = false;
					} else {
						b = select(b, p);
					}
				} else if (ran >= 3 && ran <= 4) {
					//Itemクラス呼び出し
					i.drop();
					b = select(b, p);
				} else if (ran >= 5) {
					System.out.println("\n何も...ながっだ！");
					System.out.println();
					b = select(b, p);
				}
				count++;
			}
		} while (b);
	}

	public static boolean select(boolean b, Pleyer p) {
		while (true) {
			System.out.printf("1:探索を続ける　2:探索をやめる 3:回復する(MPを消費) 4:%sのステータスを表示する>", p.name);
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				b = true;
				return b;
			case 2:
				b = false;
				return b;
			case 3: 
				p.recovery(p);
				break;
			case 4:
				p.statusDisplay();
				break;
			default:
				System.out.println("1～4を入力してください");
			}
		}
	}
}
