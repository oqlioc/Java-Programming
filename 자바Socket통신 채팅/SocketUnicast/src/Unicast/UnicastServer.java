package Unicast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private ServerSocket serverS;  // 클라이언트소켓에서 연결되는 서버소켓

	public UnicastServer(int port) {  // UnicastServer의 메소드
		try {
			serverS = new ServerSocket(port);  // 서버소켓의 포트번호 설정
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}
		UnicastServerThread ust = null;  // 소켓스레드 하나 생성
		while (true) {  // 무한루프
			System.out.println("클라이언트 대기중");
			Socket s = null;
			try {
				s = serverS.accept();  // 서버소켓과 클라이언트소켓의 연결을 대기
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			System.out.println("client ip :" + s.getInetAddress().getHostAddress());  // Socket s의 IP주소 출력

			ust = new UnicastServerThread(s);
			Thread t = new Thread(ust);  // 클라이언트에서 들어온 소켓을 스레드에 넣어줌
			t.start();  // 스레드를 실행
		}
	}

	public static void main(String[] args) {
		new UnicastServer(3000);  // 서버의 포트번호는 3000
	}

}