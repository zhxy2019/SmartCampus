<%--
  Created by IntelliJ IDEA.
  User: XipengCao
  Date: 2019/8/8
  Time: 20:43
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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>智慧校园</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="static/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="static/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/style-responsive.css" rel="stylesheet" />

    <link href="static/assets/jqcloud/jqcloud.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<section id="container" class="">
    <!--header start-->
    <header class="header white-bg">
        <div class="sidebar-toggle-box">
            <div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
        </div>
        <!--logo start-->
        <a href="/" class="logo" >智慧<span>校园</span></a>
        <!--logo end-->
        <div class="top-nav ">
            <ul class="nav pull-right top-menu">
                <li>
                    <input type="text" class="form-control search" placeholder="Search">
                </li>
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="username">${sessionScope.administrator.adminname}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
        </div>
    </header>
    <!--header end-->
    <!--sidebar start-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a href="index.html">
                        <i class="icon-bar-chart"></i>
                        <span>成绩分析预测</span>
                    </a>
                </li>

                <li>
                    <a href="javascript:;">
                        <i class="icon-book"></i>
                        <span>学业画像</span>
                    </a>
                </li>

                <li>
                    <a href="javascript:;">
                        <i class="icon-shopping-cart"></i>
                        <span>消费画像</span>
                    </a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper site-min-height">
            <!-- page start-->
            <!--state overview start-->
            <div class="row state-overview">
                <div class="col-lg-4 col-sm-6">
                    <section class="panel">
                        <div class="symbol terques">
                            <i class="icon-user"></i>
                        </div>
                        <div class="value">
                            <h1 class="count">
                                11850
                            </h1>
                            <p>在校生人数</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <section class="panel">
                        <div class="symbol red">
                            <i class="icon-tags"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count2">
                                335
                            </h1>
                            <p>有留级风险人数</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <section class="panel">
                        <div class="symbol yellow">
                            <i class="icon-shopping-cart"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count3">
                                239
                            </h1>
                            <p>有退学风险人数</p>
                        </div>
                    </section>
                </div>
            </div>
            <!--state overview end-->
            <div class="row">
                <div class="col-lg-8">
                    <!--custom chart start-->
                    <div class="border-head">
                        <h3>各学院挂科人数占比</h3>
                    </div>
                    <div class="custom-bar-chart">
                        <ul class="y-axis">
                            <li><span>10</span></li>
                            <li><span>8</span></li>
                            <li><span>6</span></li>
                            <li><span>4</span></li>
                            <li><span>2</span></li>
                            <li><span>0</span></li>
                        </ul>
                        <div class="bar">
                            <div class="title">国际学院</div>
                            <div class="value tooltips" data-original-title="8%" data-toggle="tooltip" data-placement="top">80%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">信息与通信工程学院</div>
                            <div class="value tooltips" data-original-title="5%" data-toggle="tooltip" data-placement="top">50%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">电子工程学院</div>
                            <div class="value tooltips" data-original-title="40%" data-toggle="tooltip" data-placement="top">40%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">计算机学院</div>
                            <div class="value tooltips" data-original-title="55%" data-toggle="tooltip" data-placement="top">50%</div>
                        </div>
                        <div class="bar">
                            <div class="title">自动化学院</div>
                            <div class="value tooltips" data-original-title="20%" data-toggle="tooltip" data-placement="top">20%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">软件学院</div>
                            <div class="value tooltips" data-original-title="39%" data-toggle="tooltip" data-placement="top">30%</div>
                        </div>
                        <div class="bar">
                            <div class="title">数字媒体与设计艺术学院</div>
                            <div class="value tooltips" data-original-title="75%" data-toggle="tooltip" data-placement="top">70%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">理学院</div>
                            <div class="value tooltips" data-original-title="45%" data-toggle="tooltip" data-placement="top">40%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">经济管理学院</div>
                            <div class="value tooltips" data-original-title="50%" data-toggle="tooltip" data-placement="top">50%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">网络空间安全学院</div>
                            <div class="value tooltips" data-original-title="42%" data-toggle="tooltip" data-placement="top">40%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">人文学院</div>
                            <div class="value tooltips" data-original-title="60%" data-toggle="tooltip" data-placement="top">60%</div>
                        </div>
                        <div class="bar ">
                            <div class="title">现代邮政学院</div>
                            <div class="value tooltips" data-original-title="90%" data-toggle="tooltip" data-placement="top">90%</div>
                        </div>
                    </div>
                    <!--custom chart end-->
                </div>
                <div class="col-lg-4">
                    <!--revenue start-->
                    <section class="panel">
                        <div class="revenue-head">
                              <span>
                                  <i class="icon-bar-chart"></i>
                              </span>
                            <h3>成绩预测告警</h3>
                            <span class="rev-combo pull-right">
                                 2019/8/25
                              </span>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6 col-sm-6 text-center">
                                    <div class="easy-pie-chart">
                                        <div class="percentage" data-percent="35"><span>35</span>%</div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-sm-6">
                                    <div class="chart-info chart-position">
                                        <span class="increase"></span>
                                        <span>预测本学期挂科人数</span>
                                    </div>
                                    <div class="chart-info">
                                        <span class="decrease"></span>
                                        <span>本学期总人数</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--revenue end-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <!--user info table start-->
                    <section class="panel">
                        <div class="panel-body">
                            <a href="#" class="task-thumb">
                                <%--<img src="img/avatar1.jpg" alt="">--%>
                            </a>
                            <div class="task-thumb-details">
                                <h1><a href="#">XX</a></h1>
                                <p>软件学院</p>
                            </div>
                        </div>
                        <table class="table table-hover personal-task">
                            <tbody>
                            <tr>
                                <td>
                                    <i class=" icon-tasks"></i>
                                </td>
                                <td>学号</td>
                                <td>2015212054</td>
                            </tr>
                            <tr>
                                <td>
                                    <i class="icon-warning-sign"></i>
                                </td>
                                <td>班级</td>
                                <td>2015211503</td>
                            </tr>
                            <tr>
                                <td>
                                    <i class="icon-envelope"></i>
                                </td>
                                <td>总加权成绩</td>
                                <td>80</td>
                            </tr>
                            <tr>
                                <td>
                                    <i class=" icon-bell-alt"></i>
                                </td>
                                <td>总排名</td>
                                <td>30</td>
                            </tr>
                            </tbody>
                        </table>
                    </section>
                    <!--user info table end-->
                </div>
                <div class="col-lg-8">
                    <!--work progress start-->
                    <section class="panel">
                        <div class="panel-body progress-panel">
                            <div class="task-progress">
                                <h1>预测可能挂科课程</h1>

                            </div>
                            <%--<div class="task-option">--%>
                                <%--<select class="styled">--%>
                                    <%--<option>Anjelina Joli</option>--%>
                                    <%--<option>Tom Crouse</option>--%>
                                    <%--<option>Jhon Due</option>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        </div>
                        <table class="table table-hover personal-task">
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>
                                    计算机网络
                                </td>
                                <td>
                                    <span class="badge bg-important">C</span>
                                </td>
                                <td>
                                    点击查看详情
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>
                                    编译原理
                                </td>
                                <td>
                                    <span class="badge bg-important">C</span>
                                </td>
                                <td>
                                    点击查看详情
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </section>
                    <!--work progress end-->
                </div>
            </div>
            <!-- page end-->
        </section>
    </section>
    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
        <div class="text-center">
            <a href="#" class="go-top">
                <i class="icon-angle-up"></i>
            </a>
        </div>
    </footer>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="static/js/jquery.js"></script>
<script src="static/js/jquery-1.8.3.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="static/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="static/js/jquery.scrollTo.min.js"></script>
<script src="static/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="static/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="static/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="static/js/owl.carousel.js" ></script>
<script src="static/js/jquery.customSelect.min.js" ></script>
<script src="static/js/respond.min.js" ></script>


<!--script for this page-->
<script src="static/js/sparkline-chart.js"></script>
<script src="static/js/easy-pie-chart.js"></script>
<script src="static/js/count.js"></script>
<script src="static/assets/jqcloud/jqcloud.min.js"></script>
<!--common script for all pages-->
<script src="static/js/common-scripts.js"></script>
<script type="text/javascript">
    $(document).ready(function (e) {
        var basepath = $('base').attr('href');
        //post 请求数据，在校生人数、有留级风险人数
        var getMenuDataUrl=basepath+'/getMenuData'
        $.ajax({
            url: getMenuDataUrl,
            async: true,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {},
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
</script>
</body>
</html>
