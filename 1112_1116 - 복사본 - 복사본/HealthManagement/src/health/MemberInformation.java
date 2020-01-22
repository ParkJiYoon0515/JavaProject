// 한명의 회원정보를 저장하는 클래스

package health;

public class MemberInformation {
	
	private String id; //아이디
	private String pwd; //비밀번호
	private String name; //이름
	private String homeAddress; //집 주소
	private String phone; //전화번호
	private String age; //나이
	private String CurrentWeight; //현재 몸무게
	private String TargetWeight; //목표 몸무게
	private String height; //키
	private String period; //목표감량기간
	
	//Getter, Setter
	public String getId() { //아이디의 값을 가져오는 getter
		return id;
	}
	public void setId(String id) { //아이디의 값을 수정하는 setter
		this.id = id;
	}
	public String getPwd() { //비밀번호의 값을 가져오는 getter
		return pwd;
	}
	public void setPwd(String pwd) { //비밀번호의 값을 수정하는 setter
		this.pwd = pwd;
	}
	public String getName() { //이름의 값을 가져오는 getter
		return name;
	}
	public void setName(String name) { //이름의 값을 수정하는 setter
		this.name = name;
	}
	public String getHomeAddress() { //집 주소의 값을 가져오는 getter
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) { //집 주소의 값을 수정하는 setter
		this.homeAddress = homeAddress;
	}
	public String getPhone() { //전화번호의 값을 가져오는 getter
		return phone;
	}
	public void setPhone(String phone) { //전화번호의 값을 수정하는 setter
		this.phone = phone;
	}
	public String getAge() { //나이의 값을 가져오는 getter
		return age;
	}
	public void setAge(String age) { //나이의 값을 수정하는 setter
		this.age = age;
	}
	public String getCurrentWeight() { //현재 몸무게의 값을 가져오는 getter
		return CurrentWeight;
	}
	public void setCurrentWeight(String currentWeight) { //현재 몸무게의 값을 수정하는 setter
		CurrentWeight = currentWeight;
	}
	public String getTargetWeight() { //목표 몸무게의 값을 가져오는 getter
		return TargetWeight;
	}
	public void setTargetWeight(String targetWeight) { //목표 몸무게의 값을 수정하는 setter
		TargetWeight = targetWeight;
	}
	public String getHeight() { //키의 값을 가져오는 getter
		return height;
	}
	public void setHeight(String height) { //키의 값을 수정하는 setter
		this.height = height;
	}
	public String getPeriod() { //목표감량기간의 값을 가져오는 getter
		return period;
	}
	public void setPeriod(String period) { //목표감량기간의 값을 수정하는 setter
		this.period = period;
	}
	//DTO 객체 확인
	@Override
	public String toString() {
		return "MemberInformation [id=" + id + ", pwd=" + pwd + ", name=" + name + ", homeAddress=" + homeAddress + ", phone="
				+ phone + ", age=" + age + ", CurrentWeight=" + CurrentWeight + ", TargetWeight=" + TargetWeight
				+ ", height=" + height + ", period=" + period + "]";
	}
	
}//end of MemberInformation