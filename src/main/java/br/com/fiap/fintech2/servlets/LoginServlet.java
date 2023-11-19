package br.com.fiap.fintech2.servlets;

import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.bo.UsuarioBO;
import br.com.fiap.fintech2.dao.Despesa2DAO;
import br.com.fiap.fintech2.dao.UsuarioDAO;
import br.com.fiap.fintech2.model.Despesa2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nmUser = request.getParameter("nmUser");
        String passUser = request.getParameter("passUser");

        HttpSession session = request.getSession();
        Usuario usuario = null;
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.selectByUsername(nmUser);

            if (usuario != null && usuario.getPassUser().equals(passUser)) {
                Despesa2DAO despesa2DAO = new Despesa2DAO();
                List<Despesa2> despesasUsuario = despesa2DAO.getDespesasUsuario(usuario.getIdUser());
                request.setAttribute("despesasUsuario", despesasUsuario);

                // idficador
                session.setAttribute("ID_USER", usuario.getIdUser());  
                System.out.println("ID do usuário logado: " + usuario.getIdUser());

                session.setAttribute("currentUser", usuario); 

                // Redirecione o usuário para a página inicial ou onde quer que você queira
                response.sendRedirect("index.jsp");
            } else {
                // Usuário não encontrado ou senha incorreta
                request.setAttribute("message", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Invalid username or password");
        }
    }


}