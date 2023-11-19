package br.com.fiap.fintech2.bo;

import java.sql.SQLException;

import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.dao.UsuarioDAO;

public class UsuarioBO {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario login(Usuario u) {
        return dao.select(u);
    }

    public int cadastrar(Usuario u) throws SQLException {
        if (u.getNome() == null || u.getNome().isEmpty()) {
            return -1;
        }

        if (u.getNmUser() == null || u.getNmUser().isEmpty()) {
            return -2;
        }

        if (u.getPassUser() == null || u.getPassUser().isEmpty()) {
            return -3;
        }

        if (u.getUrlAvatar() == null || u.getUrlAvatar().isEmpty()) {
            return -4;
        }

        if (buscarUsuarioPeloUsername(u.getNmUser()) != null) {
            return 0;
        }

        return dao.insert(u);
    }

    public Usuario buscarUsuarioPeloUsername(String username) {
        if (username == null) {
            return null;
        }
        return dao.selectByUsername(username);
    }
}
