// 회원가입창, 회원정보수정창(수정, 탈퇴)

package health;


import java.awt.*; //awt import
import java.sql.*; //자바에서 데이터베이스를 사용하기 위한 절차에 대한 규약
import java.util.*; //java.util 패키지의 모든 클래스를 불러오는 것
import javax.swing.*; //java에서 gui를 구현하기 위해 jdk에서 기본적으로 제공하는 것
import javax.swing.table.DefaultTableModel; //DefaultTableModel 사용 => JTable 객체를 생성할 때 DefaultTableModel이라는 리모콘을 세팅해주는 ort javax.swing.text.JTextComponent; //JTextComponent 스윙 테스트 컴포너트의 기본클래스 입니다. / java.awt.TextComnent 합리적으로 할 수 있는 클래스와 호환되ㄷ
import javax.swing.text.JTextComponent;


import java.awt.event.*; //이벤트 구현은 생성자 구현부 마지막부에서 주로 위치시킨다.


public class MemberSignUp extends JFrame implements ActionListener{
	
	
	JPanel panel; //패널 panel

	JTextField id_t, name_t, HomeAddress_t, Age_t; //아이디, 이름, 집주소, 나이
	JTextField CurrentWeight_t, TargetWeight_t, height_t; //현재, 목표 몸무게, 키
	JTextField phone_1, phone_2, phone_3; //전화
	
	
	JComboBox period_t; //기간 
	
	JPasswordField password_t; //비밀번호 
	
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; //가입, 취소, 수정, 탈퇴 버튼

	
	//GridBagLayout은 GridLayout과 같이 컨테이너를 열과 행으로 나누어 컴포넌트들을 배치할 수 있다
	//각 영역은 서로 다른 크기로 지정될 수 있으며, 인접한 열 또는 행으로 확장이 가능합니다.
	GridBagLayout gb;
	GridBagConstraints gbc; //GridBagConstraints의 변수와 레이아웃이 관계가 있습니다.
	MainDisplay mList; //mList생성
	private JComboBox period_t_p; //리스트처럼 여러 항목 중에서 하나를 선택하는데 사용할 수 있습니다.
	
	//가입용 생성자
	public MemberSignUp() {
		createUI();//UI작성해주는 메소드
		btnUpdate.setEnabled(false); //버튼 객체 비활성
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		
	} //end of MemberSignUp
	
	
	
	//가입용 생성자
	public MemberSignUp(MainDisplay mList) { 
		createUI();//UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;
		
	} //end of MemberSignUp

	
	
	//수정 , 삭제용 생성자
	public MemberSignUp(String id, MainDisplay mList) { //파라미타 : id, mList
		
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;
		
		System.out.println("id=" + id); //id 출력 문
		
		DB_connection dao = new DB_connection();
		MemberInformation vMem = dao.getMemberDTO(id);
		viewData(vMem); 
		
	}//end of MemberSignUp, id를 가지고 생성됩니다.

	
	
	//MemberDTO(클래스)의 회원정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(MemberInformation vMem) {
		
		String id = vMem.getId();
		String pwd= vMem.getPwd();
		String name = vMem.getName();
		String homeAddress = vMem.getHomeAddress();
		String phone = vMem.getPhone();
		String age = vMem.getAge();
		String CurrentWeight = vMem.getCurrentWeight();
		String TargetWeight = vMem.getTargetWeight();
		String height = vMem.getHeight();
		String period = vMem.getPeriod();
		
		
		//화면에 세팅
		id_t.setText(id); //id
		id_t.setEditable(false);//편집 안되게
		
		password_t.setText(""); //비밀번호를 입력했을 시 보여지지 않도록 지정
		
		name_t.setText(name); //name
		
		HomeAddress_t.setText(homeAddress); //homeAddress
		
		String[] tels = phone.split("-"); //phone
		phone_1.setText(tels[0]); //배열 지정
		phone_2.setText(tels[1]);
		phone_3.setText(tels[2]);
		
		Age_t.setText(age); //age
		
		CurrentWeight_t.setText(CurrentWeight); //CurrentWeight
		
		TargetWeight_t.setText(TargetWeight); //TargetWeight
		
		height_t.setText(height); //height
		
