import java.util.Random;

public class Pleyer extends Creature {
	int mp;
	final int HP = 100;
	
	public Pleyer(String name) {
		Random r = new Random();
		this.name = name;
		this.hp = this.HP;
		this.attack = 50 + r.nextInt(50)+1;
		this.defense = 50 + r.nextInt(50)+1;
		this.speed = 50 + r.nextInt(50)+1;
		this.mp = 10;
		System.out.printf("ようこそ%s\nステータス\n体力：%d\n攻撃力：%d\n防御力：%d\n素早さ：%d\n魔力：10\n"
				,this.name,this.hp,this.attack,this.defense,this.speed);
	}
	
	public void stageMove() {
		
	}
	public void battleMove() {
		//攻撃受けた時
		this.hp = Battle.damage(this.hp,this.attack);
//		this.hp -= attack;
		//回復時
		this.hp += (this.HP/2);
		mp -= 2;
		
	}
	
}
