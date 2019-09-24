package Multi;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(5000);
		MultiServerThread mst = null;
		boolean isStop = false;
		
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();  // 서버소켓과 클라이언트소켓의 연결을 대기
			mst = new MultiServerThread(this);
			list.add(mst);  // 연결될때마다 MultiServerThread의 ArrayList에 추가
			Thread t = new Thread(mst);  // 스레드에 MultiServerThread 생성
			t.start();
		}
	}
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	public Socket getSocket()
	{
		return socket;
	}
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
}
