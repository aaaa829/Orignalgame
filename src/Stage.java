import java.util.Random;
import java.util.Scanner;

public class Stage {

	public Stage(Pleyer p, ItemManager i) {

		boolean a = true;
		do {
			System.out.print("\n1:探索を開始する　2:やっぱり帰る >");
			int s = new Scanner(System.in).nextInt();
			System.out.println();
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

	public void search(Pleyer p, ItemManager i) {
		boolean b = true;
		int count = 0;
		do {
			Random r = new Random();
			int rand = r.nextInt(10);
			if (count >= 30) {
				rand = r.nextInt(1);
				if (rand < 2) {
					System.out.println("これ以上奥に進めない\n帰って今回手に入れたお宝を換金します");
					b = false;
				} else {
					System.out.println("広場に出た");
					Sleep.sleep();
					System.out.println("ドラゴンが現れた！");
					Enemy d = new Enemy("ドラゴン");
					Battle.battleMove(p, d);
					if (d.hp <= 0) {
						i.enemyDrop(d);
					}
					b = false;
				}
			} else {
				if (rand <= 3) {
					String[] enemynames = { "スライム", "ゴブリン", "スケルトン" };
					Enemy e = new Enemy(enemynames[r.nextInt(enemynames.length)]);
					Battle.battleMove(p, e);
					if (e.hp <= 0) {
						i.enemyDrop(e);
						b = select(b, p);
					} else if (p.hp <= 0) {
						b = false;
					} else {
						b = select(b, p);
					}
				} else if (rand >= 4 && rand <= 6) {

					i.drop();
					b = select(b, p);
				} else if (rand >= 7) {
					Sleep.sleep();
					System.out.println("何もない。ただの通路だ");
					b = select(b, p);
				}
				count++;
			}
		} while (b);
	}

	public static boolean select(boolean b, Pleyer p) {
		while (true) {
			System.out.print("\n1:探索を続ける　2:探索をやめる 3:HP回復する(MPを2消費) 4:ステータスを表示>");
			int select = Integer.parseInt(new Scanner(System.in).next());
			switch (select) {
			case 1:
				b = true;
				return b;
			case 2:
				b = false;
				return b;
			case 3:
				p = p.recovery(p);
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
