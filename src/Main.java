import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("名前を入力してください＞");
		String name = s.nextLine();
		Pleyer p = new Pleyer(name);
	}

}
