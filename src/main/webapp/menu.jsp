<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.fiap.fintech2.dao.Despesa2DAO"%>
<%@page import="br.com.fiap.fintech2.model.Despesa2"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/menu.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;1,400&display=swap" rel="stylesheet">
    
    
    
</head>
<body>
     <header class="text-black">
              <nav class="navbar navbar-expand-lg navbar-light bg-light navfoco">
          <a class="navbar-brand" href="index.jsp">
              <img src="${currentUser.urlAvatar}" width="30" height="30" class="d-inline-block align-top rounded text-capitalize" alt="">
              <span class="text-capitalize">${currentUser.nmUser}</span>
            </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
      
          <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link text-primary" href="index.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-dark" href="alterar.jsp">Alterar Despesa</a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-dark" href="excluir.jsp">Excluir Despesa</a>
              </li>
            </ul>
            
              <button class="btn btn-danger my-2 my-sm-0" type="submit"><a class="nav-link text-white" href="logout">
                  LOGOUT
              </a></button>
          </div>
        </nav>
    </header>
</body>
</html>
