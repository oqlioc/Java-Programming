package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DoController implements Initializable{

	private Random random;					//������ �߻���Ű�� �ʵ�
	private ArrayList<CheckBox> al;			//üũ�ڽ��� ��ȣ�� ������ �ֱ� ���� ��̸���Ʈ�� �ִ´�. ������ �´� üũ�ڽ� ��ȣ�� ���� �̱�ߵ�

	int random_num;							//������ ���� �ʵ�
	public String name;						//�������� ���� ����� �̸��� �ٸ� Ŭ������ �Ѱ��ֱ� ���� ����
	private Checking2 ck;					//�ٸ� Ŭ���� �̸�
	public Label text;						//����� �ƹ��� �������� ���� �� ����ϱ� ���� ����
	
	@FXML private AnchorPane pane;			//������ ��� �����̳�
	@FXML private Button button2;			//���� â�� ���� ���� ��ư
	
	@FXML private CheckBox checkbox1;		//üũ�ڽ�1�� ���� 17������
	@FXML private CheckBox checkbox2;
	@FXML private CheckBox checkbox3;
	@FXML private CheckBox checkbox4;

	@FXML private CheckBox checkbox5;
	@FXML private CheckBox checkbox6;
	@FXML private CheckBox checkbox7;
	@FXML private CheckBox checkbox8;

	@FXML private CheckBox checkbox9;
	@FXML private CheckBox checkbox10;
	@FXML private CheckBox checkbox11;
	@FXML private CheckBox checkbox12;

	@FXML private CheckBox checkbox13;
	@FXML private CheckBox checkbox14;
	@FXML private CheckBox checkbox15;
	@FXML private CheckBox checkbox16;
	@FXML private CheckBox checkbox17;

	@Override//�����ڸ� ����ϴ� �ʱ�ȭ�Լ�
	public void initialize(URL location, ResourceBundle resources) { 
		// TODO Auto-generated method stub

		al = new ArrayList<>();
		
		//��̸���Ʈ 0������ üũ�ڽ��� �ϳ��� ������Ų��. ����Ʈ�� üũ�ڽ� üũ�س���
		al.add(0,checkbox1); al.get(0).setSelected(true);			
		al.add(1,checkbox2); al.get(1).setSelected(true);
		al.add(2,checkbox3); al.get(2).setSelected(true);
		al.add(3,checkbox4); al.get(3).setSelected(true);

		al.add(4,checkbox5); al.get(4).setSelected(true);
		al.add(5,checkbox6); al.get(5).setSelected(true);
		al.add(6,checkbox7); al.get(6).setSelected(true);
		al.add(7,checkbox8); al.get(7).setSelected(true);

		al.add(8,checkbox9); al.get(8).setSelected(true);
		al.add(9,checkbox10); al.get(9).setSelected(true);
		al.add(10,checkbox11); al.get(10).setSelected(true);
		al.add(11,checkbox12); al.get(11).setSelected(true);

		al.add(12,checkbox13); al.get(12).setSelected(true);
		al.add(13,checkbox14); al.get(13).setSelected(true); 
		al.add(14,checkbox15); al.get(14).setSelected(true);
		al.add(15,checkbox16); al.get(15).setSelected(true);
		al.add(16,checkbox17); al.get(16).setSelected(true);
	}

	public void handleButtonClicked() {

		random = new Random();
		random_num = random.nextInt(16); //16���� ���� �߻���Ű��

		//��� üũ�ڽ��� �������� ���
		while( ! al.get(random_num).isSelected())
		{
			if(! al.get(0).isSelected()
					&& ! al.get(1).isSelected()
					&& ! al.get(2).isSelected()
					&& ! al.get(3).isSelected()
					&& ! al.get(4).isSelected()

					&& ! al.get(5).isSelected()
					&& ! al.get(6).isSelected()
					&& ! al.get(7).isSelected()
					&& ! al.get(8).isSelected()

					&& ! al.get(9).isSelected()
					&& ! al.get(10).isSelected()
					&& ! al.get(11).isSelected()
					&& ! al.get(12).isSelected()

					&& ! al.get(13).isSelected()
					&& ! al.get(14).isSelected()
					&& ! al.get(15).isSelected()
					&& ! al.get(16).isSelected())


			{
				//����ó��
				text.setText("사람을 선택해 주세요");
				return;
			}
			
			//������ ���
			random_num = random.nextInt(16);
		}

		try {

			//SceneBuilder�� ����ϱ� ���ؼ� FXML�����Ű��
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checking2.fxml"));
			Parent secondView = (Parent) fxmlLoader.load();
			//����â �ҷ����� ���ؼ� �����Ű��
			ck = (Checking2)fxmlLoader.getController();
			//����â�� �߻��� ������ �´� ��̸���Ʈ �̸� �Ѱ��ֱ�
			ck.setName(al.get(random_num).getText());

			Scene scene = new Scene(secondView,600,400);
			Stage stage = new Stage(); 
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
