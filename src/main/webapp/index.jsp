<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/index2.css">
  	<link rel="stylesheet" type="text/css" href="css/login_style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;1,400&display=swap" rel="stylesheet">
</head>
<body class="body">
<header>
<jsp:include page='menu.jsp'/>
</header>
    <main id="conteudo" class="mt-5 mb-5">
        <div class="d-flex justify-content-center">
           
                <div class="d-flex flex-column align-items-center">
                    <img alt="user-avatar" class="img-thumbnail rounded rounded-circle" src="${currentUser.urlAvatar}">
                    <h3 class="h3 text-white text-capitalize">${currentUser.nmUser}</h3>
                </div> 
        </div>


        <!--<div class="info mt-5" id="conteudo">
            <table class="table table-bordered rounded-top">
                <thead>
                    <tr>
                        <td colspan="2" style="text-align:center;">DADOS</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>${currentUser.idUser}</td>
                    </tr>
                    <tr>
                        <td>NOME</td>
                        <td>${currentUser.nome}</td>
                    </tr>
                    <tr>
                        <td>USERNAME</td>
                        <td>${currentUser.nmUser}</td>
                    </tr>
                   
                </tbody>
            </table>
            </div>-->
            <div class="table-wrapper">
    <table class="fl-table h3">
        <thead>
        <tr>
            <th>Seu ID</th>
            <th>Nome</th>
            <th>Nome de Usuário</th>
        </tr>
        </thead>
        <tbody >
        <tr class="tamanho">
            <td>${currentUser.idUser}</td>
            <td>${currentUser.nome}</td>
            <td>${currentUser.nmUser}</td>
        </tr>
        <tbody>
    </table>
            </div>
            </main>
<jsp:include page="modal.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="bootstrap/js/messages.js"></script>
</body>
</html>