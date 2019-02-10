package pokemon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pokemon.model.dto.PokemonDTO;
import pokemon.model.util.DBUtil;

public class PokemonDAO {

	// 모든 Pokemon 정보 반환
	public static ArrayList<PokemonDTO> getAllPokemon() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PokemonDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from pokemon");
			rset = pstmt.executeQuery();
			all = new ArrayList<PokemonDTO>();

			while (rset.next()) {
				all.add(new PokemonDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}

	// ID로 해당 Pokemon의 모든 정보 반환
	public static PokemonDTO getPokemon(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PokemonDTO pokemon = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from pokemon where id =?");
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				pokemon = new PokemonDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return pokemon;
	}
}
