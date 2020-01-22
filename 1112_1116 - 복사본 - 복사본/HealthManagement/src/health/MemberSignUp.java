// ȸ������â, ȸ����������â(����, Ż��)

package health;


import java.awt.*; //awt import
import java.sql.*; //�ڹٿ��� �����ͺ��̽��� ����ϱ� ���� ������ ���� �Ծ�
import java.util.*; //java.util ��Ű���� ��� Ŭ������ �ҷ����� ��
import javax.swing.*; //java���� gui�� �����ϱ� ���� jdk���� �⺻������ �����ϴ� ��
import javax.swing.table.DefaultTableModel; //DefaultTableModel ��� => JTable ��ü�� ������ �� DefaultTableModel�̶�� �������� �������ִ� ort javax.swing.text.JTextComponent; //JTextComponent ���� �׽�Ʈ ������Ʈ�� �⺻Ŭ���� �Դϴ�. / java.awt.TextComnent �ո������� �� �� �ִ� Ŭ������ ȣȯ�Ǥ�
import javax.swing.text.JTextComponent;


import java.awt.event.*; //�̺�Ʈ ������ ������ ������ �������ο��� �ַ� ��ġ��Ų��.


public class MemberSignUp extends JFrame implements ActionListener{
	
	
	JPanel panel; //�г� panel

	JTextField id_t, name_t, HomeAddress_t, Age_t; //���̵�, �̸�, ���ּ�, ����
	JTextField CurrentWeight_t, TargetWeight_t, height_t; //����, ��ǥ ������, Ű
	JTextField phone_1, phone_2, phone_3; //��ȭ
	
	
	JComboBox period_t; //�Ⱓ 
	
	JPasswordField password_t; //��й�ȣ 
	
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; //����, ���, ����, Ż�� ��ư

	
	//GridBagLayout�� GridLayout�� ���� �����̳ʸ� ���� ������ ������ ������Ʈ���� ��ġ�� �� �ִ�
	//�� ������ ���� �ٸ� ũ��� ������ �� ������, ������ �� �Ǵ� ������ Ȯ���� �����մϴ�.
	GridBagLayout gb;
	GridBagConstraints gbc; //GridBagConstraints�� ������ ���̾ƿ��� ���谡 �ֽ��ϴ�.
	MainDisplay mList; //mList����
	private JComboBox period_t_p; //����Ʈó�� ���� �׸� �߿��� �ϳ��� �����ϴµ� ����� �� �ֽ��ϴ�.
	
	//���Կ� ������
	public MemberSignUp() {
		createUI();//UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false); //��ư ��ü ��Ȱ��
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		
	} //end of MemberSignUp
	
	
	
	//���Կ� ������
	public MemberSignUp(MainDisplay mList) { 
		createUI();//UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;
		
	} //end of MemberSignUp

	
	
	//���� , ������ ������
	public MemberSignUp(String id, MainDisplay mList) { //�Ķ��Ÿ : id, mList
		
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;
		
		System.out.println("id=" + id); //id ��� ��
		
		DB_connection dao = new DB_connection();
		MemberInformation vMem = dao.getMemberDTO(id);
		viewData(vMem); 
		
	}//end of MemberSignUp, id�� ������ �����˴ϴ�.

	
	
	//MemberDTO(Ŭ����)�� ȸ�������� ������ ȭ�鿡 �������ִ� �޼ҵ�
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
		
		
		//ȭ�鿡 ����
		id_t.setText(id); //id
		id_t.setEditable(false);//���� �ȵǰ�
		
		password_t.setText(""); //��й�ȣ�� �Է����� �� �������� �ʵ��� ����
		
		name_t.setText(name); //name
		
		HomeAddress_t.setText(homeAddress); //homeAddress
		
		String[] tels = phone.split("-"); //phone
		phone_1.setText(tels[0]); //�迭 ����
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
		this.setTitle(" ȸ�� ����   ");
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
		
		//���̵�
		JLabel bld = new JLabel("���̵� :");
		id_t = new JTextField(20);
		bld.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱� / �׸���� ���̾ƿ� : ���� ���� �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		gbAdd(bld,0,0,1,1);
		gbAdd(id_t,1,0,3,1);
		
