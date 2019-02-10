package pokemon.model.dto;

public class PokemonDTO {
	private int id;
	private String name;
	private String type1;
	private String type2;
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private int total;

	public PokemonDTO() {
	}

	public PokemonDTO(int id, String name, String type1, String type2, int hp, int attack, int defense, int speed,
			int total) {
		super();
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.total = total;
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

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(1).포켓몬 번호 : ");
		builder.append(id);
		builder.append("  (2).이름 : ");
		builder.append(name);
		builder.append("  (3).타입1 : ");
		builder.append(type1);
		builder.append("  (4).타입2 : ");
		builder.append(type2);
		builder.append("  (5).HP : ");
		builder.append(hp);
		builder.append("  (6).Attack : ");
		builder.append(attack);
		builder.append("  (7).Defense : ");
		builder.append(defense);
		builder.append("  (8).Speed : ");
		builder.append(speed);
		builder.append("  (9).Total : ");
		builder.append(total);
		return builder.toString();
	}

}
