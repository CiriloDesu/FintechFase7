<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/index2.css">
	<link rel="stylesheet" type="text/css" href="css/modal.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;1,400&display=swap" rel="stylesheet">
</head>
<body>
   
  
            <!-- botões para nova despesa e editar despesas aqui -->
             <div class="form2">
            <div id="botoes" class="col-10 offset-1 d-flex justify-content-around p-2 fluid">
                <button type="button" id="botoes" class="button" data-toggle="modal" data-target="#novaDespesaModalCentralizado">NOVA DESPESA</button>
                <!--<a href="/Fintech2/listar.jsp" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">LISTAR DESPESAS</a>-->
                <!-- Botão para acionar modal -->
				<button type="button" id="botoes" class="button2 bg-secondary" data-toggle="modal" data-target="#listerModalCentralizado">LISTA DESPESAS</button>
                <!--<button id="listarDespesas" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> LISTAR DESPESAS</button>-->
            </div>
             </div>
   
    </main>



<!-- Modal -->
<div class="modal fade" id="novaDespesaModalCentralizado" tabindex="-1" role="dialog" aria-labelledby="novaDespesaModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title text-center" id="novaDespesaModalCentralizado">Cadastrar nova despesa</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <jsp:include page='incluir.jsp'/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>



<!-- Modal -->
<div class="modal fade" id="listerModalCentralizado" tabindex="-1" role="dialog" aria-labelledby="listerModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="listerModalCentralizado">Lista despesas</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body d-flex justify-content-center">
        <jsp:include page='listar.jsp'/>
      </div>
      
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
  </div>
</div>


</body>
</html>