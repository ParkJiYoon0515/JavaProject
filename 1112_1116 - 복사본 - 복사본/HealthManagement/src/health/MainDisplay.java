// ����â : ȸ������Ʈ ���
package health;

import java.awt.BorderLayout; // ��������(�����¿�)�� ����� ��ġ�� �� ������, �⺻���Դϴ�.
import java.awt.Color; //�� ColorŬ������ �⺻ sRGB���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���˴ϴ� 
import java.awt.Component; // Abstract Window Toolkit ��������� �߻� ���� Ŭ����, ������ ������Ҹ� ����� ���� Ŭ������ ���� Ȯ���� ���� �ֽ��ϴ�. 
import java.awt.Font; //�ڹٿ��� �Է��� ���ڿ� ȿ���� �� �� Font Ŭ������ Ȱ���Ѵ�.
import java.awt.Image; //�ڹٿ��� �̹����� java.awt.Image Ŭ������ ��ü�� ǥ��
import java.awt.Toolkit; //��Ŷ�� java.awt.Toolkit Ŭ������ ���� ���� / �������� ����� �ڵ����� ����
import java.awt.event.*; //�̺�Ʈ ������ ������ ������ �������ο��� �ַ� ��ġ��Ų��.
import java.util.*; //java.util ��Ű���� ��� Ŭ������ �ҷ����� ��
import javax.swing.*; //java���� gui�� �����ϱ� ���� jdk���� �⺻������ �����ϴ� ��
import javax.swing.table.DefaultTableModel;  //DefaultTableModel ��� => JTable ��ü�� ������ �� DefaultTableModel�̶�� �������� �������ִ� �Ͱ� ����
import java.awt.FlowLayout; //Button ������� ���弱���� FlowLayoutŬ������ ����ϰ� �ִ�. ���� ���� ��ư�� ����� ������� ��ġ�ϴ� Ŭ�����̴�.

public class MainDisplay extends JFrame implements MouseListener,ActionListener{
		
	Vector v; //Vector => ������ ���̷� ���� ���������� �����ϱ� ���� Vector Ŭ������ �����Ѵ�.
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane s_pane ;
	JPanel pbtn;
	JButton btnInsert;
	private JButton btnNewButton;
	
	//������ �޼ҵ�
	public MainDisplay() { 
		super("ȸ�� ���"); //ȸ������ ���������� ����
		//DAO : ������ ���̽��� �����ؼ� ������ �߰�, ����, ���� ���� �۾��� �ϴ� Ŭ����
	    //Ŭ���� DB_connection�� �̿��� ������ ���̽��� ������ ��ü ����
		DB_connection dao = new DB_connection();
		v = dao.getMemberList();  //dao.getMemberList() => ȸ�������� �������� �޼���
		System.out.println("v= " + v); //ȸ�� ���� ���
		cols = getColumn(); //getColumn() => ���� ������
		 
		
		//DefaultTableModel ��� => ���̺� ������� ���ų� ������ ������, JTable ��ü�� ������ �� DefaultTableModel�̶�� �������� �������ִ� �Ͱ� ����
		//������ ����� DefaultTableModel�� ���ؼ� ����� �� ����
		//DefaultTableModel ��ü�� �����ϸ鼭 �����͸� ����ϴ�. / JTable�� ���� �־��� �����͸� �����ܿ� ���� �� 
		model = new DefaultTableModel(v, cols); //v = ȸ�� ���� , cols = (ȸ������)��
		
		
		//Frame�� ��������� ContentPane�� setting�� ���Ͽ� JFrameŬ������ ��ü �޼ҵ��� getContentPane()�� ȣ��
		//������ ���̾ƿ� setLayout(null);�� ����Ͽ����ϴ�.
		getContentPane().setLayout(null);
		
		
		
		//�������� ������ �� JTable�� ������ �� �� �������� ��Ƽ� �����ϱ�
		jTable = new JTable(model); // �� JTabe ��ü�� ������ �� DefaultTableModel�̶�� �������� ����ϰڴٴ� �ǹ�
		jTable.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		s_pane = new JScrollPane(jTable); //��ũ�� �������� ������Ʈ�� ��ũ�� ����� ������ = > ȸ�� ������ ������������ ��ũ�� ��� ����
		s_pane.setBounds(0, 0, 994, 501);  //��ũ�� ũ�� ����
		s_pane.setBackground(new Color(218, 226, 234));
		getContentPane().add(s_pane); //���̺� �߰��� ������Ʈ
		
		
		
		pbtn = new JPanel(); //JPanel : ���� ������(������ ������), 'pbtn'�̸����� JPanel ��ü ����
		pbtn.setBounds(0, 508, 982, 45); //������ ũ�� ����
		pbtn.setLayout(null);
		btnInsert = new JButton("\uD68C\uC6D0\uAC00\uC785"); //'butInsert'�̸����� JButton ��ü ����(button) , "\uD68C\uC6D0\uAC00\uC785" => ȸ������
		btnInsert.setBounds(422, -1, 138, 46);
		btnInsert.setBackground(new Color(151, 201, 210)); //btnInsert�� ��ư Background ���� ����
		pbtn.add(btnInsert); //pbtn�̶�� �гο� btnInsert ��ư�� �߰��Ѵ�
		getContentPane().add(pbtn); //�гο� �߰��� ������Ʈ
		
		
		//�̺�Ʈ ������ �߰� : �̺�Ʈ�� �߻����� �� �� ó���� ����ϴ� �Լ��� ����Ŵ (MouseListener, ActionListener)
		//this = �ڱ��ڽ�
		jTable.addMouseListener(this); //jTable�� ���콺������ ���
		btnInsert.addActionListener(this); //btnInsert(ȸ�����Թ�ư)�� ������ ���

		
		
		
		setSize(1000, 600); //main â ũ�� ����
		setVisible(true); //main â ���̵��� ����
		setResizable(false);
		//X��ư ������ �� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBackground(new java.awt.Color(218, 226, 234)); //'ȸ������'�� ��ư ���� ���� 
		setLocation(470, 200); //'ȸ������'�� ��ư ũ�� ����
		Image img_1 = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		setIconImage(img_1);
		

		
		jTable.setFont(new Font("�������", Font.PLAIN, 17)); //JTable�� ��Ʈ ����
		s_pane.setFont(new Font("�������", Font.PLAIN, 17)); //s_pane�� ��Ʈ ����
		pbtn.setFont(new Font("�������", Font.PLAIN, 22));  //pbtn�� ��Ʈ ����
		btnInsert.setFont(new Font("���� ���", Font.PLAIN, 20)); //btnInsert�� ��Ʈ ����
		
		
		btnNewButton = new JButton("\uBA54\uC778\uD654\uBA74");
		btnNewButton.setFont(new Font("���� ���", Font.PLAIN, 17));
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
		
		
		
		
		jTable.setRowHeight(25); //�� ���� ����
		jTable.setBackground(new java.awt.Color(255, 240, 245)); //ǥ background �� ����
		
		
	}//end of MainDisplay(and ������)
	
	
	
