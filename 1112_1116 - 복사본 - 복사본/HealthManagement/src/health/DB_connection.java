// 데이터베이스에 접근하는 객체
package health;	//패키지는 health이다

import java.sql.*; //JDBC를 사용하기 위해 import해준다
import java.util.Vector; //vector는 동적배열자료구조로 동기화보장이 되어있어서 안전함니다

import javax.swing.table.DefaultTableModel; 
//table을 생성한다 DefaultTableModel을 사용해줌으로서 테이블의 데이터를 변경할 수 있다. 

public class DB_connection { //mysql 데이터베이스와 연동위해 준비
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버 
	private static final String URL = "jdbc:mysql://localhost/management?serverTimezone=UTC"; //나의 데이터베이스 주소
	
	private static final String USER = "root"; //데이터 베이스 아이디(root=>최상위)
	private static final String PASS = "goflvhxj03"; //데이터 베이스 비밀번호
	MainDisplay mList; //mList생성
	
	public DB_connection() { //매개변수가 없는 DB_connection생성자메서드
		
	}//end of DB_connection
	
	public DB_connection(MainDisplay mList) { //매개변수가 있는 DB_connection생성자메서드
		this.mList = mList; //
		System.out.println("DAO =" + mList); //확인차 출력
	} //end of DB_connection(매개변수)
	
	public Connection getConn() { //데이터 베이스와 연동하는 클래스
		Connection con = null; //connection선언하고 null할당
		try {
			Class.forName(DRIVER); //드라이버를 로딩시킨다
			con = DriverManager.getConnection(URL, "root", "goflvhxj03"); //주소, 아이디, 비밀번호를 이용해 드라이버 연결
		}catch (Exception e) {
			e.printStackTrace(); //오류출력
		}
		return con; //con(connection)값 return
	}//end of getConn

