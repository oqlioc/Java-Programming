package TemplateMethodPattern;

abstract class 통학생
{
	public void 통학() {
		기상();
		씻기();
		타기();
		if (!지각()) {
			학교등산();
		}else {
			피시방();
		}
	}

	protected void 기상() {
		System.out.println("기상....");		
	}
	protected void 학교등산() {
		System.out.println("학교에 올라간다.");
	}
	private void 피시방() {
		System.out.println("지각했으니까 롤하자");
	}
	
	abstract protected boolean 지각();
	abstract protected void 씻기();
	abstract protected void 타기();
}

class 의석 extends 통학생{
	
	boolean 지각;
	public 의석(boolean 지각) {
		this.지각 = 지각;
	}
	@Override
	protected boolean 지각() {
		return 지각;
	}

	@Override
	protected void 씻기() {
		System.out.println("목욕!!!!");
	}
	@Override
	protected void 타기() {
		System.out.println("자가용 비행기 탄다");
	}
}

class 종억 extends 통학생{

	boolean 지각;
	public 종억(boolean 지각) {
		this.지각 = 지각;
	}
	@Override
	protected boolean 지각() {
		return 지각;
	}
	
	@Override
	protected void 씻기() {
		System.out.println("샤워만 한다");
	}
	@Override
	protected void 타기() {
		System.out.println("뛰어온다");
	}
	
}

public class main {

	public static void main(String[] args) {

		통학생 A = new 의석(true);
		A.통학();
		
		A = new 종억(false);
		A.통학();
		
	}

}
