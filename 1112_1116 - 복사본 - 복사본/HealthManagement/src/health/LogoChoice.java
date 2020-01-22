package health;

import java.awt.EventQueue; //기본 피어 클래스와 신뢰할 수 있는 응용프로그램 클래스 모두에서 이벤트를 대기시키는 플랫폼 독립적 클래스입니다.

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton; 
import java.awt.Color; //이 Color클래스는 기본 sRGB색상 공간에서 색상을 캡슐화하거나으로 식별되는 임의 색상 공간의 색상을 캡슐화하는 데 사용됩니다 
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
	//GUI요소들 선언
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
		frame = new JFrame(); //frame 생성
		frame.setResizable(false); //frame이 보이도록 설정
		frame.setBounds(470, 200, 1000, 600); //frame의 크기 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫도록 지정
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setTitle("회원정보관리용 시스템(Daily Health)"); //타이틀 설정
		//툴킷을 사용하여 이미지 만들기
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png 형식의 이미지 파일만 지원
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel BmrPanel = new JPanel();
		BmrPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(BmrPanel);
		BmrPanel.setLayout(null);
		
		JRadioButton Man = new JRadioButton("\uB0A8\uC790");
		Man.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Man.setBounds(159, 140, 77, 27);
		BmrPanel.add(Man);
		
		JRadioButton Woman = new JRadioButton("\uC5EC\uC790");
		Woman.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Woman.setBounds(159, 171, 77, 27);
		BmrPanel.add(Woman);
		
		JLabel Gender = new JLabel("\uC131\uBCC4 : ");
		Gender.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Gender.setBounds(61, 140, 69, 27);
		BmrPanel.add(Gender);
		
		JLabel Weight = new JLabel("\uCCB4\uC911 : ");
		Weight.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Weight.setBounds(61, 236, 69, 27);
		BmrPanel.add(Weight);
		
		JLabel Height = new JLabel("\uD0A4(cm) : ");
		Height.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Height.setBounds(61, 312, 91, 27);
		BmrPanel.add(Height);
		
		JLabel Age = new JLabel("\uB098\uC774 : ");
		Age.setFont(new Font("맑은 고딕", Font.BOLD, 22));
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
		gotoMain_bmr.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JButton BmrButton = new JButton("\uACC4\uC0B0\uD558\uAE30");
		BmrButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
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
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel.setBounds(381, 220, 515, 69);
		BmrPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uAD6C\uD558\uAE30");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
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
					if(Man.isSelected()==true) { //남성이 선택될 때
						num = 1;//num = 1이다
					}else if(Woman.isSelected()==true) {//여성이 선택될 때
						num = 2;//num = 2이다
					}else {
						num = 0;
					}
					switch(num) {
					case 1 : //num이 1일때
						double Weight_m = Double.parseDouble(Weight_t.getText());
						double Height_m = Double.parseDouble(Height_t.getText());
						int Age_m = Integer.parseInt(Age_t.getText());
						double Bmr_m = 66.47 + (13.75*Weight_m) + (5*Height_m) - (6.76*Age_m); //남성일 때의 기초대사량 공식
						BmrResult = new JLabel("                                  기초대사량은 " + Math.round(Bmr_m*100)/100.0 + "kcal입니다");
						BmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmrResult.setBounds(48, 261, 874, 43);
						BmrResult.setVisible(true);//레이블을 이용해 기초대사량 계산결과 출력해준다
						break;//동작그만
					case 2 : //num이 2일때
						double Weight_w = Double.parseDouble(Weight_t.getText());
						double Height_w = Double.parseDouble(Height_t.getText());
						int Age_w = Integer.parseInt(Age_t.getText());
						double Bmr_w = 655.1 + (9.56*Weight_w) + (1.85*Height_w) - (4.68*Age_w); //여성일 때의 기초대사량 공식
						BmrResult.setLocation(1300, 600);
						BmrResult = new JLabel("                                  기초대사량은 " + Math.round(Bmr_w*100)/100.0 + "kcal입니다");
						BmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmrResult.setBounds(48, 261, 874, 43);
						BmrResult.setVisible(true); //레이블을 이용해 기초대사량 계산결과 출력해준다
						break;//동작그만
					}
				}
			});
			JButton new_bmr = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
			new_bmr.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
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
		WeightLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		BmiPanel.add(WeightLabel);
		
		WeightField = new JTextField();
		WeightField.setBounds(162, 109, 172, 35);
		BmiPanel.add(WeightField);
		WeightField.setColumns(10);
		
		JLabel lblkg = new JLabel("(kg\uB2E8\uC704)");
		lblkg.setBounds(337, 109, 104, 34);
		lblkg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		BmiPanel.add(lblkg);
		
		JLabel HeightLabel = new JLabel("\uD0A4 : ");
		HeightLabel.setBounds(48, 158, 113, 34);
		HeightLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		BmiPanel.add(HeightLabel);
		
		HeightField = new JTextField();
		HeightField.setBounds(162, 158, 172, 35);
		HeightField.setColumns(10);
		BmiPanel.add(HeightField);
		
		JLabel lblcm = new JLabel("(cm\uB2E8\uC704)");
		lblcm.setBounds(337, 158, 104, 34);
		lblcm.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		BmiPanel.add(lblcm);
		
		JButton BmiButton = new JButton("BMI\uC9C0\uC218 \uACC4\uC0B0");
		BmiButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		BmiButton.setBackground(new Color(151, 201, 210));
		BmiButton.setBounds(468, 112, 166, 85);
		BmiPanel.add(BmiButton);
		BmiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double weight = Double.parseDouble(WeightField.getText()); //입력받은 몸무게를 변수 weight에 넣어준다
				double height = Double.parseDouble(HeightField.getText()); //입력받은 키를 변수 height에 넣어준다
				double var = weight/((height*(0.01))*(height*(0.01))); //Bmi지수를 구하는 공식이다
				if(0<var && var<18.5) { //조건성립시
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 저체중입니다"); //레이블을 이용해 출력
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);
				}else if(18.5<=var && var<23) {//조건성립시
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 정상체중입니다");//레이블을 이용해 출력
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);				
				}else if(23<=var && var<25) {//조건성립시
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 과체중입니다");//레이블을 이용해 출력
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else if(25<=var && var<30) { //조건성립시
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 경도비만입니다");//레이블을 이용해 출력
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else if(var<=30 && var<40) {//조건성립시
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 고도비만입니다");//레이블을 이용해 출력
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);		
				}else {//조건들 외 일 시에
					BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 초고도비만입니다");
					BmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);	
				}//end of if~else if~else문
			}
		});
		
		JButton bmiImage = new JButton("");
		bmiImage.setBounds(139, 378, 742, 110);
		bmiImage.setIcon(new ImageIcon("./image/bmi.png")); //bmi지수에 따른 비만도를 보여주는 사진
		BmiPanel.add(bmiImage);
		
		JButton gotoMain_bmi = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmi.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		gotoMain_bmi.setBackground(new Color(218, 226, 234));
		gotoMain_bmi.setBounds(863, 12, 105, 27);
		BmiPanel.add(gotoMain_bmi);
		
		JLabel lblBmi = new JLabel("BMI\uC9C0\uC218 \uAD6C\uD558\uAE30");
		lblBmi.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblBmi.setBounds(48, 31, 239, 47);
		BmiPanel.add(lblBmi);
		
		JButton new_bmi = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
		new_bmi.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
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
						ChoicePanel.setVisible(true); //ChoicePanel가 화면에 나오게 한다
						BmiPanel.setVisible(false);//BmiPanel이 화면에 나오지 않게 한다
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
		btnBmi.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		JButton btnBmr = new JButton("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uACC4\uC0B0");
		btnBmr.setBackground(new Color(102, 159, 175));
		btnBmr.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnBmr.setBounds(442, 296, 327, 84);
		ChoicePanel.add(btnBmr);
		
		JLabel lblDailyHealth = new JLabel("Daily Health\uC5D0 \uC624\uC2E0 \uAC78 \uD658\uC601\uD569\uB2C8\uB2E4 \uD2B8\uB808\uC774\uB108\uB2D8");
		lblDailyHealth.setBounds(181, 85, 603, 47);
		ChoicePanel.add(lblDailyHealth);
		lblDailyHealth.setForeground(new Color(54, 82, 109));
		lblDailyHealth.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		
		
		//랜덤으로 명언이 뜰 수 있도록
		String wise  = "";
		for(int i=0; i<2; i++) { //한 번 실행할 때마다 한 개의 명언이 랜덤으로 나오도록 한다
			double num = Math.random(); //Math.random()을 이용해 0.0~1.0까지 중 랜덤으로 아무숫자나 나오게 해서 num에 초기화시킨다
			if(0.0 <= num && num < 0.2) {
				wise = "원하는 몸을 만들기 위해 지금의 몸을 부수자";
			}else if(0.2 <= num && num < 0.4){
				wise = "승리는 가장 끈기있는 자에게 돌아간다";
			}else if(0.4 <= num && num < 0.6) {
				wise = "목표까지 아직 멀었을지 몰라도 어제보다 가까워졌어요";
			}else if(0.6 <= num && num < 0.8) {
				wise = "생각이 바뀌면 몸도 변하기 시작한다";
			}else {
				wise = "패션의 완성은 몸매";
			}
		}//end of for문
		
		JLabel goodwords = new JLabel(wise); //gui창에 label로 문구를 출력한다
		wise = null; // wise에 null을 할당해서 값을 지운다
		goodwords.setHorizontalAlignment(SwingConstants.CENTER);
		goodwords.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		goodwords.setBounds(181, 437, 603, 47);
		ChoicePanel.add(goodwords);
		
		btnBmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BmrPanel.setVisible(true); //BmrPanel이 화면에 보이지 않게 함
				ChoicePanel.setVisible(false); //ChoicePanel이 화면에 보이게 함
			}
		});
		
		
		btnBmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BmiPanel.setVisible(true); //BmiPanel이 화면에 보이게 함
				ChoicePanel.setVisible(false);//ChoicePanel이 화면에 보이지 않게 함
			}
		});
		
		MemberProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false); //이 클래스의 frame을 닫아준다
				new MainDisplay(); //MainDisplay클래스를 실행한다
			}
		});
		ButtonGroup gender = new ButtonGroup();
		BmrResult = new JLabel();
		BmrResult.setVisible(false);
	}//end of initialize
}//end of LogoChoice