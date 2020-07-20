<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head id="Head1">
<%@ include file="/web/common/common.jsp"%>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hosting Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<%=__APP__ %>/bs/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=__APP__ %>/bs/js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="<%=__APP__ %>/bs/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!-- webfonts -->
<link href='http://fonts.useso.com/css?family=Open+Sans:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!-- webfonts -->


<title>微课堂管理系统</title>

<style type="text/css">
        body{
            padding: 0;
            margin: 0;
        }
        .page{
            padding: 0;
            width: 100%;
            margin-left: auto;
            margin-right: auto;
        }
        .titlebar{
            height: 50px;
            width: 100%;
            background-color: #ffffff;
            min-width: 670px;
        }
        .logodiv{
            width: 30%;
            height: 50px;
            float: left;
        }
        .homelogo{
            width: 80px;
            height: 80px;
            display: inline-block;
            float: left;
            margin-left: 30px;
            margin-top: 5px;
        }
        .containerarea{
            background-color: #EDF0F2;
            width: 100%;
            height: 1080px;
            float: right;
        }

        .logincontainer{
            height: 430px;
            width: 450px;
            margin: 60px auto;
            background-color: #FFFFFF;
        }
        .loginheader{
            height: 58px;
            width: 100%;
            background-color: #677381;
            text-align: center;
            line-height: 58px;
            font-size: 25px;
            color: #ffffff;
        }
        .loginlogo{
            width: 80px;
            height: 80px;
            background-image: url('<%=__APP__ %>/web/public/images/login/logo.png');
            margin: 20px auto 0 auto;
            background-size: 100% 100%;
        }
        .welcomlabel{
            color: #677381;
            width: 302px;
            height: 25px;
            font-size: 14px;
            margin: 0 auto;
        }
        .logininput{
            width: 330px;
            height: 60px;
            margin: 0 auto;
            display: block;
            border: 0;
            background-color: #F4F4F4;
            outline: none;
            font-size: 18px;
            color: #888888;
            padding-left: 60px;
            background-size: 26px 26px;
            background-position: 20px 20px;
            background-repeat: no-repeat;
        }
        .lkeypic{
            background-image: url('<%=__APP__ %>/web/public/images/login/lkey.png');
        }
        .userpic{
            background-image: url('<%=__APP__ %>/web/public/images/login/user.png');
        }

        .loginbtn{
            width: 268px;
            height: 48px;
            display: block;
            background-color: #51D2B7;
            margin: 10px auto;
            text-align: center;
            line-height: 48px;

            text-decoration: none;
            color: #fff;
            cursor: pointer;
        }
        .bottom{
            width: 100%;
            background-color: #1B9FCB;
        }
        .copyriht{
            width:100%;text-align: center;padding-top: 50px;color: #222222;
        }

        @-webkit-keyframes shake {
            0%, 100% {-webkit-transform: translateX(0);}
            10%, 30%, 50%, 70%, 90% {-webkit-transform: translateX(-10px);}
            20%, 40%, 60%, 80% {-webkit-transform: translateX(10px);}
        }

        @-moz-keyframes shake {
            0%, 100% {-moz-transform: translateX(0);}
            10%, 30%, 50%, 70%, 90% {-moz-transform: translateX(-10px);}
            20%, 40%, 60%, 80% {-moz-transform: translateX(10px);}
        }

        @-o-keyframes shake {
            0%, 100% {-o-transform: translateX(0);}
            10%, 30%, 50%, 70%, 90% {-o-transform: translateX(-10px);}
            20%, 40%, 60%, 80% {-o-transform: translateX(10px);}
        }

        @keyframes shake {
            0%, 100% {transform: translateX(0);}
            10%, 30%, 50%, 70%, 90% {transform: translateX(-10px);}
            20%, 40%, 60%, 80% {transform: translateX(10px);}
        }

        .shake {
            -webkit-animation-name: shake;
            -moz-animation-name: shake;
            -o-animation-name: shake;
            -webkit-animation-duration: .5s;
            -moz-animation-duration: .5s;
            -o-animation-duration: .5s;
            animation-name: shake;
            animation-duration: .5s;
        }
     .zoom {
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 20000ms;
            -webkit-animation-timing-function: linner;
            -webkit-animation-iteration-count:infinite;

            -o-animation-name: zoom;
            -o-animation-duration: 20000ms;
            -o-animation-timing-function: linner;
            -o-animation-iteration-count:infinite;

            -moz-animation-name: zoom;
            -moz-animation-duration: 20000ms;
            -moz-animation-timing-function: linner;
            -moz-animation-iteration-count:infinite;

            animation-name: zoom;
            animation-duration: 20000ms;
            animation-timing-function: linner;
            animation-iteration-count:infinite;
        }
        @-webkit-keyframes zoom {
            0% {
                -webkit-transform: scale3d(1,1,1);
            }
            5% {
                -webkit-transform: scale3d(1.5,1.5,1);
            }
            100% {
                -webkit-transform: scale3d(1.8,1.8,1);
            }
        }
        @-moz-keyframes zoom {
            0% {
                -moz-transform: scale3d(1,1,1);
            }
            5% {
                -moz-transform: scale3d(1.5,1.5,1);
            }
            100% {
                -moz-transform: scale3d(1.8,1.8,1);
            }
        }
        @-o-keyframes zoom {
            0% {
                -o-transform: scale3d(1,1,1);
            }
            5% {
                -o-transform: scale3d(1.5,1.5,1);
            }
            100% {
                -o-transform: scale3d(1.8,1.8,1);
            }
        }

        @keyframes zoom {
            0% {
                transform: scale3d(1,1,1);
            }
            5% {
                transform: scale3d(1.5,1.5,1);
            }
            100% {
                transform: scale3d(1.8,1.8,1);
            }
        }
