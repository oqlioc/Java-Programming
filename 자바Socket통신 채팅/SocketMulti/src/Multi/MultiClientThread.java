package Multi;

public class MultiClientThread extends Thread{
    private MultiClient mc;
    public MultiClientThread(MultiClient mc){
        this.mc = mc;
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                receivedMsg = message.split("#");  // #을 기준으로 분할해서 넣는다, 아이디와 메세지 분할 그리고 receivedMsg 배열에 넣는다
            }catch(Exception e){
                e.printStackTrace();
                isStop = true;
            }
            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            if(receivedMsg[1].equals("exit")){  // 메세지가 exit이면
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();
                }else{
                    mc.getJta().append(
                    receivedMsg[0] +"님이 종료 하셨습니다."+
                    System.getProperty("line.separator"));
                    mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                }
            }else{               
                mc.getJta().append(
                receivedMsg[0] +" : "+receivedMsg[1]+
                System.getProperty("line.separator"));
                mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                
            }
        }
    }
}