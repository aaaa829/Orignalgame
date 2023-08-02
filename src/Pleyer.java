import java.util.Random;

public class Pleyer extends Creature {
	int mp;
	final int MP = 10;
	final int HP = 100;
	Random r = new Random();

	public Pleyer(String name) {
		this.name = name;
		this.hp = this.HP;
		this.attack = 100 + this.r.nextInt(50) + 1;
		this.defense = 50 + this.r.nextInt(50) + 1;
		this.speed = 50 + this.r.nextInt(50) + 1;
		this.mp = 10;
		statusDisplay();
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

	public int attack(Pleyer p, Enemy e) {
		int damage = Battle.damage(p.attack, e.defense) + (this.r.nextInt(50) + 1);
		System.out.printf("%sは%sに%dのダメージを与えた\n", p.name, e.name, damage);
		e.hp -= damage;
		return e.hp;
	}

	public boolean dead() {
		System.out.printf("\n%sはもう戦えない\n急いでダンジョンを抜け出した\n", this.name);
		return false;
	}

	public void statusDisplay() {
		System.out.printf("\n%sのステータス\nHP：%d\nATK：%d\nDEF：%d\nSPD : %d\nMP：%d\n",
				this.name, this.hp, this.attack, this.defense, this.speed, this.mp);
	}

	public boolean run(Pleyer p, Enemy e) {
		int rand = r.nextInt(3);
		if (rand < 2 && (!(e.name.equals("ドラゴン")))) {
			//逃走成功
			System.out.printf("\n%sは逃げ出した", p.name);
			return false;
		} else {
			//逃走失敗
			System.out.printf("\n%sは逃げられない", p.name);
			//敵の攻撃時
			p.hp = e.attack(e, p);
			return true;
		}
	}

}
