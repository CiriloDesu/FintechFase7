<%@page import="br.com.fiap.fintech2.model.Despesa2"%>
<%@page import="br.com.fiap.fintech2.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %> <!-- Importe a classe HttpSession -->
<%@ page import="br.com.fiap.fintech2.bean.Usuario" %> <!-- Importe a classe Usuario -->
<%@ page import="br.com.fiap.fintech2.dao.Despesa2DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index2.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">
    
    

<title></title>
</head>
<body>



<%
    Despesa2DAO despesa2DAO = new Despesa2DAO();
    HttpSession sessionObj = request.getSession(); // Renomeie a variável para evitar conflito
    Usuario usuario = (Usuario) sessionObj.getAttribute("currentUser");
    int idUser = (usuario != null) ? usuario.getIdUser() : -1; // Defina um valor padrão ou trate de acordo com sua lógica

    List<Despesa2> despesas = despesa2DAO.getDespesas2(idUser);
%>

<div class="form2">
<div class="fluid">
  <div class="row justify-content-center">
    <div class="col-lg-9 ">
      <form method="POST" action='processaDespesa2' name="frmAddDespesa2" role="form">
        <div class="row g-3">
          <div class="col-md-6">
            <label for="nomeDespesa2" class="form-label">Nome da Despesa</label>
            <input type="text" class="form-control" maxlength="20"   id="nomeDespesa2" required  name="nomeDespesa2" value="<c:out value="${despesa2.nomeDespesa2}" />">
          </div>
          <div class="col-md-6">
            <label for="vlDespesa2" class="form-label">Valor da despesa</label>
            <input type="text" class="form-control" maxlength="20" id="vlDespesa2" required type="text" name="vlDespesa2" value="<c:out value="${despesa2.vlDespesa2}" />">
          </div>
          <div class="col-md-6">
            <label for="dsDespesa2" class="form-label">Descrição da Despesa</label>
            <input type="text" class="form-control" maxlength="20" id="dsDespesa2" required type="text" name="dsDespesa2" value="<c:out value="${despesa2.dsDespesa2}" />">
          </div>
          <div class="col-12">
            <div class="row mt-2">
              <div class="col-md-6">
                <button type="submit" value="Incluir" class="btn btn-dark w-100 fw-bold" >Cadastrar</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</div>
</body>
</html>