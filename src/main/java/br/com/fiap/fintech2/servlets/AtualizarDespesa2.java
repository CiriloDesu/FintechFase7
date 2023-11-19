package br.com.fiap.fintech2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.dao.Despesa2DAO;
import br.com.fiap.fintech2.model.Despesa2;

@WebServlet("/atualizarDespesa2")
public class AtualizarDespesa2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("currentUser");
        System.out.println("Iniciando AtualizarDespesa2.doPost");

        // Verifique se o usuário está autenticado
        if (usuario != null) {
            int idUser = usuario.getIdUser();

            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String descricao = request.getParameter("descricao");
            System.out.println("ID do usuário logado em AtualizarDespesa2: " + idUser);

            Despesa2DAO despesa2DAO = new Despesa2DAO();
            Despesa2 despesa2 = new Despesa2();
            despesa2.setIdUser(idUser);
            despesa2.setId_despesa2(Integer.parseInt(id));
            despesa2.setNome_despesa2(nome);
            despesa2.setVl_despesa2(valor);
            despesa2.setDs_despesa2(descricao);

            despesa2DAO.alterarDespesa2(despesa2, idUser);

            response.sendRedirect("index.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erro ao processar a despesa: Usuário não autenticado");
        }
    }
}

