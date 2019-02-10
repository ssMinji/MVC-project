package pokemon.model.dto;

public class HospitalDTO {
	private int no;
	private int did;
	private int tid;
	private int pid;
	private String indate;
	private String outdate;
	private String dname;
	private String tname;
	private String pname;

	public HospitalDTO() {
	}

	public HospitalDTO(int no, int did, int tid, int pid, String indate, String outdate) {
		super();
		this.no = no;
		this.did = did;
		this.tid = tid;
		this.pid = pid;
		this.indate = indate;
		this.outdate = outdate;
	}

	public HospitalDTO(int no, String dname, String tname, String pname, String indate, String outdate) {
		super();
		this.no = no;
		this.dname = dname;
		this.tname = tname;
		this.pname = pname;
		this.indate = indate;
		this.outdate = outdate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(1).환자 번호 : ");
		builder.append(no);
		builder.append("  (2).담당의 이름 : ");
		builder.append(dname);
		builder.append("  (3).포켓몬 주인 이름 : ");
		builder.append(tname);
		builder.append("  (4).포켓몬 이름 : ");
		builder.append(pname);
		builder.append("  (5).입원 날짜 : ");
		builder.append(indate);
		builder.append("  (6).퇴원 예정 날짜 : ");
		builder.append(outdate);
		return builder.toString();
	}

}
