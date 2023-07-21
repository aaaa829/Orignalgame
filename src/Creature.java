
public class Creature {
	String name;
	int attack;
	int hp;
	int defense;
	int speed;
	
	public void dead() {
		if(this.hp == 0) {
			System.out.printf("%sは死んだ",this.name);
		}
	}
}