		//��й�ȣ
		JLabel bPwd = new JLabel("��й�ȣ : ");
		password_t = new JPasswordField(20);
		bPwd.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bPwd,0,1,1,1);
		gbAdd(password_t,1,1,3,1);
		
		//�̸�
		JLabel bName = new JLabel("�̸� :");
		name_t= new JTextField(20);
		bName.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bName,0,2,1,1);
		gbAdd(name_t,1,2,3,1);
		
		//�ּ�
		JLabel bHomeAddress = new JLabel("�ּ�: ");
		HomeAddress_t = new JTextField(20);
		bHomeAddress.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bHomeAddress,0,4,1,1);
		gbAdd(HomeAddress_t,1,4,3,1);
		
		//��ȭ
		JLabel bPhone = new JLabel("��ȭ :");
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
		phone_1.setFont(new Font("���� ���", Font.BOLD, 20));
		phone_2.setFont(new Font("���� ���", Font.BOLD, 20));
		phone_3.setFont(new Font("���� ���", Font.BOLD, 20));
		//�׸���鿡 ���̱�
		gbAdd(bPhone,0,3,1,1);
		gbAdd(SignUpPanel,1,3,3,1);
		
		//����
		JLabel bAge = new JLabel("����: ");
		Age_t = new JTextField(20);
		bAge.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bAge,0,5,1,1);
		gbAdd(Age_t,1,5,3,1);
		
		//���� ������
		JLabel bCurrentWeight = new JLabel("���� ������: ");
		CurrentWeight_t = new JTextField(20);
		bCurrentWeight.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bCurrentWeight,0,6,1,1);
		gbAdd(CurrentWeight_t,1,6,3,1);
		
		//��ǥ ������
		JLabel bTargetWeight = new JLabel("��ǥ ������: ");
		TargetWeight_t = new JTextField(20);
		bTargetWeight.setFont(new Font("���� ���", Font.BOLD, 15));
		//�׸���鿡 ���̱�
		gbAdd(bTargetWeight,0,7,1,1);
		gbAdd(TargetWeight_t,1,7,3,1);
		
		//Ű
		JLabel bHeight = new JLabel("Ű: ");
		bHeight.setFont(new Font("���� ���", Font.BOLD, 15));
		height_t = new JTextField(20);
		//�׸���鿡 ���̱�
		gbAdd(bHeight,0,8,1,1);
		gbAdd(height_t,1,8,3,1);
		
		//�Ⱓ
		JLabel bperiod = new JLabel("�Ⱓ : ");
		String[] arrperiod = {"����","3����","4����","5����","6����","7����","8����","9����","10����","11����","12����"};
		bperiod.setFont(new Font("���� ���", Font.BOLD, 15));
		period_t_p = new JComboBox(arrperiod);
		JPanel pperiod = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pperiod.add(period_t_p);
		//�׸���鿡 ���̱�
		gbAdd(bperiod,0,9,1,1);
		gbAdd(pperiod,1,9,3,1);
		
		//��ư
		JPanel pButton = new JPanel();
		Font font;
		font = new Font("���� ���", Font.BOLD, 17);
		btnInsert = new JButton("����"); //���� ��ư ����
		btnUpdate = new JButton("����"); //���� ��ư ����
		btnDelete = new JButton("Ż��"); //Ż�� ��ư ����
		btnCancel = new JButton("���"); //��� ��ư ����
		
		btnInsert.setBackground(new Color(151, 201, 210));
		btnUpdate.setBackground(new Color(102, 159, 175));
		btnDelete.setBackground(new Color(151, 201, 210));
		btnCancel.setBackground(new Color(102, 159, 175));
		
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		//�׸���鿡 ���̱�
		gbAdd(pButton,0,10,4,1);
		
		//��ư�� �����⸦ ���̱�
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);
		
		setBackground(new Color(218, 226, 234));
		setSize(500,600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		
		
	}//end of createUl

	
	
	//�׸���鷹�̾ƿ��� ���̴� �޼ҵ�
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
		
		new MemberSignUp(); //����
	}
	
	
	
	
	//Ż��
	@Override
	public void actionPerformed(ActionEvent ae) { //����
		this.setTitle(" Ż�� â  ");
		if(ae.getSource() == btnInsert) { //���� button
			insertMember();  //insertMember ȣ��
			System.out.println("insertMember() ȣ�� ����");
			
		}else if(ae.getSource() == btnCancel) { //��� button
			this.dispose(); //â�ݱ�(����â�� ����)
			
		}else if(ae.getSource() == btnUpdate) { //���� button
			UpdateMember(); //UpdateMember ȣ��
			
		}else if(ae.getSource() == btnDelete) { //���� button
			int x = JOptionPane.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
			
			
			if(x == JOptionPane.OK_OPTION) { //���� OK���
				deleteMember(); //deleteMember ȣ�� 
				
			}else {
				JOptionPane.showMessageDialog(this, "������ ����Ͽ����ϴ�."); //������ ������� ���� �޼��� ���
			}
		}
		
		//jTable���� ���� �޼ҵ� ȣ��
		mList.jTableRefresh();
	
	}//end of actionPerformed
	
	
	
	//���� ���
	private void deleteMember() {
	
		String id = id_t.getText();
		String pwd = password_t.getText();
		
		if(pwd.length()==0) { //�н����� ���̰� 0�̸�
			
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �� �Է��ϼ���!"); //��й�ȣ�� �Է��ϴ� �޼��� ���
			return; //�޼ҵ� ��
		} 
		DB_connection dao = new DB_connection();
		boolean ok = dao.deleteMember(id, pwd);
		
		if(ok) {
			JOptionPane.showMessageDialog(this, "�����Ϸ�"); //���� ����� �޼��� ����
			dispose();
		}else {
			JOptionPane.showMessageDialog(this, "��������"); //�ƴ� ����� �޼��� ����
		}
		
	}//end of deleteMember
	
	
	
	
	private void UpdateMember() {
		this.setTitle(" ���� â  ");
		//ȭ���� ������ ����ϴ�
		MemberInformation dto = getViewData();
		//�� ������ DB�� ����
		DB_connection dao = new DB_connection();
		
		boolean ok = dao.updateMember(dto);
		
		if(ok) {
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�!"); //���� ����� �޼��� ����
			this.dispose();
			
		}else {
			JOptionPane.showMessageDialog(this, "�������� : �ٽ� Ȯ�����ּ���!"); //�ƴ� ����� �޼��� ����
		}
		
	} //end of insertMember
	
	
	private void insertMember() {
		
		//ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		MemberInformation dto = getViewData();
		
		DB_connection dao = new DB_connection();
		
		boolean ok = dao.insertMember(dto);
		

		if(ok) {
			JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�."); //�ƴ� ����� �޼��� ����
			this.dispose();
			
		}else {
			JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�."); //���� ��� �޼��� ����
		}
		
	}//end of insertMember

	
	private MemberInformation getViewData() {
		
		//ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		MemberInformation dto = new MemberInformation();
		String id = id_t.getText();  //���̵�
		String pwd = password_t.getText();  //��й�ȣ
		String name = name_t.getText();  //�̸�
		String homeAddress = HomeAddress_t.getText(); //�� �ּ�
		String Phone1 = phone_1.getText(); //��ȭ��ȣ 1
		String Phone2 = phone_2.getText(); //��ȭ��ȣ 2
		String Phone3 = phone_3.getText(); //��ȭ��ȣ 3
		String Phone = Phone1+"-"+Phone2+"-"+Phone3; //��ȭ��ȣ ���� ����
		String age = Age_t.getText(); //����
		String CurrentWeight = CurrentWeight_t.getText(); //���� ������
		String TargetWeight = TargetWeight_t.getText(); //��ǥ ������
		String height = height_t.getText(); //Ű
		String period = (String)period_t_p.getSelectedItem(); //������ǥ�Ⱓ
		
		//dto�� ��´�.
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
		
		return dto; //dto�� ��ȯ�մϴ�.
		
	}//end of getViewDate
	
}//end of MemberSignIp