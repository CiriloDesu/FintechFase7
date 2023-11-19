package br.com.fiap.fintech2.servlets;

import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.dao.UsuarioDAO;
import br.com.fiap.fintech2.factory.ConnectionFactory;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("NOME");
        String username = request.getParameter("NM_USER");
        String senha = request.getParameter("PASS_USER");
        String urlAvatar = request.getParameter("URL_AVATAR");

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.abrirBanco();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario novoUsuario = new Usuario(0, nome, username, senha, urlAvatar);

        try {
            int resultadoCadastro = usuarioDAO.insert(novoUsuario);

            if (resultadoCadastro == 0) {
                // Usuário já cadastrado
                request.setAttribute("message-error", "Username já está em uso.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else if (resultadoCadastro > 0) {
                // Cadastro realizado com sucesso
                request.setAttribute("message", "Cadastro realizado com sucesso!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else {
                // Erro no cadastro
                request.setAttribute("message-error", "Erro no cadastro. Verifique os dados e tente novamente.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro no cadastro: " + e.getMessage());
        } finally {
            connectionFactory.fecharBanco();
        }
    }
}
