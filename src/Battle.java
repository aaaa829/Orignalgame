import java.util.Scanner;

public class Battle {

	public static void battleMove(Pleyer p, Enemy e) {
		System.out.printf("%sが現れた！\n", e.name);
		boolean b = true;
		do {
			if (p.speed >= e.speed) {
				b = command(p, e);
				//敵の攻撃時
				b = deadJudge(p, e);
				p.hp = e.attack(e, p);
				b = deadJudge(p, e);
			} else {
				//敵の攻撃時
				p.hp = e.attack(e, p);
				b = deadJudge(p, e);
				b = command(p, e);
				b = deadJudge(p, e);
			}
		} while (b);
	}

	public static boolean command(Pleyer p, Enemy e) {
		boolean b = true;
		int counter = 0;
		do {
			System.out.printf("\n行動を選択してください\n1:攻撃　2:回復　3:逃走　4:%sのステータスを表示　>", p.name);
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				//攻撃を与える時
				e.hp = p.attack(p, e);
				counter++;
				break;
			case 2:
				//回復時
				p = p.recovery(p);
				counter++;
				break;
			case 3:
				//逃走時
				b = p.run(p, e);
				counter++;
				break;
			case 4:
				//プレイヤーのステータス表示
				p.statusDisplay();
				break;
			default:
				System.out.println("\n1～4を入力してください");
			}
		} while (counter < 1);
		return b;
	}

	public static int damage(int attack, int defense) {
		int damage = (attack - defense);
		if (damage < 0) {
			damage = 0;
		}
		return damage;
	}

	public static boolean deadJudge(Pleyer p, Enemy e) {
		boolean b = true;
		if (e.hp <= 0) {
			b = e.dead();
		} else if (p.hp <= 0) {
			b = p.dead();
		}
		return b;
	}
}
