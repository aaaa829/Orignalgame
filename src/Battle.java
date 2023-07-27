import java.util.Scanner;

public class Battle {

	public static void battleMove(Pleyer p, Enemy e) {
		boolean b = true;
		System.out.printf("%sが現れた！\n",e.name);
		do {
			System.out.printf("\n行動を選択してください\n1:攻撃　2:回復　3:逃走　4:%sのステータスを表示　>",p.name);
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				//攻撃を与える時
				e.hp = p.attack(p, e);
				//敵の攻撃時
				p.hp = e.attack(e, p);
				break;
			case 2:
				//回復時
				p = p.recovery(p);
				//敵の攻撃時
				p.hp = e.attack(e, p);
				break;
			case 3:
				//逃走時
				b = p.run(p, e);
				break;
			case 4:
				//プレイヤーのステータス表示
				p.statusDisplay();
				break;
			default:
				System.out.println("\n1～4を入力してください");
			}
			if (e.hp <= 0) {
				b = e.dead();
			} else if (p.hp <= 0) {
				b = p.dead();
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
