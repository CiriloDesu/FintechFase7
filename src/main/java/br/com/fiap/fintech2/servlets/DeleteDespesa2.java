package br.com.fiap.fintech2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech2.bean.Alert;
import br.com.fiap.fintech2.bean.Usuario;
import br.com.fiap.fintech2.dao.Despesa2DAO;
import br.com.fiap.fintech2.model.Despesa2;

@WebServlet("")
public class DeleteDespesa2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            Despesa2DAO despesa2DAO = new Despesa2DAO();
            Despesa2 despesa2 = new Despesa2();
            despesa2.setId_despesa2(Integer.parseInt(id));

            // Obtenha o id_user do usuário logado a partir da sessão
            int id_user = (request.getSession().getAttribute("ID_USER") != null) ? ((Integer) request.getSession().getAttribute("ID_USER")).intValue() : 0;

            // verifica iduser a despesa
            boolean sucessoExcluir = despesa2DAO.deletarDespesa2(despesa2, id_user);
            Usuario usuario = (Usuario) session.getAttribute("currentUser");
            if (usuario != null) {
                session.setAttribute("ID_USER", usuario.getIdUser());
            } else {
            	Alert alert = new Alert("Realizar login", "info"); // supondo que "info" seja um tipo válido de alerta
            	session.setAttribute("alert", alert);
            	response.sendRedirect("login.jsp");
            }


            if (sucessoExcluir) {

                // Redirecioma para listar.jsp com uma mensagem de sucesso
                response.sendRedirect("listar.jsp?success=true");
            } else {

                // Redireciona para listar.jsp com uma mensagem de erro
                response.sendRedirect("listar.jsp?error=ID não encontrado");
            }
    }
}
}