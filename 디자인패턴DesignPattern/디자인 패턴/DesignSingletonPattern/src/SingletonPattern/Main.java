package SingletonPattern;
  // 스레드 문제 해결
public class Main {

	public static void main(String[] args) {
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				MySingleton.getInstance();
				super.run();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				MySingleton.getInstance();
				super.run();
			}
		};
		t1.start();
		t2.start();
	}
}
