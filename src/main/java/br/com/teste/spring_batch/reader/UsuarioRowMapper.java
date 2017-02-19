package br.com.teste.spring_batch.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.teste.spring_batch.model.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setCodigo(rs.getInt("id_usuario"));
		usuario.setNome(rs.getString("nom_usuario"));
		usuario.setEmail(rs.getString("des_email"));
		
		return usuario;
		
	}

}
