<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/j_spring_security_check" var="loginUrl" />
<title>Bem-vindo(a) ao MakersWeb - Entrar!</title>
<div id="form-container">
	<div class="login_box" id="form-box">
		<img class="login_logo" alt="[Makersweb]" title="Makersweb" src="../_cdn/img/helpeo_icon.png" />
		<form class="login_form ajax_off" name="work_login" action="${loginUrl}" method="post">
			
			<div class="form-group">
				<label class="sr-only" for="email">E-mail</label>
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-envelope"></span>
					</div>
					<input type="email" name="email" class="form-control" placeholder="Informe seu e-mail" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="sr-only" for="senha">Senha</label>
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</div>
					<input type="password" name="senha" class="form-control" placeholder="Informe sua senha" />
				</div>
			</div>
			
			<div class="form-group">
				<button class="btn btn-success form-control">Entrar</button>
            </div>
            
            <div class="form-group">
            	Não é registrado? <a href="cadastro.html">Crie uma conta</a>.
            </div>
		</form>
	</div>
</div>