<%@page import="br.com.fiap.fintech2.bean.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <title>Excluir despesa</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index2.css">
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
      <br>
      <br>
      <button>EXCLUIR</button>
      <p class="message"></p>
    </form>

  </div>
</div>
         
    </form>
    <jsp:include page="footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="bootstrap/js/messages.js"></script>
</body>
</html>
