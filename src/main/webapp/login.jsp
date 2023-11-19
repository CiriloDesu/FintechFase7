<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="br.com.fiap.fintech2.bean.Alert" %>
<!DOCTYPE html>
<html>
	<head>
		<!--<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.css" >
		 <link rel="stylesheet" href="css/login.css" >
		<link rel="stylesheet" href="css/input.css" > -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/bootstrap.css" >
  <link rel="stylesheet" type="text/css" href="css/login_style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>  
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'> 
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
		
		<title>LOGIN</title>
	</head>
	<body class="body">
	
<div class="login-page">
  <div class="form">

    <form method="POST"  action="LoginServlet">
      <lottie-player src="https://assets4.lottiefiles.com/datafiles/XRVoUu3IX4sGWtiC3MPpFnJvZNq7lVWDCa8LSqgS/profile.json"  background="transparent"  speed="1"  style="justify-content: center;" loop  autoplay></lottie-player>
      <input type="text" name="nmUser" class="form-control" id="email" placeholder="&#xf007;  Usuário" required aria-label="Username" aria-describedby="addon-wrapping" >
      <input type="password" name="passUser" class="form-control" id='password' placeholder="&#xf023;  Senha" required aria-label="Password" aria-describedby="addon-wrapping" >
      <i class="fas fa-eye" onclick="show()"></i> 
      <br>
      <br>
      <button>LOGIN</button>
      <p class="message"></p>
    </form>

    <form class="login-form">
      <button type="button" onclick="window.location.href='signup.jsp'">SIGN UP</button>
    </form>
  </div>
</div>

  <script>
    function show(){
      var password = document.getElementById("password");
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
			<%-- Verifica se há uma mensagem e a exibe --%>
        <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3">
    <% if (request.getAttribute("message") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= request.getAttribute("message") %>
        </div>
    <% } %>
</div>
		</div>


	</body>
</html>