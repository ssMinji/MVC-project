package pokemon.model.dto;

public class TrainerDTO extends People {
	private String region;
	private String pokemon1;
	private String pokemon2;
	private String pokemon3;
	private String pokemon4;

	public TrainerDTO() {
	}

	public TrainerDTO(int id, String name, int age, String gender, String region, String pokemon1, String pokemon2,
			String pokemon3, String pokemon4) {
		super(id, name, age, gender);
		this.region = region;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.pokemon3 = pokemon3;
		this.pokemon4 = pokemon4;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(String pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public String getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(String pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public String getPokemon3() {
		return pokemon3;
	}

	public void setPokemon3(String pokemon3) {
		this.pokemon3 = pokemon3;
	}

	public String getPokemon4() {
		return pokemon4;
	}

	public void setPokemon4(String pokemon4) {
		this.pokemon4 = pokemon4;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("  (5).출신지역 : ");
		builder.append(region);
		builder.append("  (6).보유 포켓몬 목록 :");
		builder.append(pokemon1 + "/" + pokemon2 + "/" + pokemon3 + "/" + pokemon4);
		return builder.toString();
	}
}
