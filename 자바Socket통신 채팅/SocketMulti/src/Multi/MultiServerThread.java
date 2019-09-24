package Multi;

import java.net.*;
import java.io.*;
public class MultiServerThread implements Runnable{
    private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public MultiServerThread(MultiServer ms){
        this.ms = ms;
    }
    public synchronized void run(){
        boolean isStop = false;
        try{
            socket = ms.getSocket();
            ois = new ObjectInputStream(socket.getInputStream());  // 클라이언트 사용자가 서버에 보내주는 채팅내용을 입력 받는 입력스트림 객체
            oos = new ObjectOutputStream(socket.getOutputStream());  // 서버에서 클라이언트 사용자에게 채팅내용을 보내는 출력스트림 객체
            String message = null;  // 초기화
            while(!isStop){
                message = (String)ois.readObject();  // message에 입력  입력받은 객체를 넣는다
                String[] str = message.split("#");  // str배열에 #을 기준으로 분할해서 넣는다
                if(str[1].equals("exit")){
                    broadCasting(message);
                    isStop = true;
                }else{
                    broadCasting(message);  // 
                }
            }
            ms.getList().remove(this);  // while문이 끝나고 서버스레드종료하고 클라이언트 연결끊음
            System.out.println(socket.getInetAddress()+
                    "정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
            ms.getList().remove(this);  // 예외가 생겼을때 서버스레드객체지움
            System.out.println(socket.getInetAddress()+
                    "비정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }
    }
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);  // 데이터 다시 직렬화함 ( 다시 보내줄 준비 )
    }
}
