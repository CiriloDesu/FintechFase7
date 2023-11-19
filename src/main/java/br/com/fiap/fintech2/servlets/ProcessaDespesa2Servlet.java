package br.com.fiap.fintech2.servlets;

import br.com.fiap.fintech2.dao.Despesa2DAO;
import br.com.fiap.fintech2.model.Despesa2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/processaDespesa2")
public class ProcessaDespesa2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Recupera o ID do usuário da sessão
        Integer userIdInteger = (Integer) session.getAttribute("ID_USER");
        int idUser = (userIdInteger != null) ? userIdInteger.intValue() : 0;
        
        String nomeDespesa2 = request.getParameter("nomeDespesa2");
        String vlDespesa2 = request.getParameter("vlDespesa2");
        String dsDespesa2 = request.getParameter("dsDespesa2");

        Despesa2DAO despesa2DAO = new Despesa2DAO();

        Despesa2 novaDespesa2 = new Despesa2();
        
        // Define o ID do usuário na nova despesa
        novaDespesa2.setIdUser(idUser);
        
        novaDespesa2.setNome_despesa2(nomeDespesa2);
        novaDespesa2.setVl_despesa2(vlDespesa2);
        novaDespesa2.setDs_despesa2(dsDespesa2);
        
        try {
            despesa2DAO.inserirDespesa2(novaDespesa2);
            List<Despesa2> despesas2Atualizadas = despesa2DAO.getDespesas2(idUser);
            request.setAttribute("despesas2", despesas2Atualizadas);
            response.sendRedirect("alterar.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a despesa: " + e.getMessage());
        }
    }
}
