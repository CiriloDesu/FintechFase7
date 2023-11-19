<%@page import="br.com.fiap.fintech2.bean.Usuario"%>
<%@ page import="br.com.fiap.fintech2.dao.Despesa2DAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="br.com.fiap.fintech2.model.Despesa2" %>
<%@ page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <title>Lista de Despesas</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index2.css">


    <!-- Latest compiled and minified CSS -->

    <!-- Remova o link para Bootstrap 3 -->
    <!-- <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> -->
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<jsp:include page='menu.jsp'/>
<body id="conteudo">
    <div class="alert msg" role="alert">${message}</div>
<div class="container">
        
    <%-- Mais conteúdo da página aqui --%>
    
        <div class="row text-white">
            <div class="col-sm-10 offset-sm-1">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Valor</th>
                            <th>Descrição</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        try {
                            // Obtém o usuário da sessão
                            HttpSession sessionObj = request.getSession(); // Renomeie a variável para evitar duplicatas
                            Usuario usuario = (Usuario) sessionObj.getAttribute("currentUser");

        // Verifica se o usuário está logado antes de acessar as despesas
        if (usuario != null) {
            int idUser = usuario.getIdUser();
            Despesa2DAO despesa2DAO = new Despesa2DAO();
            ArrayList<Despesa2> despesas2 = despesa2DAO.getDespesas2(idUser);

            for (Despesa2 despesa2 : despesas2) {
%>

    <tr>
        <td><%= despesa2.getId_despesa2() %></td>
        <td><%= despesa2.getNome_despesa2() %></td>
        <td><%= despesa2.getVl_despesa2() %></td>
        <td><%= despesa2.getDs_despesa2() %></td>
    </tr>




<%
            }
        } else {
%>
<!-- Seu código para lidar com o usuário não autenticado -->
<tr>
    <td colspan="7">Erro: Usuário não autenticado</td>
</tr>
<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
%>
<!-- Seu código para lidar com erros -->
<tr>
    <td colspan="7">Erro ao recuperar despesas: <%= e.getMessage() %></td>
</tr>
<%
    }
%>

</tbody>
</table>
</div>
 </div>
</div>
    <script>
    function editarDespesa(id, nome, valor, descricao) {
        window.location.href = 'alterarform.jsp?id=' + id +
            '&nome=' + encodeURIComponent(nome) +
            '&valor=' + encodeURIComponent(valor) +
            '&descricao=' + encodeURIComponent(descricao);
    }

    function excluirDespesa(id) {
        window.location.href = 'excluirform.jsp?id=' + id;
    }
</script>

</body>
</html>
