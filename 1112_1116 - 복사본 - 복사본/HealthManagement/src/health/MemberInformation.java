// �Ѹ��� ȸ�������� �����ϴ� Ŭ����

package health;

public class MemberInformation {
	
	private String id; //���̵�
	private String pwd; //��й�ȣ
	private String name; //�̸�
	private String homeAddress; //�� �ּ�
	private String phone; //��ȭ��ȣ
	private String age; //����
	private String CurrentWeight; //���� ������
	private String TargetWeight; //��ǥ ������
	private String height; //Ű
	private String period; //��ǥ�����Ⱓ
	
	//Getter, Setter
	public String getId() { //���̵��� ���� �������� getter
		return id;
	}
	public void setId(String id) { //���̵��� ���� �����ϴ� setter
		this.id = id;
	}
	public String getPwd() { //��й�ȣ�� ���� �������� getter
		return pwd;
	}
	public void setPwd(String pwd) { //��й�ȣ�� ���� �����ϴ� setter
		this.pwd = pwd;
	}
	public String getName() { //�̸��� ���� �������� getter
		return name;
	}
	public void setName(String name) { //�̸��� ���� �����ϴ� setter
		this.name = name;
	}
	public String getHomeAddress() { //�� �ּ��� ���� �������� getter
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) { //�� �ּ��� ���� �����ϴ� setter
		this.homeAddress = homeAddress;
	}
	public String getPhone() { //��ȭ��ȣ�� ���� �������� getter
		return phone;
	}
	public void setPhone(String phone) { //��ȭ��ȣ�� ���� �����ϴ� setter
		this.phone = phone;
	}
	public String getAge() { //������ ���� �������� getter
		return age;
	}
	public void setAge(String age) { //������ ���� �����ϴ� setter
		this.age = age;
	}
	public String getCurrentWeight() { //���� �������� ���� �������� getter
		return CurrentWeight;
	}
	public void setCurrentWeight(String currentWeight) { //���� �������� ���� �����ϴ� setter
		CurrentWeight = currentWeight;
	}
	public String getTargetWeight() { //��ǥ �������� ���� �������� getter
		return TargetWeight;
	}
	public void setTargetWeight(String targetWeight) { //��ǥ �������� ���� �����ϴ� setter
		TargetWeight = targetWeight;
	}
	public String getHeight() { //Ű�� ���� �������� getter
		return height;
	}
	public void setHeight(String height) { //Ű�� ���� �����ϴ� setter
		this.height = height;
	}
	public String getPeriod() { //��ǥ�����Ⱓ�� ���� �������� getter
		return period;
	}
	public void setPeriod(String period) { //��ǥ�����Ⱓ�� ���� �����ϴ� setter
		this.period = period;
	}
	//DTO ��ü Ȯ��
	@Override
	public String toString() {
		return "MemberInformation [id=" + id + ", pwd=" + pwd + ", name=" + name + ", homeAddress=" + homeAddress + ", phone="
				+ phone + ", age=" + age + ", CurrentWeight=" + CurrentWeight + ", TargetWeight=" + TargetWeight
				+ ", height=" + height + ", period=" + period + "]";
	}
	
}//end of MemberInformation