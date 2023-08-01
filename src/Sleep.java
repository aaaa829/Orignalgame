
public class Sleep {

	public static void sleep() {
		for (int i = 3; i > 0; i--) {
			System.out.print("・");
			try {
				// 1秒（1000ミリ秒）間停止
				Thread.sleep(500);
			} catch (Exception e) {
				;
			}
		}
	}

}
