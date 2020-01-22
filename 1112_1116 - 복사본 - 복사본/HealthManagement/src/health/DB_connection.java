// �����ͺ��̽��� �����ϴ� ��ü
package health;	//��Ű���� health�̴�

import java.sql.*; //JDBC�� ����ϱ� ���� import���ش�
import java.util.Vector; //vector�� �����迭�ڷᱸ���� ����ȭ������ �Ǿ��־ �����Դϴ�

import javax.swing.table.DefaultTableModel; 
//table�� �����Ѵ� DefaultTableModel�� ����������μ� ���̺��� �����͸� ������ �� �ִ�. 

public class DB_connection { //mysql �����ͺ��̽��� �������� �غ�
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹� 
	private static final String URL = "jdbc:mysql://localhost/management?serverTimezone=UTC"; //���� �����ͺ��̽� �ּ�
	
	private static final String USER = "root"; //������ ���̽� ���̵�(root=>�ֻ���)
	private static final String PASS = "goflvhxj03"; //������ ���̽� ��й�ȣ
	MainDisplay mList; //mList����
	
	public DB_connection() { //�Ű������� ���� DB_connection�����ڸ޼���
		
	}//end of DB_connection
	
	public DB_connection(MainDisplay mList) { //�Ű������� �ִ� DB_connection�����ڸ޼���
		this.mList = mList; //
		System.out.println("DAO =" + mList); //Ȯ���� ���
	} //end of DB_connection(�Ű�����)
	
	public Connection getConn() { //������ ���̽��� �����ϴ� Ŭ����
		Connection con = null; //connection�����ϰ� null�Ҵ�
		try {
			Class.forName(DRIVER); //����̹��� �ε���Ų��
			con = DriverManager.getConnection(URL, "root", "goflvhxj03"); //�ּ�, ���̵�, ��й�ȣ�� �̿��� ����̹� ����
		}catch (Exception e) {
			e.printStackTrace(); //�������
		}
		return con; //con(connection)�� return
	}//end of getConn

