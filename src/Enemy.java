import java.util.Random;

public class Enemy extends Creature {
	Random r = new Random();

	public Enemy(String name) {
		if (name.equals("ドラゴン")) {
			this.name = name;
			this.hp = 300;
			this.attack = 150 + this.r.nextInt(30);
			this.defense = 50 + this.r.nextInt(20);
			this.speed = 50 + this.r.nextInt(50) + 1;
		} else {
			this.name = name;
			this.hp = 100;
			this.attack = 50 + this.r.nextInt(30);
			this.defense = 50 + this.r.nextInt(10);
			this.speed = 30 + this.r.nextInt(50) + 1;
		}
	}

	public int attack(Enemy e, Pleyer p) {
		//敵の攻撃時
		if (e.hp > 0) {
			int damage = Battle.damage(e.attack, p.defense) + (this.r.nextInt(10));
			System.out.printf("%sは%sに%dのダメージを与えた\n", e.name, p.name, damage);
			p.hp -= damage;
		}
		return p.hp;
	}

	public boolean dead() {
		System.out.printf("\n%sを倒した", this.name);
		return false;
	}
}
