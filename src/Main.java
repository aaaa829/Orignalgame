import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("名前を入力してください＞");
		String name = s.nextLine();
		Pleyer p = new Pleyer(name);
		Item item = new Item();
		int result;
		System.out.print("1:ゲームスタート、2:ゲームを終了する >");
		while (true) {
			int select = s.nextInt();
			switch (select) {
			case 1: {
				System.out.println("これからダンジョンを探索して、報酬を手に入れよう");
				Stage a =new Stage(p,item);
				//Resulクラス呼び出し
				result = item.result();
				for(int i =0; i <item.itemi.size();i++) {
					System.out.println(/*item.itemi.get(i)+"："+*/item.item.get(i));
				}
				return;
			}
			case 2: {
				return;
			}
			default: {
				System.out.println("1か2を入力してください >");
			}
			}
		}
		


	}

}
