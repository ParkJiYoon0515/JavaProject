package health;

import java.awt.EventQueue; //�⺻ �Ǿ� Ŭ������ �ŷ��� �� �ִ� �������α׷� Ŭ���� ��ο��� �̺�Ʈ�� ����Ű�� �÷��� ������ Ŭ�����Դϴ�.

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton; 
import java.awt.Color; //�� ColorŬ������ �⺻ sRGB���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���˴ϴ� 
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class LogoChoice {
	//GUI��ҵ� ����
	private JFrame frame;
	private JTextField WeightField;
	private JTextField HeightField;
	private JTextField Weight_t;
	private JTextField Height_t;
	private JTextField Age_t;
	
	private JLabel BmiResult;
	private JLabel BmrResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogoChoice window = new LogoChoice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LogoChoice() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame(); //frame ����
		frame.setResizable(false); //frame�� ���̵��� ����
		frame.setBounds(470, 200, 1000, 600); //frame�� ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݵ��� ����
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
		frame.setTitle("ȸ������������ �ý���(Daily Health)"); //Ÿ��Ʋ ����
		//��Ŷ�� ����Ͽ� �̹��� �����
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png ������ �̹��� ���ϸ� ����
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel BmrPanel = new JPanel();
		BmrPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(BmrPanel);
		BmrPanel.setLayout(null);
		
		JRadioButton Man = new JRadioButton("\uB0A8\uC790");
		Man.setFont(new Font("���� ���", Font.BOLD, 20));
		Man.setBounds(159, 140, 77, 27);
		BmrPanel.add(Man);
		
		JRadioButton Woman = new JRadioButton("\uC5EC\uC790");
		Woman.setFont(new Font("���� ���", Font.BOLD, 20));
		Woman.setBounds(159, 171, 77, 27);
		BmrPanel.add(Woman);
		
		JLabel Gender = new JLabel("\uC131\uBCC4 : ");
		Gender.setFont(new Font("���� ���", Font.BOLD, 22));
		Gender.setBounds(61, 140, 69, 27);
		BmrPanel.add(Gender);
		
		JLabel Weight = new JLabel("\uCCB4\uC911 : ");
		Weight.setFont(new Font("���� ���", Font.BOLD, 22));
		Weight.setBounds(61, 236, 69, 27);
		BmrPanel.add(Weight);
		
		JLabel Height = new JLabel("\uD0A4(cm) : ");
		Height.setFont(new Font("���� ���", Font.BOLD, 22));
		Height.setBounds(61, 312, 91, 27);
		BmrPanel.add(Height);
		
		JLabel Age = new JLabel("\uB098\uC774 : ");
		Age.setFont(new Font("���� ���", Font.BOLD, 22));
		Age.setBounds(61, 381, 69, 27);
		BmrPanel.add(Age);
		
		Weight_t = new JTextField();
		Weight_t.setBounds(159, 236, 137, 29);
		BmrPanel.add(Weight_t);
		Weight_t.setColumns(10);
		
		Height_t = new JTextField();
		Height_t.setColumns(10);
		Height_t.setBounds(159, 312, 137, 29);
		BmrPanel.add(Height_t);
		
		Age_t = new JTextField();
		Age_t.setColumns(10);
		Age_t.setBounds(159, 381, 137, 29);
		BmrPanel.add(Age_t);
		
		JPanel ChoicePanel = new JPanel();
		ChoicePanel.setBackground(new Color(240, 237, 240));
		ChoicePanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(ChoicePanel);
		ChoicePanel.setLayout(null);
		
		JButton gotoMain_bmr = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmr.setBounds(863, 12, 105, 27);
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
		BmrPanel.add(gotoMain_bmr);
		gotoMain_bmr.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		JButton BmrButton = new JButton("\uACC4\uC0B0\uD558\uAE30");
		BmrButton.setFont(new Font("���� ���", Font.BOLD, 22));
		BmrButton.setBackground(new Color(102, 159, 175));
		BmrButton.setBounds(61, 463, 235, 55);
		BmrPanel.add(BmrButton);
		gotoMain_bmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoicePanel.setVisible(true);
				BmrPanel.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 25));
		lblNewLabel.setBounds(381, 220, 515, 69);
		BmrPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uAD6C\uD558\uAE30");
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 30));
		lblNewLabel_1.setBounds(61, 46, 259, 47);
		BmrPanel.add(lblNewLabel_1);
		
			gotoMain_bmr.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ChoicePanel.setVisible(true);
					BmrPanel.setVisible(false);
				}
			});
			
			BmrPanel.setVisible(false);
			BmrButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BmrPanel.setVisible(true);
					ChoicePanel.setVisible(false);
					BmrResult = new JLabel();
					//BmrResult.setVisible(false);
					BmrPanel.setVisible(true);
					int num;
					if(Man.isSelected()==true) { //������ ���õ� ��
						num = 1;//num = 1�̴�
					}else if(Woman.isSelected()==true) {//������ ���õ� ��
						num = 2;//num = 2�̴�
					}else {
						num = 0;
					}
					switch(num) {
					case 1 : //num�� 1�϶�
						double Weight_m = Double.parseDouble(Weight_t.getText());
						double Height_m = Double.parseDouble(Height_t.getText());
						int Age_m = Integer.parseInt(Age_t.getText());
						double Bmr_m = 66.47 + (13.75*Weight_m) + (5*Height_m) - (6.76*Age_m); //������ ���� ���ʴ�緮 ����
						BmrResult = new JLabel("                                  ���ʴ�緮�� " + Math.round(Bmr_m*100)/100.0 + "kcal�Դϴ�");
						BmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmrResult.setBounds(48, 261, 874, 43);
						BmrResult.setVisible(true);//���̺��� �̿��� ���ʴ�緮 ����� ������ش�
						break;//���۱׸�
					case 2 : //num�� 2�϶�
						double Weight_w = Double.parseDouble(Weight_t.getText());
						double Height_w = Double.parseDouble(Height_t.getText());
						int Age_w = Integer.parseInt(Age_t.getText());
						double Bmr_w = 655.1 + (9.56*Weight_w) + (1.85*Height_w) - (4.68*Age_w); //������ ���� ���ʴ�緮 ����
						BmrResult.setLocation(1300, 600);
						BmrResult = new JLabel("                                  ���ʴ�緮�� " + Math.round(Bmr_w*100)/100.0 + "kcal�Դϴ�");
						BmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("���� ���", Font.PLAIN, 27));
						BmrResult.setBounds(48, 261, 874, 43);
						BmrResult.setVisible(true); //���̺��� �̿��� ���ʴ�緮 ����� ������ش�
						break;//���۱׸�
					}
				}
			});
			JButton new_bmr = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
			new_bmr.setFont(new Font("���� ���", Font.PLAIN, 15));
			new_bmr.setBackground(new Color(218, 226, 234));
			new_bmr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BmrResult.setVisible(false);
				}
			});
			new_bmr.setBounds(863, 51, 105, 27);
			BmrPanel.add(new_bmr);
		
		JPanel BmiPanel = new JPanel();
		BmiPanel.setBounds(0, 0, 994, 565);
		frame.getContentPane().add(BmiPanel);
		BmiPanel.setVisible(false);
		BmiPanel.setLayout(null);
		
		JLabel WeightLabel = new JLabel("\uBAB8\uBB34\uAC8C : ");
		WeightLabel.setBounds(48, 109, 113, 34);
		WeightLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		BmiPanel.add(WeightLabel);
		
		WeightField = new JTextField();
		WeightField.setBounds(162, 109, 172, 35);
		BmiPanel.add(WeightField);
		WeightField.setColumns(10);
		
		JLabel lblkg = new JLabel("(kg\uB2E8\uC704)");
		lblkg.setBounds(337, 109, 104, 34);
		lblkg.setFont(new Font("���� ���", Font.BOLD, 25));
		BmiPanel.add(lblkg);
		
		JLabel HeightLabel = new JLabel("\uD0A4 : ");
		HeightLabel.setBounds(48, 158, 113, 34);
		HeightLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		BmiPanel.add(HeightLabel);
		
		HeightField = new JTextField();
		HeightField.setBounds(162, 158, 172, 35);
		HeightField.setColumns(10);
		BmiPanel.add(HeightField);
		
		JLabel lblcm = new JLabel("(cm\uB2E8\uC704)");
		lblcm.setBounds(337, 158, 104, 34);
		lblcm.setFont(new Font("���� ���", Font.BOLD, 25));
		BmiPanel.add(lblcm);
		
		JButton BmiButton = new JButton("BMI\uC9C0\uC218 \uACC4\uC0B0");
		BmiButton.setFont(new Font("���� ���", Font.BOLD, 18));
		BmiButton.setBackground(new Color(151, 201, 210));
		BmiButton.setBounds(468, 112, 166, 85);
		BmiPanel.add(BmiButton);
		BmiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double weight = Double.parseDouble(WeightField.getText()); //�Է¹��� �����Ը� ���� weight�� �־��ش�
				double height = Double.parseDouble(HeightField.getText()); //�Է¹��� Ű�� ���� height�� �־��ش�
				double var = weight/((height*(0.01))*(height*(0.01))); //Bmi������ ���ϴ� �����̴�
				if(0<var && var<18.5) { //���Ǽ�����
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ��ü���Դϴ�"); //���̺��� �̿��� ���
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);
				}else if(18.5<=var && var<23) {//���Ǽ�����
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ����ü���Դϴ�");//���̺��� �̿��� ���
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);				
				}else if(23<=var && var<25) {//���Ǽ�����
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , ��ü���Դϴ�");//���̺��� �̿��� ���
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else if(25<=var && var<30) { //���Ǽ�����
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �浵���Դϴ�");//���̺��� �̿��� ���
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else if(var<=30 && var<40) {//���Ǽ�����
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �����Դϴ�");//���̺��� �̿��� ���
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else {//���ǵ� �� �� �ÿ�
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , �ʰ����Դϴ�");
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("���� ���", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);	
				}//end of if~else if~else��
			}
		});
		
		JButton bmiImage = new JButton("");
		bmiImage.setBounds(139, 378, 742, 110);
		bmiImage.setIcon(new ImageIcon("./image/bmi.png")); //bmi������ ���� �񸸵��� �����ִ� ����
		BmiPanel.add(bmiImage);
		
		JButton gotoMain_bmi = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmi.setFont(new Font("���� ���", Font.PLAIN, 15));
		gotoMain_bmi.setBackground(new Color(218, 226, 234));
		gotoMain_bmi.setBounds(863, 12, 105, 27);
		BmiPanel.add(gotoMain_bmi);
		
		JLabel lblBmi = new JLabel("BMI\uC9C0\uC218 \uAD6C\uD558\uAE30");
		lblBmi.setFont(new Font("���� ���", Font.BOLD, 30));
		lblBmi.setBounds(48, 31, 239, 47);
		BmiPanel.add(lblBmi);
		
		JButton new_bmi = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
		new_bmi.setFont(new Font("���� ���", Font.PLAIN, 15));
		new_bmi.setBackground(new Color(218, 226, 234));
		new_bmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BmiResult.setVisible(false);
			}
		});
		new_bmi.setBackground(new Color(218, 226, 234));
		new_bmi.setBounds(863, 49, 105, 27);
		
				BmiPanel.add(new_bmi);
				gotoMain_bmi.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ChoicePanel.setVisible(true); //ChoicePanel�� ȭ�鿡 ������ �Ѵ�
						BmiPanel.setVisible(false);//BmiPanel�� ȭ�鿡 ������ �ʰ� �Ѵ�
					}
				});
		
		JButton MemberProfile = new JButton("");
		MemberProfile.setBounds(208, 180, 203, 202);
		ChoicePanel.add(MemberProfile);
		MemberProfile.setIcon(new ImageIcon("./image/button.jpg"));
		
		JButton btnBmi = new JButton("BMI \uC9C0\uC218 \uACC4\uC0B0");
		btnBmi.setBounds(442, 180, 327, 84);
		ChoicePanel.add(btnBmi);
		btnBmi.setBackground(new Color(151, 201, 210));
		btnBmi.setFont(new Font("���� ���", Font.BOLD, 25));
		
		JButton btnBmr = new JButton("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uACC4\uC0B0");
		btnBmr.setBackground(new Color(102, 159, 175));
		btnBmr.setFont(new Font("���� ���", Font.BOLD, 25));
		btnBmr.setBounds(442, 296, 327, 84);
		ChoicePanel.add(btnBmr);
		
		JLabel lblDailyHealth = new JLabel("Daily Health\uC5D0 \uC624\uC2E0 \uAC78 \uD658\uC601\uD569\uB2C8\uB2E4 \uD2B8\uB808\uC774\uB108\uB2D8");
		lblDailyHealth.setBounds(181, 85, 603, 47);
		ChoicePanel.add(lblDailyHealth);
		lblDailyHealth.setForeground(new Color(54, 82, 109));
		lblDailyHealth.setFont(new Font("���� ���", Font.BOLD, 28));
		
		
		//�������� ����� �� �� �ֵ���
		String wise  = "";
		for(int i=0; i<2; i++) { //�� �� ������ ������ �� ���� ����� �������� �������� �Ѵ�
			double num = Math.random(); //Math.random()�� �̿��� 0.0~1.0���� �� �������� �ƹ����ڳ� ������ �ؼ� num�� �ʱ�ȭ��Ų��
			if(0.0 <= num && num < 0.2) {
				wise = "���ϴ� ���� ����� ���� ������ ���� �μ���";
			}else if(0.2 <= num && num < 0.4){
				wise = "�¸��� ���� �����ִ� �ڿ��� ���ư���";
			}else if(0.4 <= num && num < 0.6) {
				wise = "��ǥ���� ���� �־����� ���� �������� ����������";
			}else if(0.6 <= num && num < 0.8) {
				wise = "������ �ٲ�� ���� ���ϱ� �����Ѵ�";
			}else {
				wise = "�м��� �ϼ��� ����";
			}
		}//end of for��
		
		JLabel goodwords = new JLabel(wise); //guiâ�� label�� ������ ����Ѵ�
		wise = null; // wise�� null�� �Ҵ��ؼ� ���� �����
		goodwords.setHorizontalAlignment(SwingConstants.CENTER);
		goodwords.setFont(new Font("���� ���", Font.PLAIN, 20));
		goodwords.setBounds(181, 437, 603, 47);
		ChoicePanel.add(goodwords);
		
		btnBmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BmrPanel.setVisible(true); //BmrPanel�� ȭ�鿡 ������ �ʰ� ��
				ChoicePanel.setVisible(false); //ChoicePanel�� ȭ�鿡 ���̰� ��
			}
		});
		
		
		btnBmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BmiPanel.setVisible(true); //BmiPanel�� ȭ�鿡 ���̰� ��
				ChoicePanel.setVisible(false);//ChoicePanel�� ȭ�鿡 ������ �ʰ� ��
			}
		});
		
		MemberProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false); //�� Ŭ������ frame�� �ݾ��ش�
				new MainDisplay(); //MainDisplayŬ������ �����Ѵ�
			}
		});
		ButtonGroup gender = new ButtonGroup();
		BmrResult = new JLabel();
		BmrResult.setVisible(false);
	}//end of initialize
}//end of LogoChoice