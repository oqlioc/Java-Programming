package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Checking2 implements Initializable{


	@FXML
	private  Label text;					//�̸� ��� ����
	@FXML
	private MediaView media;				//������ ��� ����
	private MediaPlayer mediaPlayer;		//������ ��� ��
	public static final String MEDIA_URL = "cwww.mp4"; //������ ��ġ���
	Timer timer;							//�̸��� ���߿� ���̱� ���� Ÿ�̸�
	FadeTransition ft;	
	FadeTransition ft2;					//���̵�� õõ�� �̸� �����Ű ���� ����
	@FXML
	private ImageView iv;
	
	//�����ڸ� ����ϴ� �ʱ�ȭ �Լ�
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		//�̵��信 �̵�� ���
		mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
		media.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		
	}

	public void setName(String name) {
		
		//�̸��� ���߿� ���̱� ���� Ÿ�̸�
		timer = new Timer();
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				
				iv.setVisible(true);	
				text.setVisible(true);								//64���� ���Ŀ� ����� ��, ���ܵξ��� �̸� �����ְ� �ϱ� 
				ft = new FadeTransition(Duration.millis(500),text);	//0.5�ʿ� ���� �̸� õõ�� �����ֱ�
				ft2 = new FadeTransition(Duration.millis(500),iv);
				ft.setFromValue(0);									//���� 0����
				ft.setToValue(100);									//����100����
				ft.play();			
				
				ft2.setFromValue(0);
				ft2.setToValue(100);
				ft2.play();
											
				mediaPlayer.pause();								//������ ����
			}

		};
		text.setText(name);
		timer.schedule(task, 8700);		//8.7�� ���Ŀ� �̸� �����Ű��

	}
}
