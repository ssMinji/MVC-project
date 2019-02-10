package pokemon.model.dto;

public class DoctorDTO extends People{
	private String major;
	private String hiredate;
	
	public DoctorDTO() {}
	
	public DoctorDTO(String major) {
		this.major = major;
	}
	
	public DoctorDTO(int id, String name, int age, String gender, String major, String hiredate) {
		super(id, name, age, gender);
		this.major = major;
		this.hiredate = hiredate;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("  (5).전공분야 : ");
		builder.append(major);
		builder.append("  (6).고용된 날짜 :");
		builder.append(hiredate);
		return builder.toString();
	}
}
