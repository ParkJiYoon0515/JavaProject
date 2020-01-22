// 메인창 : 회원리스트 출력
package health;

import java.awt.BorderLayout; // 동서남북(상하좌우)과 가운데를 배치할 수 있으며, 기본값입니다.
import java.awt.Color; //이 Color클래스는 기본 sRGB색상 공간에서 색상을 캡슐화하거나으로 식별되는 임의 색상 공간의 색상을 캡슐화하는 데 사용됩니다 
import java.awt.Component; // Abstract Window Toolkit 구성요소의 추상 수퍼 클래스, 가벼운 구성요소를 만들기 위해 클래스를 직접 확장할 수도 있습니다. 
import java.awt.Font; //자바에서 입력한 글자에 효과를 줄 때 Font 클래스를 활용한다.
import java.awt.Image; //자바에서 이미지는 java.awt.Image 클래스의 객체로 표현
import java.awt.Toolkit; //툴킷은 java.awt.Toolkit 클래스로 제작 가능 / 프레임을 만들면 자동으로 생성
import java.awt.event.*; //이벤트 구현은 생성자 구현부 마지막부에서 주로 위치시킨다.
import java.util.*; //java.util 패키지의 모든 클래스를 불러오는 것
import javax.swing.*; //java에서 gui를 구현하기 위해 jdk에서 기본적으로 제공하는 것
import javax.swing.table.DefaultTableModel;  //DefaultTableModel 사용 => JTable 객체를 생성할 때 DefaultTableModel이라는 리모콘을 세팅해주는 것과 같음
import java.awt.FlowLayout; //Button 만들기의 연장선으로 FlowLayout클래스를 사용하고 있다. 여러 개의 버튼을 만들고 순서대로 배치하는 클래스이다.

public class MainDisplay extends JFrame implements MouseListener,ActionListener{
		
	Vector v; //Vector => 동적인 길이로 여러 데이터형을 저장하기 위해 Vector 클래스를 제공한다.
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane s_pane ;
	JPanel pbtn;
	JButton btnInsert;
	private JButton btnNewButton;
	
