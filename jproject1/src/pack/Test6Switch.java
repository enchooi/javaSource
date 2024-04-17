package pack;

import java.util.Scanner;

public class Test6Switch {

	public static void main(String[] args) {
		// 조건 판단문 switch : 좀 더 정형화된 문법으로 값에 따라 여러 방향으로 분기하는 경우에 사용
		// 길게 늘어진 if문에 비해 코드가 짧고 의미파악이 쉽다.
		int nai = 65;
		nai = nai / 10 * 10;
		//System.out.println(nai);
		switch (nai) {
		case 20: 
			System.out.println("이십대");
			break;
		case 30:
			System.out.println("삼십대");
			System.out.println("만세");
			break;
		default:
			System.out.println("기타");
			break;	// 마지막 조건에서는 선택적
		}
		
		System.out.println();
		String jik = "과장";
		switch(jik) {
		case "대리" :
			System.out.println("대리");
			break;
		case "과장" :
			System.out.println("과장 만세");
			break;
		case "부장" :
			System.out.println("부장 만세2");
			System.out.println("하하하");
			break;
		default:
			System.out.println("기타 직원");
		}
		
		System.out.println();
		System.out.println(Math.random());	// 난수 출력
		//int time = (int)(Math.random() * 10);	// 0 ~ 9 사이의 난수 출력
		int time = (int)(Math.random() * 4) + 8;	// 8 ~ 11 사이 정수 얻기
		System.out.println(time);
		
		switch(time) {
		case 8:
			System.out.println("학원가자");
			break;
		case 9:
			System.out.println("인사하자");
			System.out.println("복습하자");
			//break;
		case 10:
			System.out.println("문제풀자");
			break;
		default:
			System.out.println("명상 시간");
		}
		
		System.out.println();
		// 키보드로 년과 월을 입력받아 해당 년월의 날 수 출력
		int year, month, days=28;
		String msg = "평년";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력:");
		year = sc.nextInt();
		System.out.print("월 입력:");
		month = sc.nextInt();
		//year = 2028;
		//month = 2;
		if(month < 1 || month > 12) {
			System.out.println("월은 1 ~ 12 사이만 허용");	// 입력자료 오류 검사
			System.exit(0);		// 프로그램의 강제 종료
		}
		// 윤년 체크해서 윤년이면 2월에 29
		// 4의 배수이고 100의 배수가 아니거나 400의 배수
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			days = 29;
			msg = "윤년";
		}
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
			days = 31;
			break;
		case 4, 6, 9, 11:
			days = 30;
			break;
//		case 2:
//			break;
		}
		System.out.println(year + "년 " + month + "월은 " + days + " " + msg);
	}

}