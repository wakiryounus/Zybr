<html>
<head>
	<title>Login</title>
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
        <div class="row ">
			<div class="col-md-5 mx-auto border p-3">
			<div id="first">
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Login</h1>
						 </div>
					</div>
                   <form action="login1" name="login">
                           <div class="form-group">
                              <label>Email address</label>
                              <input type="email" name="email"  class="form-control"  placeholder="Enter email">
                           </div>
                           <div class="form-group">
                              <label>Password</label>
                              <input type="password" name="password"  class="form-control" placeholder="Enter Password">
                          		 
                           </div>         
                           <div class="form-group">
                              <p class="text-right"><a href="forgotPassword.jsp">Forgot Password?</a></p>
                           </div>             		
                           <div class="form-group">
                              <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                           </div>
                           <div class="col-md-12 text-center ">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                           </div>
                           <div class="form-group mt-3">
                              <p class="text-center">Don't have account? <a href="SignUp.jsp" id="signup">Sign up here</a></p>
                           </div>
                        </form>
                 
				</div>
			</div>
			</div>
		</div>
      </div> 

<script type="text/javascript" src="bootstrap/all.js"></script>
<script type="text/javascript" src="bootstrap/JQuery.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>
