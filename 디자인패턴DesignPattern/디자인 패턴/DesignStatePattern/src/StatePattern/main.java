package StatePattern;

interface UnitState {
	public void Attack();

	public void Move();
}

class NormalState implements UnitState {

	@Override
	public void Attack() {
		System.out.println("공격 가능");
	}

	@Override
	public void Move() {
		System.out.println("이동 가능 10만큼");
	}
}

class LockDown implements UnitState {

	@Override
	public void Attack() {
		System.out.println("공격 불가");
	}

	@Override
	public void Move() {
		System.out.println("이동 불가");
	}
}

class Blind implements UnitState {

	@Override
	public void Attack() {
		System.out.println("공격 가능");
	}

	@Override
	public void Move() {
		System.out.println("이동 가능 2만큼");
	}
}

class SiegeTank {
	private UnitState state;

	public SiegeTank(UnitState state) {
		this.state = state;
	}

	public void Attacked(String s) {
		switch (s) {
		case "Medic Blind":
			System.out.println("메딕에게 블라인드 상태 이상 공격을 받음");
			this.state = new Blind();
			break;
		case "Ghost LockDown":
			System.out.println("고스트에게 락다운 상태 이상 공격을 받음");
			this.state = new LockDown();
			break;
		default:
			break;
		}
	}
	
	public void Attack() {
		state.Attack();
	}
	
	public void Move() {
		state.Move();
	}
}

public class main {

	public static void main(String[] args) {
		SiegeTank tank = new SiegeTank(new NormalState());
		tank.Attack();
		tank.Move();

		tank.Attacked("Medic Blind");
		tank.Attack();
		tank.Move();
		
		tank.Attacked("Ghost LockDown");
		tank.Attack();
		tank.Move();
	}

}
