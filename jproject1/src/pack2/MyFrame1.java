package pack2;

import java.awt.Frame;

// 자바가 제공하는 Frame 클래스로 창 띄우기 : 포함 관계
public class MyFrame1 {
	private String title = "포함관계";
	private Frame frame;
	
	public MyFrame1() {
		frame = new Frame(title);
	}
	
	private void display() {
		frame.setSize(500, 300);
		frame.setLocation(200, 150);
		frame.setVisible(true);
	}
		
	public static void main(String[] args) {
		MyFrame1 frame1 = new MyFrame1();
		frame1.display();
		//new MyFrame1().display();   --> 생성자를 부르고 .을 찍고 부르고 싶은거 부르고
	}

}