	//생성자 메소드
	public MainDisplay() { 
		super("회원 등록"); //회원정보 메인페이지 제목
		//DAO : 데이터 베이스에 접속해서 데이터 추가, 삭제, 수정 등의 작업을 하는 클래스
	    //클래스 DB_connection을 이용해 데이터 베이스에 접근할 객체 생성
		DB_connection dao = new DB_connection();
		v = dao.getMemberList();  //dao.getMemberList() => 회원정보를 가져오는 메서드
		System.out.println("v= " + v); //회원 정보 출력
		cols = getColumn(); //getColumn() => 값을 가져옴
		 
		
		//DefaultTableModel 사용 => 테이블에 행단위로 쓰거나 삭제가 용이함, JTable 객체를 생성할 때 DefaultTableModel이라는 리모콘을 세팅해주는 것과 같음
		//데이터 입출력 DefaultTableModel을 통해서 사용할 수 있음
		//DefaultTableModel 객체를 생성하면서 데이터를 담습니다. / JTable에 직접 넣었던 데이터를 리모콘에 담은 것 
		model = new DefaultTableModel(v, cols); //v = 회원 정보 , cols = (회원정보)값
		
		
		//Frame의 구성요소인 ContentPane의 setting을 위하여 JFrame클래스의 객체 메소드인 getContentPane()을 호출
		//절대경로 레이아웃 setLayout(null);을 사용하였습니다.
		getContentPane().setLayout(null);
		
		
		
		//리모콘을 생성한 후 JTable을 생성할 때 이 리모콘을 담아서 생성하기
		jTable = new JTable(model); // 즉 JTabe 객체를 생성할 때 DefaultTableModel이라는 리모콘을 사용하겠다는 의미
		jTable.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		s_pane = new JScrollPane(jTable); //스크롤 페인으로 컴포넌트에 스크롤 기능을 제공함 = > 회원 정보의 메인페이지에 스크롤 기능 제공
		s_pane.setBounds(0, 0, 994, 501);  //스크롤 크기 지정
		s_pane.setBackground(new Color(218, 226, 234));
		getContentPane().add(s_pane); //테이블에 추가된 컴포넌트
		
		
		
		pbtn = new JPanel(); //JPanel : 보조 프레임(조각난 프레임), 'pbtn'이름으로 JPanel 객체 생성
		pbtn.setBounds(0, 508, 982, 45); //프레임 크기 지정
		pbtn.setLayout(null);
		btnInsert = new JButton("\uD68C\uC6D0\uAC00\uC785"); //'butInsert'이름으로 JButton 객체 생성(button) , "\uD68C\uC6D0\uAC00\uC785" => 회원가입
		btnInsert.setBounds(422, -1, 138, 46);
		btnInsert.setBackground(new Color(151, 201, 210)); //btnInsert의 버튼 Background 색상 지정
		pbtn.add(btnInsert); //pbtn이라는 패널에 btnInsert 버튼을 추가한다
		getContentPane().add(pbtn); //패널에 추가된 컴포넌트
		
		
		//이벤트 리스너 추가 : 이벤트가 발생했을 때 그 처리를 담당하는 함수를 가리킴 (MouseListener, ActionListener)
		//this = 자기자신
		jTable.addMouseListener(this); //jTable에 마우스리스너 등록
		btnInsert.addActionListener(this); //btnInsert(회원가입버튼)에 리스너 등록

		
		
		
		setSize(1000, 600); //main 창 크기 지정
		setVisible(true); //main 창 보이도록 지정
		setResizable(false);
		//X버튼 눌렀을 때 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBackground(new java.awt.Color(218, 226, 234)); //'회원가입'의 버튼 색상 지정 
		setLocation(470, 200); //'회원가입'의 버튼 크기 조정
		Image img_1 = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		setIconImage(img_1);
		

		
		jTable.setFont(new Font("맑은고딕", Font.PLAIN, 17)); //JTable의 폰트 설정
		s_pane.setFont(new Font("맑은고딕", Font.PLAIN, 17)); //s_pane의 폰트 설정
		pbtn.setFont(new Font("맑은고딕", Font.PLAIN, 22));  //pbtn의 폰트 설정
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 20)); //btnInsert의 폰트 설정
		
		
		btnNewButton = new JButton("\uBA54\uC778\uD654\uBA74");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnNewButton.setBounds(877, 4, 105, 35);
		btnNewButton.setBackground(new Color(218, 226, 234));
		pbtn.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new LogoChoice();
			}
		});
		
		
		
		
		jTable.setRowHeight(25); //행 높이 조절
		jTable.setBackground(new java.awt.Color(255, 240, 245)); //표 background 색 지정
		
		
	}//end of MainDisplay(and 생성자)
	
	
	
	//JTable의 컬럼  // 컬럼 : 관계형 데이터베이스 테이블에서 특정한 단순 자료형의 일련의 데이터 값과 테이블에서의 각 열을 말한다.
	//자바에서는 동적인 길이로 여러 데이터형을 저장하기 위해 Vector 클래스를 제공한다. 따라서 Vactor 클래스는 가변 길이의 배열이라고 할 수 있다.
	public Vector getColumn() { //표의 행 부분 데이터 표시
			Vector col = new Vector(); //'col'이름으로 Vector 객체 생성
			col.add("아이디"); //id
			col.add("비밀번호"); //pwd 
			col.add("이름"); //name
			col.add("주소"); //homeAddress
			col.add("전화번호"); //phone
			col.add("나이"); //age
			col.add("현재 몸무게"); //CurrentWeight
			col.add("목표 몸무게"); //TargetWeight
			col.add("키"); //height
			col.add("기간"); //period
			
		
			return col; //col 반환
		
		
	}//end of getColumn

	
	//table 내용 갱신 메서드
	public void jTableRefresh() {
		
			//DAO(DATA access object, DB로 접근해서 로직을 수행) : 데이터 추가, 삭제, 수정 등의 작업을 하는 메소드 
			DB_connection dao = new DB_connection(); //'dao'이름으로 DAO 객체 생성 (데이터 추가, 삭제, 수정 작업)
			DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());  //dao.getMemberList(), getColumn() 데이터를 담고 'model'이름의 객체 생성
			jTable.setModel(model); //JTable의 setModel 메소드를 이용하여 데이터('model'데이터) 넣기
				
		}//end of jTableRefresh
			
		
	public static void main(String[] args) {
		new MainDisplay(); //Member-List 클래스 실행
	}//end of main


	//이벤트(Event) 기본  => 마우스 리스너 구현
	@Override
	public void mouseClicked(MouseEvent e) { //마우스가 해당 컴포넌트를 클릭했을 때
		//mouseClicked만 사용
		int r = jTable.getSelectedRow(); //getSelectedRow() => "getSelectedRow()"메소드로 선택된 셀이 있는지 검사
		String id = (String)jTable.getValueAt(r, 0); //getValueAt() 메소드는 원하는 위치의 데이터를 가져오는 메소드 / jTable에서 선택한 값 가져오기
		MemberSignUp mem = new MemberSignUp(id,this); //아이디를 인자로 수정창 생성
		
	}//end of mouseClicked

	
	
	
	//MouseListener 인터페이스의 나머지 4개 메소드도 모두 구현을 하여야 실행이 됨
	@Override
	public void mouseEntered(MouseEvent e) { //마우스가 해당 컴포넌트 영역 안으로 들어올 때 발생
		
	}
	@Override
	public void mouseExited(MouseEvent e) { //마우스가 해당 컴포넌트 영역 밖으로 나갈 때 발생
		
	}
	@Override
	public void mousePressed(MouseEvent e) { //마우스 버튼을 누를 때 발생
		
	}
	@Override
	public void mouseReleased(MouseEvent e) { //눌러진 마우스를 놓을 때 발생
		
	}
	
	
	
	
	//버튼 클릭 시에 발동 되는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 클릭하면
		if(e.getSource() == btnInsert) {
			new MemberSignUp(this);  //새로운 수정창을 생성한다.
		}
	}//end of actionPerformed
	
}//end of MainDisplay