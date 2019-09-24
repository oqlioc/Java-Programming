package Unicast;

import java.io.*;
import java.net.*;

public class UnicastClient {
	private String ip;
	private int port;
	private String message;
	private BufferedReader file = null;
	private BufferedWriter bufferW = null;  // 클라이언트 사용자가 서버에 보내주는 채팅내용을 입력 받는 버퍼
	private BufferedReader bufferR = null;  // 서버에서 클라이언트 사용자에게 보낸 채팅내용을 담는 버퍼

	public UnicastClient(String ip, int port) throws IOException {
		this.ip = ip;  // 서버의 IP
		this.port = port;  // 서버가 정한 포트번호
		boolean isStop = false;
		Socket tcpSocket = getSocket();  // 소켓을 생성하고 소켓의 값을 넣어준다
		OutputStream os = tcpSocket.getOutputStream();  // 소켓에 출력스트림을 적용
		InputStream is = tcpSocket.getInputStream();  // 소켓에 입력스트림을 적용
		bufferW = new BufferedWriter(new OutputStreamWriter(os));  // 소켓의 출력스트림의 값을 bufferW에 넣어준다
		bufferR = new BufferedReader(new InputStreamReader(is));  // 소켓의 입력스트림의 값을 bufferR에 넣어준다
		while (!isStop) {
			System.out.print("message : ");
			file = new BufferedReader(new InputStreamReader(System.in));
			// System.in의 키보드의 값 아스키코드를 InputStreamReader로 문자로 변환한것을 BufferedReader이것이 file버퍼에 넣어준다
			message = file.readLine();  // file 버퍼의 값을 message에 한줄씩 넣어준다
			message += System.getProperty("line.separator");  // message에 줄바꿈을 넣어준다
			bufferW.write(message);  // line.separator을 기준으로 message의 값을 넣어준다
			bufferW.flush();  // bufferW의 버퍼에 값을 서버에 보내주고 버퍼의 값을 비워준다

			message = bufferR.readLine();  // 서버에서 보낸 채팅내용을 message에 넣어준다
			if (message.equals("exit")) {  // message의 값을 비교
				isStop = true;
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("Received message : " + message);
			}

		}
		tcpSocket.close();  // 소켓을 닫는다
		bufferW.close();  // bufferW을 닫는다
		bufferR.close();  // bufferR을 닫는다
		file.close();  // file을 닫는다
	}

	public Socket getSocket() {
		Socket tcpSocket = null; //소켓 생성값이 null
		try {
			tcpSocket = new Socket(ip, port);  // 소켓에 IP와 port를 넣어준다
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}
		return tcpSocket;
	}

	public static void main(String[] args) throws IOException {
		new UnicastClient("localhost", 3000);  // 서버의 IP와 포트값
	}
}