</style>

<script type="text/javascript">

if(top.location!=self.location) top.location=self.location;

var loginuserinfo =  localStorage["loginuserinfo"];
var isremember = localStorage['isremember'];

if(loginuserinfo){
    var info = JSON.parse(loginuserinfo);
    $("#passwd").val(info.passwd);
    $("#username").val(info.username);
}

if(isremember=="1"){
    $("#remember").attr("checked","checked");
}

document.onkeydown=function (e){
    e = e ? e : event;
    if(e.keyCode == 13){
        login();
    }
};
    function login() {
        var username = $("#username").val();
        var passwd = $("#passwd").val();
        if(trim(username) == "" || trim(passwd) == ""){
            //$.messager.alert("提示", '请输入user name和密码！');
            $("#logindialog").addClass("shake");
            setTimeout(function(){
                $("#logindialog").removeClass("shake");
            },500);
            return;
        }
        //$("#logindialog").addClass("zoom");
        $("#loginimg").hide();
        $.post(__APP__+"/Index!login",{username:username,passwd:passwd},function(data){
            closeBackGround();
            //data = JSON.parse(data);
            if (data != "success") {
                //$("#logindialog").removeClass("zoom");
                $("#logindialog").addClass("shake");
                setTimeout(function(){
                    $("#logindialog").removeClass("shake");
                },500);
                //$.messager.alert("提示", 'user name或密码错误！');
                $("#loginimg").show();
            } else {
                //$.messager.alert("提示", '登录成功！');
                var flag = $("#remember").is(":checked");
                if(flag){
                    var loginobj = {};
                    loginobj.username = username;
                    loginobj.passwd = passwd;
                    localStorage["loginuserinfo"] = JSON.stringify(loginobj);
                    localStorage["isremember"] = "1";
                }else{
                    localStorage.removeItem("loginuserinfo");
                    localStorage.removeItem("isremember");
                }
                window.location.href = __APP__+"/Index!index";
            }
        });
    }
</script>
</head>

