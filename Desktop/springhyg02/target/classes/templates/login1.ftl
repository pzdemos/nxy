<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>pz的注册登录页面</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.min.css">


    <link rel="stylesheet" href="css/login.css">


</head>

<body>

<div style="text-align:center;clear:both">
    <script src="js/gg_bd_ad_720x90.js" type="text/javascript"></script>
    <script src="js/follow.js" type="text/javascript"></script>
</div>

<div class="form">

    <ul class="tab-group">

        <li class="tab"><a href="#login">Log In</a></li>
    </ul>




    <div id="login">
        <h1>Welcome Back!</h1>

        <form action="/DoLogin" method="post">

            <div class="field-wrap">
                <label>
                    username<span class="req">*</span>
                </label>
                <input name="username" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Password<span class="req">*</span>
                </label>
                <input name="password" required autocomplete="off"/>
            </div>
            <small>${msg}</small>

            <p class="forgot"><a href="register.html">Forgot Password?</a></p>

            <button type="submit"  class="button button-block"/>Log In</button>

        </form>

    </div>

</div><!-- tab-content -->

</div> <!-- /form -->
<script src='js/jquery.min.js'></script>

<script  src="js/index.js"></script>

</body>
</html>
