import java.util.Random;

public class Enemy extends Creature {

	public Enemy(String name) {
		Random r = new Random();
		this.name = name;
		this.hp = 50;
		this.attack = 90 + r.nextInt(20);
		this.defense = 50 + r.nextInt(10);
	}
	
	public void attack(Enemy e,Pleyer p) {
		//攻撃受けた時
		int ran;
		int damage = Battle.damage(e.attack, p.defense)+ (ran = new Random().nextInt(5));
		System.out.printf("\n%sは%sから%dのダメージを受けた\n", p.name, e.name, damage);
		p.hp -= damage;
	}
}