	public MemberInformation getMemberDTO(String id) {
		
		MemberInformation dto = new MemberInformation(); //dto객체 생성
		
		Connection con = null;   //con에 unll할당
		PreparedStatement ps = null;  //ps에 unll할당
		ResultSet rs = null; //rs에 unll할당
		
		try {
			con = getConn();
			String sql = "select * from jiyoon where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery(); //수행결과로 rs객체의 값을 반환한다
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setHomeAddress(rs.getString("homeAddress"));
				dto.setPhone(rs.getString("phone"));
				dto.setAge(rs.getString("age"));
				dto.setCurrentWeight(rs.getString("CurrentWeight"));
				dto.setTargetWeight(rs.getString("TargetWeight"));
				dto.setHeight(rs.getString("height"));
				dto.setPeriod(rs.getString("period"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto; //dto return해준다
	}

	public Vector getMemberList() {
		Vector data = new Vector(); //data vector생성
		
		Connection con = null; //con에 null할당
		PreparedStatement ps = null; //ps에 null할당
		ResultSet rs = null; //rs에 null할당
		
		try {
			con = getConn(); //DB연결 위한 컴포넌트 작성 
			String sql = "select * from jiyoon order by name asc"; //select쿼리값 가려오게함
			ps = con.prepareStatement(sql); //
			rs = ps.executeQuery(); //
			
			while(rs.next()) { //
			String id = rs.getString("id"); //id는 입력받은 id이다
			String pwd = rs.getString("pwd"); //pwd는 입력받은 pwd이다
			String name = rs.getString("name"); //id는 입력받은 id이다
			String homeAddress = rs.getString("homeAddress"); //id는 입력받은 id이다
			String phone = rs.getString("phone"); //id는 입력받은 id이다
			String age = rs.getString("age"); //id는 입력받은 id이다
			String CurrentWeight = rs.getString("CurrentWeight"); //id는 입력받은 id이다
			String TargetWeight = rs.getString("TargetWeight"); //id는 입력받은 id이다
			String height = rs.getString("height"); //id는 입력받은 id이다
			String period = rs.getString("period"); //id는 입력받은 id이다
			
			Vector row = new Vector(); //select쿼리값 가려오게함
			row.add(id); 	//table에 id추가
			row.add(pwd);	//table에 비밀번호추가
			row.add(name);	//table에 이름추가
			row.add(homeAddress);	//table에 집주소추가
			row.add(phone);	//table에 전화번호추가
			row.add(age);	//table에 나이추가
			row.add(CurrentWeight);	//table에 현재 몸무게추가
			row.add(TargetWeight);	//table에 목표 몸무게추가
			row.add(height);//table에 키추가
			row.add(period);//table에 목표달성기간추가
			data.add(row);
		   }
		}catch(Exception e) {
			e.printStackTrace(); //오류 출력
		}
		return data; //data를 리턴값으로 줌
	}

	public boolean insertMember(MemberInformation dto) {
		
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			String sql = "insert into jiyoon(" +
						"id,pwd,name,homeAddress,phone,age,"+
						"CurrentWeight,TargetWeight,height,period)"+
						"values(?,?,?,?,?,?,?,?,?,?)"; //8개의 데이터 입력위해 8개의 물음표 필요
			
			ps = con.prepareStatement(sql); //버터스러운..?
			ps.setString(1, dto.getId()); //set메서드에 id저장
			ps.setString(2, dto.getPwd());//set메서드에 password저장
			ps.setString(3, dto.getName());//set메서드에 name저장
			ps.setString(4, dto.getHomeAddress());//set메서드에 homeAddress저장
			ps.setString(5, dto.getPhone());//set메서드에 phone저장
			ps.setString(6, dto.getAge());//set메서드에 age저장
			ps.setString(7, dto.getCurrentWeight());//set메서드에 currentWeight저장
			ps.setString(8, dto.getTargetWeight());//set메서드에 targetWeight저장
			ps.setString(9, dto.getHeight());//set메서드에 height저장
			ps.setString(10, dto.getPeriod());//set메서드에 period저장
			int r = ps.executeUpdate(); //수행결과로 int 타입의 값을 반환한다
			
			if(r>0) { //r이 양수이면
				System.out.println("가입 성공"); //r이 양수이면 성공
			}else { //r이 음수이면
				System.out.println("가입 실패"); //r이 음수이면 실패
			}
		}catch(Exception e) {
			e.printStackTrace(); //오류 발생
		}
		return ok;
	}//insertMember

	public boolean updateMember(MemberInformation vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null; //con에게 null할당
		PreparedStatement ps = null; //ps에게 null힐당
		try {
			con = getConn(); //con DB연결위한 준비
			String sql = "update jiyoon set name=?,homeAddress=?,phone=?,age=?,CurrentWeight=?,TargetWeight=?,height=?,period=?" +
						"where id=? and pwd=?";
			ps = con.prepareStatement(sql); 
			ps.setString(1,vMem.getName()); 
			ps.setString(2,vMem.getHomeAddress());
			ps.setString(3,vMem.getPhone());
			ps.setString(4,vMem.getAge());
			ps.setString(5,vMem.getCurrentWeight());
			ps.setString(6,vMem.getTargetWeight());
			ps.setString(7,vMem.getHeight());
			ps.setString(8,vMem.getPeriod());
			ps.setString(9,vMem.getId());
			ps.setString(10,vMem.getPwd());
			
			int r = ps.executeUpdate();
			
			if(r>0) ok = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	public boolean deleteMember(String id, String pwd) {
		
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			String sql = "Delete from jiyoon where id=? and pwd=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			int r = ps.executeUpdate();
			
			if(r>0) ok=true;
			
		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}
	
	/** DB데이터 다시 불러오기 **/
	public void userSelectAll(DefaultTableModel model) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {//db를 위한 준비작업--
			con = getConn();
			String sql = "select * from jiyoon order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//DefaultTableModel에 있는 데이터 지우기
			for(int i = 0; i < model.getRowCount();) {
				model.removeRow(0);//table에 있는 데이터를 지웁니다. 
			}
			
			while (rs.next()) { //object라는 배열에 회원 한 사람 한 사람당 정보가 저장됩니다.(mysql)
				Object data[] = {
						rs.getString(1), 
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)};
				
					model.addRow(data);
				}
			
			} catch (SQLException e) {
				System.out.println(e + "=> userSelectAll 실패"); //오류
			} finally { //최종적으로 
				if(rs!=null)//null이 아니면 수행
					try {
						rs.close(); //rs를 닫아준다
					}catch (SQLException e2) {
						e2.printStackTrace(); //오류 발생한 것 출력
					}//end of catch
				if(ps!=null)//ps가 null이 아닐 때
					try {
						ps.close(); //ps닫고
					}catch(SQLException e1) {
						e1.printStackTrace(); //오류(녹화, 녹음)
				if(con!=null) //con이 null이 아닐때
					try {
						con.close(); //con을 닫는다
					} catch (SQLException e) {
						e.printStackTrace(); //오류출력
					}//end of catch
			}//end of finally
		}
	}
} //end of DB_connection