	public MemberInformation getMemberDTO(String id) {
		
		MemberInformation dto = new MemberInformation(); //dto��ü ����
		
		Connection con = null;   //con�� unll�Ҵ�
		PreparedStatement ps = null;  //ps�� unll�Ҵ�
		ResultSet rs = null; //rs�� unll�Ҵ�
		
		try {
			con = getConn();
			String sql = "select * from jiyoon where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery(); //�������� rs��ü�� ���� ��ȯ�Ѵ�
			
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
		
		return dto; //dto return���ش�
	}

	public Vector getMemberList() {
		Vector data = new Vector(); //data vector����
		
		Connection con = null; //con�� null�Ҵ�
		PreparedStatement ps = null; //ps�� null�Ҵ�
		ResultSet rs = null; //rs�� null�Ҵ�
		
		try {
			con = getConn(); //DB���� ���� ������Ʈ �ۼ� 
			String sql = "select * from jiyoon order by name asc"; //select������ ����������
			ps = con.prepareStatement(sql); //
			rs = ps.executeQuery(); //
			
			while(rs.next()) { //
			String id = rs.getString("id"); //id�� �Է¹��� id�̴�
			String pwd = rs.getString("pwd"); //pwd�� �Է¹��� pwd�̴�
			String name = rs.getString("name"); //id�� �Է¹��� id�̴�
			String homeAddress = rs.getString("homeAddress"); //id�� �Է¹��� id�̴�
			String phone = rs.getString("phone"); //id�� �Է¹��� id�̴�
			String age = rs.getString("age"); //id�� �Է¹��� id�̴�
			String CurrentWeight = rs.getString("CurrentWeight"); //id�� �Է¹��� id�̴�
			String TargetWeight = rs.getString("TargetWeight"); //id�� �Է¹��� id�̴�
			String height = rs.getString("height"); //id�� �Է¹��� id�̴�
			String period = rs.getString("period"); //id�� �Է¹��� id�̴�
			
			Vector row = new Vector(); //select������ ����������
			row.add(id); 	//table�� id�߰�
			row.add(pwd);	//table�� ��й�ȣ�߰�
			row.add(name);	//table�� �̸��߰�
			row.add(homeAddress);	//table�� ���ּ��߰�
			row.add(phone);	//table�� ��ȭ��ȣ�߰�
			row.add(age);	//table�� �����߰�
			row.add(CurrentWeight);	//table�� ���� �������߰�
			row.add(TargetWeight);	//table�� ��ǥ �������߰�
			row.add(height);//table�� Ű�߰�
			row.add(period);//table�� ��ǥ�޼��Ⱓ�߰�
			data.add(row);
		   }
		}catch(Exception e) {
			e.printStackTrace(); //���� ���
		}
		return data; //data�� ���ϰ����� ��
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
						"values(?,?,?,?,?,?,?,?,?,?)"; //8���� ������ �Է����� 8���� ����ǥ �ʿ�
			
			ps = con.prepareStatement(sql); //���ͽ�����..?
			ps.setString(1, dto.getId()); //set�޼��忡 id����
			ps.setString(2, dto.getPwd());//set�޼��忡 password����
			ps.setString(3, dto.getName());//set�޼��忡 name����
			ps.setString(4, dto.getHomeAddress());//set�޼��忡 homeAddress����
			ps.setString(5, dto.getPhone());//set�޼��忡 phone����
			ps.setString(6, dto.getAge());//set�޼��忡 age����
			ps.setString(7, dto.getCurrentWeight());//set�޼��忡 currentWeight����
			ps.setString(8, dto.getTargetWeight());//set�޼��忡 targetWeight����
			ps.setString(9, dto.getHeight());//set�޼��忡 height����
			ps.setString(10, dto.getPeriod());//set�޼��忡 period����
			int r = ps.executeUpdate(); //�������� int Ÿ���� ���� ��ȯ�Ѵ�
			
			if(r>0) { //r�� ����̸�
				System.out.println("���� ����"); //r�� ����̸� ����
			}else { //r�� �����̸�
				System.out.println("���� ����"); //r�� �����̸� ����
			}
		}catch(Exception e) {
			e.printStackTrace(); //���� �߻�
		}
		return ok;
	}//insertMember

	public boolean updateMember(MemberInformation vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null; //con���� null�Ҵ�
		PreparedStatement ps = null; //ps���� null����
		try {
			con = getConn(); //con DB�������� �غ�
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
			System.out.println(e + "-> �����߻�");
		}
		return ok;
	}
	
	/** DB������ �ٽ� �ҷ����� **/
	public void userSelectAll(DefaultTableModel model) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {//db�� ���� �غ��۾�--
			con = getConn();
			String sql = "select * from jiyoon order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//DefaultTableModel�� �ִ� ������ �����
			for(int i = 0; i < model.getRowCount();) {
				model.removeRow(0);//table�� �ִ� �����͸� ����ϴ�. 
			}
			
			while (rs.next()) { //object��� �迭�� ȸ�� �� ��� �� ����� ������ ����˴ϴ�.(mysql)
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
				System.out.println(e + "=> userSelectAll ����"); //����
			} finally { //���������� 
				if(rs!=null)//null�� �ƴϸ� ����
					try {
						rs.close(); //rs�� �ݾ��ش�
					}catch (SQLException e2) {
						e2.printStackTrace(); //���� �߻��� �� ���
					}//end of catch
				if(ps!=null)//ps�� null�� �ƴ� ��
					try {
						ps.close(); //ps�ݰ�
					}catch(SQLException e1) {
						e1.printStackTrace(); //����(��ȭ, ����)
				if(con!=null) //con�� null�� �ƴҶ�
					try {
						con.close(); //con�� �ݴ´�
					} catch (SQLException e) {
						e.printStackTrace(); //�������
					}//end of catch
			}//end of finally
		}
	}
} //end of DB_connection