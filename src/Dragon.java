//import java.util.Random;
//
//public class Dragon  extends Creature{
//	Random r = new Random();
//
//	public Dragon(String name) {
//		this.name = name;
//		this.hp = 300;
//		this.attack = 100 + this.r.nextInt(30);
//		this.defense = 50 + this.r.nextInt(20);
//	}
//
//	public int attack(Dragon d, Pleyer p) {
//		//敵の攻撃時
//		if (d.hp > 0) {
//			int damage = Battle.damage(d.attack, p.defense) + this.r.nextInt(20);
//			System.out.printf("\n%sは%sから%dのダメージを受けた\n", p.name, d.name, damage);
//			p.hp -= damage;
//		}
//		return p.hp;
//	}
//
//	public boolean dead() {
//		System.out.printf("\n%sを倒した\n",this.name);
//		return false;
//	}
//}
