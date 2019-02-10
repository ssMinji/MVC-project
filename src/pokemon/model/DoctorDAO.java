package pokemon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pokemon.model.dto.DoctorDTO;
import pokemon.model.util.DBUtil;

public class DoctorDAO {

	// 모든 Doctor 정보 반환
	public static ArrayList<DoctorDTO> getAllDoctor() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DoctorDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from doctor");
			rset = pstmt.executeQuery();
			all = new ArrayList<DoctorDTO>();

			while (rset.next()) {
				all.add(new DoctorDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4),
						rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}
	
	// Doctor 등록(Insert)
	public static boolean addDoctor(DoctorDTO doctor) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into doctor values(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, doctor.getId());
			pstmt.setString(2, doctor.getName());
			pstmt.setInt(3, doctor.getAge());
			pstmt.setString(4, doctor.getGender());
			pstmt.setString(5, doctor.getMajor());
			pstmt.setString(6, doctor.getHiredate());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Doctor id로 major 수정
	public static boolean updateDoctor(int id, String major) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update doctor set major =? where id =? ");
			pstmt.setString(1, major);
			pstmt.setInt(2, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 특정한 major인 Doctor 삭제
	public static boolean deleteDoctor(String major) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("delete from doctor where major =? ");
			pstmt.setString(1, major);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ID로 해당 Doctor의 모든 정보 반환
	public static DoctorDTO getDoctor(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DoctorDTO doctor = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from doctor where id =?");
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				doctor = new DoctorDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4),
						rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return doctor;
	}
}
