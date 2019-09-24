package Unicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {  // Runnable 인터페이스로 쓰레드생성
	private Socket socket;  // 소켓 만듬
	private BufferedReader bufferR;  // 클라이언트 사용자가 서버에 보내주는 채팅내용을 입력 받는 버퍼
	private BufferedWriter bufferW;  // 서버에서 클라이언트 사용자에게 보낼 채팅내용을 담는 버퍼
	private InputStream is;  // 소켓이 사용하는 입력 스트림
	private OutputStream os;  // 소켓이 사용하는 출력 스트림
	private String message;  // 채팅 내용 담는곳

	public UnicastServerThread(Socket socket) {  // UnicastServerThread 생성자
		this.socket = socket;
	}

	public void run() {
		boolean isStop = false;
		try {
			is = socket.getInputStream();  // 소켓에 입력스트림 적용
			bufferR = new BufferedReader(new InputStreamReader(is));  // 소켓의 입력스트림 값을 bufferR에 저장
			os = socket.getOutputStream();  // 소켓에 출력스트림 적용
			bufferW = new BufferedWriter(new OutputStreamWriter(os));  // 소켓의 출력스트림 값을 bufferW에 저장
		} catch (IOException ioe) {
			isStop = true;
		}
		try {
			while (!isStop) {
				String message = bufferR.readLine();  // 클라이언트 사용자가 보내주는 내용을 String message에 넣는다
				if (message.equals("exit")) isStop = true;  // 클라이언트 사용자가 보내주는내용이 exit면 종료한다
				System.out.println("received message : " + message);  // 클라이언트 사용자가 보내주는 내용 출력
				message += System.getProperty("line.separator");  // write의 범위를 표시
				bufferW.write(message);
				bufferW.flush();  // flush()는 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다
			}
		} catch (IOException ioe) {
			System.out.println("클라이언트가 강제로" + "종료되었습니다.");
			isStop = true;
		} finally {
			try {
				if (bufferR != null)  // if (message.equals("exit"))여기서 걸려서  bufferW.flush();이것이 실행안됨 그래서 안에 "exit"값이 아직있다
					bufferR.close();  // bufferR을 닫는다
				if (bufferW != null)  // flush()가 실행안됨 그렇기에 안에 내용이 있음 1
					bufferW.close();  // bufferW을 닫는다 1
				if (socket != null)  // 소켓에 포트값이 있다
					socket.close();  // 소켓의 통신을 닫는다
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}