import java.util.Random;

public class Pleyer extends Creature {
	int mp;
	final int HP = 100;

	public Pleyer(String name) {
		Random r = new Random();
		this.name = name;
		this.hp = this.HP;
		this.attack = 100 + r.nextInt(50) + 1;
		this.defense = 50 + r.nextInt(50) + 1;
		this.mp = 10;
		System.out.printf("ようこそ%s\nステータス\n体力：%d\n攻撃力：%d\n防御力：%d\n魔力：%d\n", this.name, this.hp, this.attack,
				this.defense, this.mp);
	}

	public Pleyer recovery(Pleyer p) {
		if (p.mp > 1) {
			if (p.hp < 100) {
				int hp = p.hp;
				p.hp += (p.HP / 2);
				p.mp -= 2;
				if (p.hp > 100) {
					p.hp = p.HP;
				}
				System.out.println((p.hp - hp) + "HPを回復した");
			} else {
				System.out.println("HPは満タンだ");
			}
		} else {
			System.out.println("MPが足りない！\n回復ができませんでした");
		}

		return p;
	}

	public void statusDisplay() {
		System.out.printf("\n%sのステータス\n体力：%d\n攻撃力：%d\n防御力：%d\n魔力：%d\n", this.name, this.hp, this.attack,
				this.defense, this.mp);
	}

}
