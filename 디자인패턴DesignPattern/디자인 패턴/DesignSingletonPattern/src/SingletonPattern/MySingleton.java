package SingletonPattern;

public class MySingleton {

	private static MySingleton mysingleton;

	private MySingleton() {
		System.out.println("생성자 호출");
	}

	// synchronized 사용안하고 만들기
	public synchronized static MySingleton getInstance() {
		System.out.println("Instance 메소드 호출");
		if (mysingleton == null) {
			synchronized (MySingleton.class) {
				if (mysingleton == null) {
					mysingleton = new MySingleton();
				}
				return mysingleton;
			}
		} else {
			return mysingleton;
		}
	}
}
