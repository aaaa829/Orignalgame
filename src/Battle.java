import java.util.Random;
import java.util.Scanner;

public class Battle {

	public static void battleMove(Pleyer p, Enemy e) {
		do {
			System.out.print("行動を選択してください\n1:攻撃　2:回復　3:逃走　他:何もしない>");
			int select = new Scanner(System.in).nextInt();
			int damage;
			switch (select) {
			case 1: {
				//攻撃を与える時
				damage = damage(p.hp, e.defense);
				e.hp = damage;
				System.out.printf("%sは%sに%dのダメージを与えた\n", p.name, e.name, damage);
				break;
			}
			case 2: {
				//回復時
				p.hp += (p.HP / 2);
				p.mp -= 2;
				break;
			}
			case 3: {
				int run = new Random().nextInt(3);
				if (run < 1) {
					System.out.printf("%sは逃げられない\n", p.name);
				} else {
					System.out.printf("%sは逃げ出した\n", p.name);
					return;
				}
				break;
			}
			default:
				break;
			}
			//攻撃受けた時
			damage = damage(e.attack, p.defense);
			System.out.printf("%sは%sから%dのダメージを受けた\n", p.name, e.name, damage);
			p.hp = damage;
		} while (p.hp == 0 || e.hp == 0);
	}

	public static int damage(int attack, int defense) {
		int damage = (attack - defense);

		if (damage < 0) {
			damage = 0;
		}

		return damage;
	}
}
