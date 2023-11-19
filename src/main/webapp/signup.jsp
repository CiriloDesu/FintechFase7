<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.fiap.fintech2.bean.Alert" %>
    
    
<!DOCTYPE html>
<html>
    <head>
        <!--  <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <link rel="stylesheet" href="css/logup.css" >
        <link rel="stylesheet" href="css/input.css" >
        <title>CADASTRO</title>-->
	  <link rel="stylesheet" href="css/bootstrap.css">
	  <title>CADASTRO</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta charset="utf-8" />
      <link rel="stylesheet" type="text/css" href="css/signup_style.css" />
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
      <link
        href="https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600"
        rel="stylesheet"
        type="text/css"/>
      <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
    </head>
    <body>
        


   <div class="login-page">
        <div >
        	<form action="signup" method="post" class="form">
        	
            <lottie-player src="https://assets4.lottiefiles.com/datafiles/XRVoUu3IX4sGWtiC3MPpFnJvZNq7lVWDCa8LSqgS/profile.json" background="transparent" speed="1" style="justify-content: center"loop autoplay></lottie-player>
            <input type="text" class="form-control" name="NOME" id="nome" placeholder="Nome" required>
            <input type="text" class="form-control" name="NM_USER" id="username" placeholder="Usuário" minlength="4" required>
       		<input type="text" class="form-control" name="URL_AVATAR" id="url-avatar" placeholder="https://exemplo.com/imagem.jpg">
            <input type="password" class="form-control" name="PASS_USER" id="senha" placeholder="Senha" minlength="8" required>
            <i class="fas fa-eye" onclick="show()"></i>
            <br>
            <br>
           <div class="message">
			    <% Object messageAttribute = request.getAttribute("message");
			       if (messageAttribute != null) { %>
			        <div class="alert alert-success" role="alert">
			            <%= messageAttribute %>
			        </div>
			    <% } %>
			
			    <% Object messageErrorAttribute = request.getAttribute("message-error");
			       if (messageErrorAttribute != null) { %>
			        <div class="alert alert-danger" role="alert">
			            <%= messageErrorAttribute %>
			        </div>
			    <% } %>
			</div>
            <button type="submit">CADASTRAR</button>
           	<button type="button" onclick="window.location.href='login.jsp';">VOLTAR</button>
            
          </form>
          
        </div>
      </div>

<%-- Verifica se há uma mensagem e a exibe --%>
        
        
        
        
        <script>
    function show(){
      var password = document.getElementById("senha");
      var icon = document.querySelector(".fas")

      // ========== Checking type of password ===========
      if(password.type === "password"){
        password.type = "text";
      }
      else {
        password.type = "password";
      }
    };
  </script>	
      </body>
</html>