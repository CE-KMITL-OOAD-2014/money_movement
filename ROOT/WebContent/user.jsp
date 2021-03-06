<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Name User</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap-3.2.0-dist/css/customer.css" rel="stylesheet">
	<link href="bootstrap-3.2.0-dist/css/adddetail.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="bd-bg">
  
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<div class="navbar-header">
					<!--<button type="button" class="nevbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">-->
					<a class="navbar-brand" href="#">Name User</a>
					</div>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-list"></span><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">Policy</li>
							<li><a href="#">private</a></li>
							<li><a href="#">change</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">user</li>
							<li><a href="#">configure</a></li>
							<li><a href="index.html">sign out</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
		<!--Code side left -->
			<div class="col-md-2 col-xs-4" >
				<div class="groupline">
					<div class="image-size">
						<a href="#"><img src="bootstrap-3.2.0-dist/image/pic.jpg" alt="..." class="img-rounded image-size" ></a>
					</div>
					<div class="list-inlines">
						<a class="text-color" href="display.html">Passakorn <br>Jonlapon</a><br>
						<a href="#" id="test1">Edit Profile</a>	
					</div>
				</div>
				<div class="float-div ">
					<ul class="nav nav-pills nav-stacked" >
						<li id="test">
							<a href="#"><span class="badge pull-right">42</span>Analysis</a>
						</li>
						<li id="test">
							<a href="#">
								<span class="badge pull-right">42</span>Compare</a>
						</li>
						<li id="test" ><a href="#"><span class="badge pull-right">42</span>total</a>
						</li>
					</ul>
				</div>
			</div>
			<!--Code side right -->
			<div class="col-md-10 col-xs-10" >
				<div class="bg-aside">
					<div class="float-bt">
						<div class="button-space">
							<button class="btn btn-primary btn-lg col-md-2 col-xs-2 col-md-offset-2 col-xs-offset-2">ADD</button>
						</div>
						<div class="button-space">
							<button class="btn btn-primary btn-lg col-md-2 col-xs-2 col-md-offset-1 col-xs-offset-1">EDIT</button>
						</div>
						<div class="button-space">
							<button class="btn btn-primary btn-lg col-md-2 col-xs-2 col-md-offset-1 col-xs-offset-1">REMOVE</button>
						</div>
					</div>
					<div class="float-div">
						<form class="form-inline" role="form">
							<div class="form-group">
								<input type="date" class="form-control" id="exampleInputBirthday">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="exampleInputList" placeholder="list">
							</div>
							<div class="form-group">
								<input class="form-control" type="text" id="exampleInputTypeList" placeholder="TypeList">	
							</div>
							<div class="form-group">
								<select class="form-control" name="style">
									<option selected="selected" value="hight">Hight</option>
									<option value="middle">Middle</option>
									<option value="little">Little</option>
								</select>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input class="form-control" id="exampleInputAmount" placeholder="Amount">
								</div>
							</div>
							<span type="submit" id="set" class="glyphicon glyphicon-ok symbol-space"></span>
							<span type="button" id="reset" class="glyphicon glyphicon-remove symbol-space"></span>
						</form>
					</div>
					<div class="float-div ">
						<div class="progress col-md-10 col-md-offset-1" >
							<div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
								<span class="sr-only">20% Complete</span>
							</div>
						</div>
					</div>
				</div>	
			
				
				<div class="bg-aside float-div">
					<ul class="nav nav-tabs" role="tablist" id="myTab">
						<li class="active"><a href="#timeline" role="tab" data-toggle="tab">Timeline</a></li>
						<li><a href="#pie" role="tab" data-toggle="tab">Pie Graph</a></li>
						<li><a href="#linear" role="tab" data-toggle="tab">Linear Graph</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="timeline">
							<div class="bg-content">
								<table class="table">
									<tr>
										<th>date</th>
										<th>list</th>
										<th>type</th>
										<th>group</th>
										<th>amount</th>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
									<tr>
										<td>27/09/2557</td>
										<td>mama</td>
										<td>food</td>
										<td>middle</td>
										<td>2700</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="tab-pane" id="pie">
							<!--<img src="image/pic1.gif" alt="..." class="img-rounded" >-->
						</div>
						<div class="tab-pane" id="linear">
							<!--<img src="image/pic2.png" alt="..." class="img-rounded" >-->
						</div>			
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--Content web
	<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
		<div class="container">
			<div class="navbar-text pull-left">
				<p>�By Passakorn</p>
			</div>
		</div>
	</nav>-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
<!--<<<<<< HEAD:ROOT/bootstrap-3.2.0-dist/user.html-->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="bootstrap-3.2.0-dist/js/myscript.js"></script>
<!--=======-->
    <script src="bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
	<script src="bootstrap-3.2.0-dist/js/jquery-2.1.1.min.js"></script>
<!-->>>>>>> origin/master:ROOT/WebContent/user.html-->
	
  </body>
</html>