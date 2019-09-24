package ObserverPattern;

import java.util.ArrayList;
import java.util.Random;

interface Fan {
	public void hear(String s);
}

interface Talent {
	public void addFan(Fan o);

	public void deleteFan(Fan o);

	public void speak();

}

class Singer implements Talent {

	private ArrayList<Fan> FanList;

	public Singer() {
		FanList = new ArrayList<Fan>();
	}

	@Override
	public void addFan(Fan o) {
		FanList.add(o);
	}

	@Override
	public void deleteFan(Fan o) {
		int idx = FanList.indexOf(o);
		FanList.remove(idx);
	}

	@Override
	public void speak() {
		String[] m = { "사랑해요 팬여러분~~", "사생팬은 저리가~~" };
		Random r = new Random();
		int idx = r.nextInt(m.length);
		for (int i = 0; i < FanList.size(); i++) {
			Fan o = FanList.get(i);
			o.hear(m[idx]);
		}
	}
}

class SingerFan implements Fan {
	private String name;

	public SingerFan(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void hear(String s) {
		System.out.println(name + "은 " + s + "를 들었습니다.");
	}
}

public class main {

	public static void main(String[] args) {

		Singer 비와이 = new Singer();
		SingerFan a = new SingerFan("정의석");
		SingerFan b = new SingerFan("홍수호");
		SingerFan c = new SingerFan("정유진");
		SingerFan d = new SingerFan("김찬호");
		SingerFan e = new SingerFan("이석화");
		SingerFan f = new SingerFan("김미영");
		
		비와이.addFan(a);
		비와이.addFan(b);
		비와이.addFan(c);
		비와이.speak();
		System.out.println("----------------------------------------");
		비와이.addFan(d);
		비와이.addFan(e);
		비와이.speak();
		System.out.println("----------------------------------------");
		비와이.addFan(f);
		비와이.speak();
	}
}
