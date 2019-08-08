<%--
  Created by IntelliJ IDEA.
  User: XipengCao
  Date: 2019/8/8
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basepath%>"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="static/img/favicon.png">

    <title>智慧校园</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="static/assets/bootstrapValidator/css/bootstrapValidator.css" rel="stylesheet">
    <link href="static/assets/jqueryToast/css/toast.style.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-body">

<div class="container">

    <form id="loginForm" class="form-signin">
        <h2 class="form-signin-heading">登录</h2>
        <div class="login-wrap">
            <div class="form-group">
                <div class="form-label-group">
                    <input class="form-control required" type="text" placeholder="教工号" id="userId"
                           name="userId" autofocus="autofocus" maxlength="20" autocomplete="current-username"/>
                </div>
            </div>
            <div class="form-group">
                <div class="form-label-group">
                    <input class="form-control required" type="password" placeholder="密码"
                           id="password"
                           name="userPassword" maxlength="20" autocomplete="current-password"/>
                </div>
            </div>
            <div class="form-group form-inline">
                <div class="form-label-group">
                    <input class="form-control required" type="text" placeholder="验证码"
                           id="verifyCode"
                           name="verifyCode" maxlength="4"/>
                    <img src="${pageContext.request.contextPath}/getVerifyCode" id="verifyImg"
                         onclick="javascript:changeImage();"/>
                </div>
            </div>
            <button id="subbtn" class="btn btn-lg btn-login btn-block" type="submit">登录</button>
        </div>
    </form>

</div>



<!-- js placed at the end of the document so the pages load faster -->
<script src="static/js/jquery.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/assets/bootstrapValidator/js/bootstrapValidator.js"></script>
<script src="static/assets/jqueryToast/js/toast.script.js"></script>
<script type="text/javascript">
    function genTimestamp() {
        var time = new Date();
        return time.getTime();
    }
    function changeImage() {
        $('#verifyImg').attr('src', '${pageContext.request.contextPath}/getVerifyCode?timestamp=' + genTimestamp());
    }
    $(document).ready(function (e) {
        var basepath = $('base').attr('href');
        var loginUrl = basepath+'/checkLogin';


        $('#loginForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userId: {
                    message: '用户名输入有误！',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空！'
                        },regexp: {
                            regexp: /^[0-9]+$/,
                            message: '用户名只能包含数字'
                        }
                    }
                },
                userPassword: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空！'
                        },stringLength: {  //长度限制
                            min: 6,
                            max: 20,
                            message: '密码必须在6到20位之间'
                        },

                    }
                },
                verifyCode:{
                    validators:{
                        notEmpty:{
                            message:'验证码不能为空！'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9]+$/,
                            message: '验证码只能包含字母和数字'
                        }
                    }
                }

            }
        }).on('success.form.bv', function (e) { // 表单校验成功
            e.preventDefault();
            var form = $('#loginForm');
            var userId=form.find('#userId').val();
            var password=form.find('#password').val();
            var verifyCode=form.find('#verifyCode').val();
            $.ajax({
                url: loginUrl,
                async: true,
                cache: false,
                type: "post",
                dataType: 'json',
                data: {
                    userId:userId,
                    userPassword:password,
                    verifyCode:verifyCode
                },
                success: function (data) {
                    if (data.success) {
                        window.location.href = basepath + 'main';
                    } else {
                        //$("#errorMsg").text(data.msg);
                        $('#subbtn').attr("disabled",false);
                        changeImage();
                        $.Toast("登录失败", data.msg, "warning", {
                            stack: true,
                            has_icon: true,
                            has_close_btn: false,
                            fullscreen: false,
                            width: 400,
                            spacing: 20,
                            timeout: 3000,
                            border_radius: 8,
                            sticky: false,
                            position_class: "toast-top-right",
                            has_progress: false,
                            rtl: false,
                        });
                    }
                },
                error:function(){
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("服务器忙","请重试！", "warning", {
                        stack: true,
                        has_icon: true,
                        has_close_btn: false,
                        fullscreen: false,
                        width: 400,
                        spacing: 20,
                        timeout: 3000,
                        border_radius: 8,
                        sticky: false,
                        position_class: "toast-top-right",
                        has_progress: false,
                        rtl: false
                    });
                }
            });
        });
    });
</script>
</body>
</html>
