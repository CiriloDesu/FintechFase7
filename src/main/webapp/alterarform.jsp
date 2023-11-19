<%@page import="br.com.fiap.fintech2.bean.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Expense</title>
	<link rel="stylesheet" type="text/css" href="css/login_style.css">
    
</head>
<body class="body">
<header>
<jsp:include page='menu.jsp'/>
</header>    
    <%
        // Verifica se há uma mensagem de alerta na sessão
        Alert alert = (Alert) session.getAttribute("alert");
        if (alert != null) {
    %>
        <div style="color: <%= alert.getType() %>;">
            <%= alert.getMessage() %>
        </div>
    <%
            // Limpa a mensagem de alerta da sessão
            session.removeAttribute("alert");
        }
    %>
        <div class="login-page">
  <div class="form">

    <form method="GET"  action="deletarDespesa2">
      <label for="id">ID da Despesa:</label>
        <input type="text" name="id" value="<%= request.getParameter("id") %>" required><br>
        
        <label for="nome">Nome:</label>
        <input type="text" name="nome" value="<%= request.getParameter("nome") %>" required><br>
        
        <label for="valor">Valor:</label>
        <input type="text" name="valor" value="<%= request.getParameter("valor") %>" required><br>
        
        <label for="descricao">Descrição:</label>
        <input type="text" name="descricao" value="<%= request.getParameter("descricao") %>" required><br>
        
         <button type="submit">ATUALIZAR</button>
      <br>
      <br>
      <p class="message"></p>
    </form>

  </div>
</div>
</body>
</html>
