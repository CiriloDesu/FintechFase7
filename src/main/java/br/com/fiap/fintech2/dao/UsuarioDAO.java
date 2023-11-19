package br.com.fiap.fintech2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.factory.ConnectionFactory;

public class UsuarioDAO extends ConnectionFactory {

	public int insert(Usuario usuario) throws SQLException {
        int res = 0;
      
        if (isUsernameExists(usuario.getNmUser())) {
            return 0; // Retorna 0 para indicar que o usuário já existe
        }
        try {
            abrirBanco();
            String sql = "INSERT INTO TBL_LOGIN (ID_USER, NOME, NM_USER, PASS_USER, URL_AVATAR) VALUES (SEQ_LOGIN.NEXTVAL, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getNmUser());
            stmt.setString(3, usuario.getPassUser());
            stmt.setString(4, usuario.getUrlAvatar());

            res = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir o usuário: ");
            e.printStackTrace();
        } finally {
            fecharBanco();
        }
        return res;
    }
	
	 private boolean isUsernameExists(String username) throws SQLException {
	        try {
	            abrirBanco();
	            String sql = "SELECT COUNT(*) FROM TBL_LOGIN WHERE NM_USER = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);

	            ResultSet rs = stmt.executeQuery();
	            rs.next();

	            int count = rs.getInt(1);

	            return count > 0; // Retorna true se o nome de usuário existir, false caso contrário

	        } catch (SQLException e) {
	            System.out.println("Erro ao verificar se o nome de usuário já existe: ");
	            e.printStackTrace();
	        } finally {
	            fecharBanco();
	        }

	        return false; // Em caso de erro, assume que o nome de usuário não existe
	    }

    public Usuario selectByUsername(String username) {
        Usuario usuario = null;
        try {
            abrirBanco();
            String sql = "SELECT * FROM TBL_LOGIN WHERE NM_USER = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUser(rs.getInt("ID_USER")); // Mudado de 'setId' para 'setIdUser'
                usuario.setNome(rs.getString("NOME"));
                usuario.setNmUser(rs.getString("NM_USER")); // Mudado de 'setNomeUser' para 'setNmUser'
                usuario.setPassUser(rs.getString("PASS_USER"));
                usuario.setUrlAvatar(rs.getString("URL_AVATAR"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o usuário por username: ");
            e.printStackTrace();
        } finally {
            fecharBanco();
        }
        return usuario;
    }

    public Usuario select(Usuario user) {
        Usuario usuario = null;
        try {
            abrirBanco();
            String sql = "SELECT * FROM TBL_LOGIN WHERE NM_USER = ? AND PASS_USER = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getNmUser()); // Mudado de 'getNomeUser' para 'getNmUser'
            stmt.setString(2, user.getPassUser());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUser(rs.getInt("ID_USER")); // Mudado de 'setId' para 'setIdUser'
                usuario.setNome(rs.getString("NOME"));
                usuario.setNmUser(rs.getString("NM_USER")); // Mudado de 'setNomeUser' para 'setNmUser'
                usuario.setPassUser(rs.getString("PASS_USER"));
                usuario.setUrlAvatar(rs.getString("URL_AVATAR"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o usuário por nome e senha: ");
            e.printStackTrace();
        } finally {
            fecharBanco();
        }
        return usuario;
    }
}