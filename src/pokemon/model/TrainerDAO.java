package pokemon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pokemon.model.dto.TrainerDTO;
import pokemon.model.util.DBUtil;

public class TrainerDAO {
	
		// 모든 Trainer 정보 반환
		public static ArrayList<TrainerDTO> getAllTrainer() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<TrainerDTO> all = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from trainer");
				rset = pstmt.executeQuery();
				all = new ArrayList<TrainerDTO>();

				while (rset.next()) {
					all.add(new TrainerDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4),
							rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return all;
		}
		
	// Trainer 등록(Insert)
	public static boolean addTrainer(TrainerDTO trainer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into trainer values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, trainer.getId());
			pstmt.setString(2, trainer.getName());
			pstmt.setInt(3, trainer.getAge());
			pstmt.setString(4, trainer.getGender());
			pstmt.setString(5, trainer.getRegion());
			pstmt.setString(6, trainer.getPokemon1());
			pstmt.setString(7, trainer.getPokemon2());
			pstmt.setString(8, trainer.getPokemon3());
			pstmt.setString(9, trainer.getPokemon4());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	

	// 특정한 id인 Trainer 삭제
	public static boolean deleteTrainer(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from trainer where id =? ");
			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ID로 해당 Trainer의 모든 정보 반환
	public static TrainerDTO getTrainer(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TrainerDTO doctor = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from trainer where id =?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				doctor = new TrainerDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return doctor;
	}
}
