import java.util.Random;

public class Enemy extends Creature {

	public Enemy(String name) {
		Random r = new Random();
		this.name = name;
		this.hp = 50;
		this.attack = 90 + r.nextInt(20);
		this.defense = 50 + r.nextInt(10);
	}

}
