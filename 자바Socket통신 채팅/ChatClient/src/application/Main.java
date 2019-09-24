package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	public static ExecutorService threadPool;
	// 여러개의 쓰레드를 효율적으로 관리하기위해 사용하는 대표 라이브러리 쓰레드 숫자를 제한하기때문에 갑작스럽게 클라이언트 숫자가 폭증할때
	// 쓰레드숫자에 제한있기때문에 서버의 성능저하를 방지
	// 안정적으로
	public static Vector<Client> clients = new Vector<Client>();

	ServerSocket serverSocket;

	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드
	public void startServer(String IP, int port) 
	{
		try 
		{
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			if (!serverSocket.isClosed()) 
			{
				stopServer();
			}
			return;
		}

		// 클라이언트가 접속할 때까지 계속 기다리는 쓰레드입니다.
		Runnable thread = new Runnable() 
		{
			@Override
			public void run() 
			{
				while(true)
				{
					try
					{
						Socket socket = serverSocket.accept();
						clients.add(new Client(socket));
						System.out.println("[클라이언트 접속]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					}
					catch (Exception e)
					{
						if(!serverSocket.isClosed())
						{
							stopServer();
						}
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}

	// 서버의 작동을 중지시키는 메소드
	public void stopServer() 
	{
		try 
		{
			Iterator<Client> iterator = clients.iterator();
			while (iterator.hasNext()) 
			{
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if (serverSocket != null && !serverSocket.isClosed()) 
			{
				serverSocket.close();
			}
			if (threadPool != null && threadPool.isShutdown()) 
			{
				threadPool.shutdown();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	// UI 생성하고, 실질적으로 프로그램을 동작시키는 메소드
	@Override
	public void start(Stage primaryStage) 
	{
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("나눔고딕", 15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("시작하기");
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		root.setBottom(toggleButton);
		
		String IP = "172.22.226.153";
		int port = 9876;
		
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("시작하기"))
			{
				startServer(IP, port);
				Platform.runLater(() -> {
					String message = String.format("[서버 시작]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("종료하기");
				});
			}
			else
			{
				stopServer();
				Platform.runLater(() -> {
					String message = String.format("[서버 종료]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("시작하기");
				});
			}
		});
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[채팅 서버]");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	// 프로그램의 진입점입니다.
	public static void main(String[] args) 
	{
		launch(args);
	}
}