		period_t_p.setSelectedItem(period); //period	
		
	}//end of viewData

	
	
	private void createUI() {
		
		setLocation(800,200);
		this.setTitle(" 회원 정보   ");
		gb = new GridBagLayout();
		getContentPane().setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		Toolkit toolkit = getToolkit();
		Image image = toolkit.createImage("./image/gym.png");
		setIconImage(image);
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		setIconImage(img); 
		
		//아이디
		JLabel bld = new JLabel("아이디 :");
		id_t = new JTextField(20);
		bld.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기 / 그리드백 레이아웃 : 여러 셀에 하나의 컴포넌트를 배치할 수 있다.
		gbAdd(bld,0,0,1,1);
		gbAdd(id_t,1,0,3,1);
		
		//비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		password_t = new JPasswordField(20);
		bPwd.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bPwd,0,1,1,1);
		gbAdd(password_t,1,1,3,1);
		
		//이름
		JLabel bName = new JLabel("이름 :");
		name_t= new JTextField(20);
		bName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bName,0,2,1,1);
		gbAdd(name_t,1,2,3,1);
		
		//주소
		JLabel bHomeAddress = new JLabel("주소: ");
		HomeAddress_t = new JTextField(20);
		bHomeAddress.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bHomeAddress,0,4,1,1);
		gbAdd(HomeAddress_t,1,4,3,1);
		
		//전화
		JLabel bPhone = new JLabel("전화 :");
		JPanel SignUpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		SignUpPanel.setLocation(500,100);
		phone_1 = new JTextField(6);
		phone_2 = new JTextField(6);
		phone_3 = new JTextField(6);
		SignUpPanel.add(phone_1);
		SignUpPanel.add(new JLabel("-"));
		SignUpPanel.add(phone_2);
		SignUpPanel.add(new JLabel("-"));
		SignUpPanel.add(phone_3);
		phone_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phone_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phone_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//그리드백에 붙이기
		gbAdd(bPhone,0,3,1,1);
		gbAdd(SignUpPanel,1,3,3,1);
		
		//나이
		JLabel bAge = new JLabel("나이: ");
		Age_t = new JTextField(20);
		bAge.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bAge,0,5,1,1);
		gbAdd(Age_t,1,5,3,1);
		
		//현재 몸무게
		JLabel bCurrentWeight = new JLabel("현재 몸무게: ");
		CurrentWeight_t = new JTextField(20);
		bCurrentWeight.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bCurrentWeight,0,6,1,1);
		gbAdd(CurrentWeight_t,1,6,3,1);
		
		//목표 몸무게
		JLabel bTargetWeight = new JLabel("목표 몸무게: ");
		TargetWeight_t = new JTextField(20);
		bTargetWeight.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//그리드백에 붙이기
		gbAdd(bTargetWeight,0,7,1,1);
		gbAdd(TargetWeight_t,1,7,3,1);
		
		//키
		JLabel bHeight = new JLabel("키: ");
		bHeight.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		height_t = new JTextField(20);
		//그리드백에 붙이기
		gbAdd(bHeight,0,8,1,1);
		gbAdd(height_t,1,8,3,1);
		
		//기간
		JLabel bperiod = new JLabel("기간 : ");
		String[] arrperiod = {"선택","3개월","4개월","5개월","6개월","7개월","8개월","9개월","10개월","11개월","12개월"};
		bperiod.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		period_t_p = new JComboBox(arrperiod);
		JPanel pperiod = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pperiod.add(period_t_p);
		//그리드백에 붙이기
		gbAdd(bperiod,0,9,1,1);
		gbAdd(pperiod,1,9,3,1);
		
		//버튼
		JPanel pButton = new JPanel();
		Font font;
		font = new Font("맑은 고딕", Font.BOLD, 17);
		btnInsert = new JButton("가입"); //가입 버튼 지정
		btnUpdate = new JButton("수정"); //수정 버튼 지정
		btnDelete = new JButton("탈퇴"); //탈퇴 버튼 지정
		btnCancel = new JButton("취소"); //취소 버튼 지정
		
		btnInsert.setBackground(new Color(151, 201, 210));
		btnUpdate.setBackground(new Color(102, 159, 175));
		btnDelete.setBackground(new Color(151, 201, 210));
		btnCancel.setBackground(new Color(102, 159, 175));
		
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		//그리드백에 붙이기
		gbAdd(pButton,0,10,4,1);
		
		//버튼에 감지기를 붙이기
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);
		
		setBackground(new Color(218, 226, 234));
		setSize(500,600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		
		
	}//end of createUl

	
	
	//그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2,2,2,2);
		getContentPane().add(c,gbc);
		
	}//end of gbAdd
	
	
	
	
	public static void main(String[] args) {
		
		new MemberSignUp(); //실행
	}
	
	
	
	
	//탈퇴
	@Override
	public void actionPerformed(ActionEvent ae) { //엑션
		this.setTitle(" 탈퇴 창  ");
		if(ae.getSource() == btnInsert) { //가입 button
			insertMember();  //insertMember 호출
			System.out.println("insertMember() 호출 종료");
			
		}else if(ae.getSource() == btnCancel) { //취소 button
			this.dispose(); //창닫기(현재창만 닫힘)
			
		}else if(ae.getSource() == btnUpdate) { //수정 button
			UpdateMember(); //UpdateMember 호출
			
		}else if(ae.getSource() == btnDelete) { //삭제 button
			int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
			
			
			if(x == JOptionPane.OK_OPTION) { //만약 OK라면
				deleteMember(); //deleteMember 호출 
				
			}else {
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다."); //삭제를 취소했을 때의 메세지 출력
			}
		}
		
		//jTable내용 갱신 메소드 호출
		mList.jTableRefresh();
	
	}//end of actionPerformed
	
	
	
	//삭제 기능
	private void deleteMember() {
	
		String id = id_t.getText();
		String pwd = password_t.getText();
		
		if(pwd.length()==0) { //패스워드 길이가 0이면
			
			JOptionPane.showMessageDialog(this, "비밀번호를 꼭 입력하세요!"); //비밀번호를 입력하는 메세지 출력
			return; //메소드 끝
		} 
		DB_connection dao = new DB_connection();
		boolean ok = dao.deleteMember(id, pwd);
		
		if(ok) {
			JOptionPane.showMessageDialog(this, "삭제완료"); //맞을 경우의 메세지 지정
			dispose();
		}else {
			JOptionPane.showMessageDialog(this, "삭제실패"); //아닐 경우의 메세지 지정
		}
		
	}//end of deleteMember
	
	
	
	
	private void UpdateMember() {
		this.setTitle(" 수정 창  ");
		//화면의 정보를 얻습니다
		MemberInformation dto = getViewData();
		//그 정보로 DB를 수정
		DB_connection dao = new DB_connection();
		
		boolean ok = dao.updateMember(dto);
		
		if(ok) {
			JOptionPane.showMessageDialog(this, "수정되었습니다!"); //맞을 경우의 메세지 지정
			this.dispose();
			
		}else {
			JOptionPane.showMessageDialog(this, "수정실패 : 다시 확인해주세요!"); //아닐 경우의 메세지 지정
		}
		
	} //end of insertMember
	
	
	private void insertMember() {
		
		//화면에서 사용자가 입력한 내용을 얻는다.
		MemberInformation dto = getViewData();
		
		DB_connection dao = new DB_connection();
		
		boolean ok = dao.insertMember(dto);
		

		if(ok) {
			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다."); //아닐 경우의 메세지 지정
			this.dispose();
			
		}else {
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다."); //맞을 경우 메세지 지정
		}
		
	}//end of insertMember

	
	private MemberInformation getViewData() {
		
		//화면에서 사용자가 입력한 내용을 얻는다.
		MemberInformation dto = new MemberInformation();
		String id = id_t.getText();  //아이디
		String pwd = password_t.getText();  //비밀번호
		String name = name_t.getText();  //이름
		String homeAddress = HomeAddress_t.getText(); //집 주소
		String Phone1 = phone_1.getText(); //전화번호 1
		String Phone2 = phone_2.getText(); //전화번호 2
		String Phone3 = phone_3.getText(); //전화번호 3
		String Phone = Phone1+"-"+Phone2+"-"+Phone3; //전화번호 형태 지정
		String age = Age_t.getText(); //나이
		String CurrentWeight = CurrentWeight_t.getText(); //현재 몸무게
		String TargetWeight = TargetWeight_t.getText(); //목표 몸무게
		String height = height_t.getText(); //키
		String period = (String)period_t_p.getSelectedItem(); //감량목표기간
		
		//dto에 담는다.
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setHomeAddress(homeAddress);
		dto.setPhone(Phone);
		dto.setAge(age);
		dto.setCurrentWeight(CurrentWeight);
		dto.setTargetWeight(TargetWeight);
		dto.setHeight(height);
		dto.setPeriod(period);
		
		return dto; //dto를 반환합니다.
		
	}//end of getViewDate
	
}//end of MemberSignIp