<body>
<div class="header">
	<div class="container">
		<div class="header_top">
			<div class="logo">
				<a href="index.html"><img src="<%=__APP__ %>/bs/images/logo.png" alt=""/></a>
			</div> 
			<div class="cssmenu">
					<ul>
						<li class="active"><a href="#rightarea">登录</a></li> 
						<!-- <li><a href="register.html">注册</a></li> -->
					</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="h_menu4"><!-- start h_menu4 -->
				<ul class="nav">
					<li class="active"><a href="index.html">首页Home</a></li>
					<li><a href="<%=__APP__ %>/web/pages/allpages/about/index.html">实战课程Practical Ccourses</a></li>
					<li><a href="<%=__APP__ %>/web/pages/allpages/service/index.html">详细介绍Detailed Iintroduction</a></li>
					<li><a href="<%=__APP__ %>/web/pages/allpages/featrue/index.html">未来计划Future Pplan</a></li>
					<li><a href="<%=__APP__ %>/web/pages/allpages/contact/index.html">关于我们About Us</a></li>
				 </ul>
				 <script type="text/javascript" src="js/nav.js"></script>
	      </div><!-- end h_menu4 -->
     </div>
</div>
<div class="about">
	 <div class="container">
		<h1>登录<span class="m_1"><br>中心Center</span></h1>
	</div>
</div>
<div class="account_grid">
	<div class="container">
		<!-- <div class="col-md-6 login-left">
		<h4 class="tz-title-5 tzcolor-blue">
			<p class="tzweight_Bold"><span class="m_20">新用户注册</span></p>
		</h4>
		<p>通过在我们的系统商店创建一个帐户，您将能够更快地完成多项功能.</p>
		<div class="loginbtn" href="register.html">创建帐户</div>
		</div> -->
		<div class="col-md-6 login-right">
			<h4 class="tz-title-5 tzcolor-blue">
			<p class="tzweight_Bold"><span class="m_20">登录系统</span></p>
			</h4>
				  	
			<p>如果您已有帐户，请登录.</p>
			<section id="rightarea">
				<div id="logindialog">
					<form>
						<div>
							<span class="m_25">用户名</span>
							<input id="username" name="username" class="logininput userpic" type="text">
						</div>
						<div>
							<span class="m_25">密码</span>
							<input id="passwd" name="passwd" class="logininput lkeypic" type="password"> 
						</div>
						<div>
							<input style="width:15px;height:15px;" type="checkbox" value="1" id="remember">记住密码</label>
						</div>
						<div class="loginbtn" onclick="login();">登录</div>
					</form>
				</div>
			</section>
		</div>	
		<div class="clearfix"> </div>
	</div>
</div>
<div class="footer">
	<div class="container">
		<div class="col-md-3 box_1">
			<img src="<%=__APP__ %>/bs/images/f_logo.png" alt=""/>
			<p>Copyright &copy; 2019.黄宏聪 戴锦波 伍俊旭</p>
		</div>
		<div class="col-md-3 box_2">
			<h4>快速链接</h4>
			<ul class="list_2">
				<li><a href="#">首页HOME</a></li>
				<li><a href="#">实战课程Practical Ccourses</a></li>
				<li><a href="#">详细介绍Detailed Iintroduction</a></li>
				<li><a href="#">未来计划Future Pplan</a></li>
				<li><a href="#">关于我们About Us</a></li>
			</ul>
			<div class="clearfix"> </div>
		</div>
		<div class="col-md-3 box_2">
			<h4>联系我们</h4>
			<address class="address">
              <dl>
                 <dt></dt>
                 <dd>地址: <span>广州大学松田学院男生二栋509微课堂项目组</span></dd>
                 <dd>邮箱: <a href="www.baidu.com">********@qq.com</a></dd>
                 <dd>联系电话: <span>********</span></dd>
              </dl>
           </address>
		</div>
		<div class="col-md-3 box_2">
			<h4>友情链接</h4>
			<ul class="footer_social">
			  <li><a href=""> <i class="fb"> </i> </a></li>
			  <li><a href=""><i class="tw"> </i> </a></li>
			  <li><a href=""><i class="linkedin"> </i> </a></li>
			  <li><a href=""><i class="google"> </i> </a></li>
		   </ul>
		</div>
	</div>
</div>
</body>
</html>