	//JTable�� �÷�  // �÷� : ������ �����ͺ��̽� ���̺��� Ư���� �ܼ� �ڷ����� �Ϸ��� ������ ���� ���̺����� �� ���� ���Ѵ�.
	//�ڹٿ����� ������ ���̷� ���� ���������� �����ϱ� ���� Vector Ŭ������ �����Ѵ�. ���� Vactor Ŭ������ ���� ������ �迭�̶�� �� �� �ִ�.
	public Vector getColumn() { //ǥ�� �� �κ� ������ ǥ��
			Vector col = new Vector(); //'col'�̸����� Vector ��ü ����
			col.add("���̵�"); //id
			col.add("��й�ȣ"); //pwd 
			col.add("�̸�"); //name
			col.add("�ּ�"); //homeAddress
			col.add("��ȭ��ȣ"); //phone
			col.add("����"); //age
			col.add("���� ������"); //CurrentWeight
			col.add("��ǥ ������"); //TargetWeight
			col.add("Ű"); //height
			col.add("�Ⱓ"); //period
			
		
			return col; //col ��ȯ
		
		
	}//end of getColumn

	
	//table ���� ���� �޼���
	public void jTableRefresh() {
		
			//DAO(DATA access object, DB�� �����ؼ� ������ ����) : ������ �߰�, ����, ���� ���� �۾��� �ϴ� �޼ҵ� 
			DB_connection dao = new DB_connection(); //'dao'�̸����� DAO ��ü ���� (������ �߰�, ����, ���� �۾�)
			DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());  //dao.getMemberList(), getColumn() �����͸� ��� 'model'�̸��� ��ü ����
			jTable.setModel(model); //JTable�� setModel �޼ҵ带 �̿��Ͽ� ������('model'������) �ֱ�
				
		}//end of jTableRefresh
			
		
	public static void main(String[] args) {
		new MainDisplay(); //Member-List Ŭ���� ����
	}//end of main


	//�̺�Ʈ(Event) �⺻  => ���콺 ������ ����
	@Override
	public void mouseClicked(MouseEvent e) { //���콺�� �ش� ������Ʈ�� Ŭ������ ��
		//mouseClicked�� ���
		int r = jTable.getSelectedRow(); //getSelectedRow() => "getSelectedRow()"�޼ҵ�� ���õ� ���� �ִ��� �˻�
		String id = (String)jTable.getValueAt(r, 0); //getValueAt() �޼ҵ�� ���ϴ� ��ġ�� �����͸� �������� �޼ҵ� / jTable���� ������ �� ��������
		MemberSignUp mem = new MemberSignUp(id,this); //���̵� ���ڷ� ����â ����
		
	}//end of mouseClicked

	
	
	
	//MouseListener �������̽��� ������ 4�� �޼ҵ嵵 ��� ������ �Ͽ��� ������ ��
	@Override
	public void mouseEntered(MouseEvent e) { //���콺�� �ش� ������Ʈ ���� ������ ���� �� �߻�
		
	}
	@Override
	public void mouseExited(MouseEvent e) { //���콺�� �ش� ������Ʈ ���� ������ ���� �� �߻�
		
	}
	@Override
	public void mousePressed(MouseEvent e) { //���콺 ��ư�� ���� �� �߻�
		
	}
	@Override
	public void mouseReleased(MouseEvent e) { //������ ���콺�� ���� �� �߻�
		
	}
	
	
	
	
	//��ư Ŭ�� �ÿ� �ߵ� �Ǵ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ư�� Ŭ���ϸ�
		if(e.getSource() == btnInsert) {
			new MemberSignUp(this);  //���ο� ����â�� �����Ѵ�.
		}
	}//end of actionPerformed
	
}//end of MainDisplay