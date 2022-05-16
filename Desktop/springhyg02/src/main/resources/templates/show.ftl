<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会员购</title>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<form action="/SelecByName" class="form-inline">
		<div class="form-group mx-sm-3 mb-2">
			<label for="name" class="sr-only">搜索商品</label>
			<input name="name" class="form-control" id="name" placeholder="请输入商品名称">
		</div>
		<button type="submit" class="btn btn-primary mb-2">搜索</button>
	</form>

	<#list tlist as t>
		<a href="select?typesId=${t.id}" class="btn btn-link">${t.name}</a>
	</#list>
	<p>
		<a href="/select?isDesc=0">价格从低到高</a>
		<a href="/select?isDesc=1">价格从高到低</a>

	</p>

	<div class="row">
		<#list glist as g>
			<div class="col-md-3" style="margin-top: 30px">
				<div class="card">
					<img src="${g.imgsrc}" class="card-img-top">
					<div class="card-body">
						<div class="card-text">${g.name}</div>
						<h4 class="card-title" style="color:#fb7299">价格${g.price}</h4>

					</div>
				</div>

			</div>
		</#list>
	</div>
	<a href="/select?topage=${page-1}">上一页</a>
	当前${page}页
	<a href="/select?topage=${page+1}">下一页</a>
	</div>
</body>
</html>