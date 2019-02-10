package pokemon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pokemon.model.dto.HospitalDTO;
import pokemon.model.util.DBUtil;

public class HospitalDAO {

	// 모든 입원 현황 정보 반환
	public static ArrayList<HospitalDTO> getAllHospital() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HospitalDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select h.no, d.name, t.name, p.name, indate, outdate "
					+ "from hospital h, pokemon p, trainer t, doctor d "
					+ "where h.pid = p.id and h.tid = t.id and h.did = d.id");
			rset = pstmt.executeQuery();
			all = new ArrayList<HospitalDTO>();

			while (rset.next()) {
				all.add(new HospitalDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}

	// Hospital 등록(Insert)
	public static boolean addHospital(HospitalDTO hospital) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into hospital values(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, hospital.getNo());
			pstmt.setInt(2, hospital.getDid());
			pstmt.setInt(3, hospital.getTid());
			pstmt.setInt(4, hospital.getPid());
			pstmt.setString(5, hospital.getIndate());
			pstmt.setString(6, hospital.getOutdate());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Pokemon name으로 해당 Pokemon의 모든 정보 반환
	public static HospitalDTO getHospital(int pid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HospitalDTO hospital = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select h.no, d.name, t.name, p.name, indate, outdate\r\n" + 
															"from hospital h, doctor d, trainer t, pokemon p\r\n" + 
														"where h.did = d.id and h.tid = t.id and h.pid = p.id and h.pid = ?");
			pstmt.setInt(1, pid);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				hospital = new HospitalDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return hospital;
	}

	// 퇴원 수속 한 환자 제거 후 입원 현황 갱신
	public static boolean refreshHospital() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;


		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from hospital where outdate-trunc(sysdate) < 0");
			
			int result = pstmt.executeUpdate();
			
			if  (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
