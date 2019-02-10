package pokemon.model.dto;

public class People {
	private int id;
	private String name;
	private int age;
	private String gender;

	public People() {
	}

	public People(int id, String name, int age, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(1).ID : ");
		builder.append(id);
		builder.append("  (2).이름 : ");
		builder.append(name);
		builder.append("  (3).나이 : ");
		builder.append(age);
		builder.append("  (4).성별 : ");
		builder.append(gender);
		return builder.toString();
	}

}
