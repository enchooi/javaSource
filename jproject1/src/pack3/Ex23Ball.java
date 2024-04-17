package pack3;

// 인터페이스를 구현하고 모든 추상 메소드를 오버라이드 하는 지옥에서 벗어날 수 있다.
// 추상을 일반 메소드로 만들어 둔 어댑터 클래스를 상속받아 선택적으로 메소드를 작성.

//public class Ex23Ball implements Ex23Flyer{	// 인터페이스로 한다면 3개의 메소드를 오버라이딩해야됨
public class Ex23Ball extends Ex23FlyerAdapter{		// 너가 하고 싶은것만 오버라이딩해~
	@Override
	public void fly() {
		System.out.println("공이 관중석으로 날아감");
	}
}
