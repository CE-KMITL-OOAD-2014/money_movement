<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detail signup</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap-3.2.0-dist/css/adddetail.css" rel="stylesheet">
	<link href="bootstrap-3.2.0-dist/css/customer.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="bd-bg">
	
    <div class="row container-div">
		<div class="col-md-6 col-md-offset-3 bg-aside">
			<div class="border-pro"><h3>Info</h3></div>
			<form action="register" method="post" role="form" class="float-con">
				<!--<div class="form-group">
					<label for="InputUsername">User name</label>
					<input type="text" class="form-control" id="exampleInputUsername" placeholder="User name">
				</div>-->
				<div class="form-group">
					<label for="Name">Name</label>
					<input type="text" class="form-control" id="exampleInputName" name="name" placeholder="Name">
				</div>
				<!--<div class="form-group">
					<label for="InputLastname">Last name</label>
					<input type="text" class="form-control" id="exampleInputLastname" placeholder="Last name">
				</div>-->
				<div class="form-inline">
				<div class="form-group">
					<label for="InputAge" class="float-right">Age</label>
					<input type="text" class="form-control width-ch" name="age" id="Age">
				</div>		
				<div class="form-group">
					<label for="InputBrithday" class="float-right">Birthday</label>
					<input type="date" class="form-control" name="birthDay"  id="Birthday">
				</div>
				</div>
				<div class="form-group">
					<label for="InputSex" class="float-right">Sex</label>
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="male" value="male"><b> male</b>
					</label>
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="female" value="female"><b> female</b>
					</label>
				</div>
				
				<div class="form-group">
					<label for="InputJob">Job</label>
					<input type="text" class="form-control" name="job" id="exampleInputJob" placeholder="e.g. engineer,doctor,officer">
				</div>
				<div class="form-group">
					<label for="InputProvince">Province</label>
					<input type="text" class="form-control" id="Province" name="province" placeholder="Province at your live">
				
				</div>
				<!--<div class="form-group">
					<label for="InputEmail1">Email address</label>
					<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="InputPassword1">Password</label>
					<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
				</div>
				<div class="form-group">
					<label for="InputConfirmpassword">Confirm Password</label>
					<input type="password" class="form-control" id="exampleInputConfirmpassword1" placeholder="Confirm Password">
				</div>-->
				<div>
					
					<input type="hidden" name="username" value=<%out.print(request.getParameter("username")); %>>
					<input type="hidden" name="email" value=<%out.print(request.getParameter("email")); %>>
					<input type="hidden" name="password" value=<%out.print(request.getParameter("password")); %>>		
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="submit" href="#" class="btn btn-primary">finish</button>
				</div>
			</form>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
  </body>
</html>