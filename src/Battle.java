import java.util.Random;
import java.util.Scanner;

public class Battle {

	public static void battleMove(Pleyer p, Enemy e) {
		boolean b = true;
		int damage;
		Random r = new Random();
		int ran;
		do {
			System.out.print("\n行動を選択してください\n1:攻撃　2:回復　3:逃走　他:何もしない>");
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1: {
				//攻撃を与える時
				damage = damage(p.attack, e.defense) + (ran = r.nextInt(10)+1);
				e.hp -= damage;
				System.out.printf("\n%sは%sに%dのダメージを与えた\n", p.name, e.name, damage);
				break;
			}
			case 2: {
				//回復時
				p = p.recovery(p);
				break;
			}
			case 3: {
				ran = r.nextInt(3);
				if (ran < 1) {
					System.out.printf("\n%sは逃げられない\n", p.name);
				} else {
					System.out.printf("\n%sは逃げ出した\n", p.name);
					return;
				}
				break;
			}
			default:
				break;
			}
			//攻撃受けた時
			damage = damage(e.attack, p.defense)+ (ran = r.nextInt(5));
			System.out.printf("\n%sは%sから%dのダメージを受けた\n", p.name, e.name, damage);
			p.hp -= damage;
			if (e.hp <= 0) {
				System.out.println("\n敵を倒した！");
				b = false;
			} else if (p.hp <= 0) {
				System.out.printf("\n%sは倒れた....",p.name);
				b = false;
			}
		} while (b);
	}

	public static int damage(int attack, int defense) {
		int damage = (attack - defense);

		if (damage < 0) {
			damage = 0;
		}

		return damage;
	}
}
