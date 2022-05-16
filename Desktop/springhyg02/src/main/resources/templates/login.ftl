<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登陆页面</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	</head>
	
	
	<body>
	 
	    <div class="container">
			<img src="images/rl_top.35edfde.png"/>
		<form action="" method="post">
			<div class="form-group">
				<label>用户名</label>
				<input name="username" class="form-control">
			
			</div>
			<div class="form-group">
				<label>密码</label>
				<input name="password" class="form-control">
				<small>${msg}</small>
			</div>
			<button type="submit" class="btn btn-info">登录</button>
			<a href="register.html">注册</a>
			
			</form>	
	      
		</div>
	</body>
	<script src="js/index.js"></script>
</html>