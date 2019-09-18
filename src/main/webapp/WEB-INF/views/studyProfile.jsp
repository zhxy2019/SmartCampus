<%--
  Created by IntelliJ IDEA.
  User: phoebe
  Date: 2019-08-24
  Time: 21:40
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
    <!-- Custom styles for this template -->
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/style-responsive.css" rel="stylesheet" />
    <link href="static/assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
    <%--jQCloud--%>
    <link href="//cdn.bootcss.com/jqcloud/1.0.4/jqcloud.min.css" rel="stylesheet">

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
                    <a href="main">
                        <i class="icon-bar-chart"></i>
                        <span>成绩分析</span>
                    </a>
                </li>

                <li>
                    <a href="study/">
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
            <div class="row" id="part_of_cloud" style="display: block">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            学业标签
                        </header>
                        <div class="panel-body">
                            <div id="cloud"></div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row" id="part_of_grind" style="display: none">
                <div class="col-lg-8">
                    <section class="panel">
                        <header class="panel-heading">
                            历年总体评估类型学生人数统计
                        </header>
                        <div class="panel-body">
                            <div id="student_type_line" class="graph"></div>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4">
                    <section class="panel">
                        <header class="panel-heading">
                            总体评估总比例
                        </header>
                        <div class="panel-body">
                            <div id="student_type_donut" class="graph"></div>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row" id="part_of_fail" style="display: none">
                <div class="col-lg-8">
                    <section class="panel">
                        <header class="panel-heading">
                            历年学业困难学生类型人数统计
                        </header>
                        <div class="panel-body">
                            <div id="fail_line" class="graph"></div>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4">
                    <section class="panel">
                        <header class="panel-heading">
                            学业困难总比例
                        </header>
                        <div class="panel-body">
                            <div id="fail_donut" class="graph"></div>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row" id="part_of_ascend" style="display: none">
                <div class="col-lg-8">
                    <section class="panel">
                        <header class="panel-heading">
                            历年成绩变化学生类型人数统计
                        </header>
                        <div class="panel-body">
                            <div id="ascend_line" class="graph"></div>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4">
                    <section class="panel">
                        <header class="panel-heading">
                            成绩变化总比例
                        </header>
                        <div class="panel-body">
                            <div id="ascend_donut" class="graph"></div>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <%--<header class="panel-heading">--%>
                            <%--定向搜索--%>
                        <%--</header>--%>
                        <div class="panel-body">
                            <form role="form">
                                <%--<div class="form-group col-lg-4">--%>
                                    <%--<div class="col-lg-10">--%>
                                        <%--<select class="form-control m-bot15">--%>
                                            <%--<option>请选择年级</option>--%>
                                            <%--<option>1</option>--%>
                                            <%--<option>2</option>--%>
                                            <%--<option>3</option>--%>
                                            <%--<option>4</option>--%>
                                            <%--<option>5</option>--%>
                                        <%--</select>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div class=" col-lg-2">
                                    <input type="text" class="form-control" id="grade" placeholder="请输入年级">
                                </div>
                                <div class=" col-lg-3">
                                    <input type="text" class="form-control" id="year" placeholder="请输入学年">
                                </div>
                                <div class=" col-lg-3">
                                    <%--<label for="studentId">学号</label>--%>
                                    <input type="text" class="form-control" id="studentId" placeholder="请输入学号">
                                </div>
                                <div class=" col-lg-3">
                                    <input type="text" class="form-control" id="studentName" placeholder="请输入姓名">
                                </div>
                                <div class=" col-lg-1">
                                    <button type="submit" class="btn btn-info">搜索</button>
                                </div>
                            </form>

                        </div>
                    </section>
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
<script src="static/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="static/js/jquery.dcjqaccordion.2.7.js"></script>
<%--<script src="static/js/jquery.scrollTo.min.js"></script>--%>
<%--<script src="static/js/jquery.nicescroll.js" type="text/javascript"></script>--%>
<script src="static/js/respond.min.js" ></script>
<script src="static/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
<script src="static/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
<%--jQCloud--%>
<script src="//cdn.bootcss.com/jqcloud/1.0.4/jqcloud-1.0.4.min.js"></script>

<!--common script for all pages-->
<script src="static/js/common-scripts.js"></script>

<script type="text/javascript">
    // 学生类型数据
    var grind_data,grind_percent;
    var studentType=['学霸', '学习普通', '学渣'];
    // 学业困难数据
    var fail_data,fail_percent;
    var failType=['无挂科(0)', '有挂科(<10)', '有留级风险(<20)','有退学风险(<30)'];
    // 成绩变化数据
    var ascend_data,ascend_percent;
    var ascendType=['成绩上升', '成绩稳定', '成绩下降'];

    $(document).ready(function (e) {
        // 从后端获取学生类型数据
        $.ajax({
            url:$('base').attr('href')+"study/allGrindsData",
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    var grind0=data.content.grind0;
                    var grind1=data.content.grind1;
                    var grind2=data.content.grind2;
                    grind_data = [];
                    for(var i=0;i<=12;i++){
                        grind_data.push({
                            grade:String(i+2006)+"级",
                            学霸: grind0[i],
                            学习普通: grind1[i],
                            学渣: grind2[i]
                        });
                    }
                    console.log(grind_data);
                    var percent=data.content.percent;
                    grind_percent = [];
                    for(var i=0;i<=2;i++){
                        grind_percent.push({
                            label:studentType[i],
                            value: percent[i]
                        });
                    }
                    console.log(grind_percent);
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询总体评估画像失败", data.msg, "warning", {
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
            }
        });

        // 从后端获取学业困难数据
        $.ajax({
            url:$('base').attr('href')+"study/allFailData",
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    var fail0=data.content.fail0;
                    var fail1=data.content.fail1;
                    var fail2=data.content.fail2;
                    var fail3=data.content.fail3;
                    fail_data = [];
                    for(var i=0;i<=12;i++){
                        fail_data.push({
                            grade:String(i+2006)+"级",
                            无挂科: fail0[i],
                            有挂科: fail1[i],
                            有留级风险: fail2[i],
                            有退学风险: fail3[i]
                        });
                    }
                    console.log(fail_data);

                    fail_percent = [];
                    var percent=data.content.percent;
                    for(var i=0;i<=3;i++){
                        fail_percent.push({
                            label:failType[i],
                            value: percent[i]
                        });
                    }
                    console.log(fail_percent);

                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询学业困难画像失败", data.msg, "warning", {
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
            }
        });

        // 从后端获取成绩变化数据
        $.ajax({
            url:$('base').attr('href')+"study/allAscendData",
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    var ascend0=data.content.ascend0;
                    var ascend1=data.content.ascend1;
                    var ascend2=data.content.ascend2;
                    ascend_data = [];
                    for(var i=0;i<12;i++){
                        ascend_data.push({
                            grade:String(i+2006)+"-"+String(i+2007)+"学年",
                            成绩上升: ascend0[i],
                            成绩稳定: ascend1[i],
                            成绩下降: ascend2[i]
                        });
                    }
                    console.log(ascend_data);
                    var percent=data.content.percent;
                    ascend_percent = [];
                    for(var i=0;i<=2;i++){
                        ascend_percent.push({
                            label:ascendType[i],
                            value: percent[i]
                        });
                    }
                    console.log(ascend_percent);
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询成绩变化画像失败", data.msg, "warning", {
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
            }
        });

        // 标签云
        var labelText=['学霸','学渣','学习普通','无挂科','有挂科','有留级风险','有退学风险','成绩上升','成绩稳定','成绩下降'];
        var labelWeight=['19','15','11','10','16','18','12','13','17','14'];
        var i;
        var obj;
        var array = new Array();
        for (i = 0; i < labelText.length; i++) {
            obj = new Object();
            obj.text = labelText[i];
            obj.weight = labelWeight[i];
            if(i<3)
                obj.handlers = {click: function () {
                    document.getElementById("part_of_grind").style.display="block";
                    document.getElementById("part_of_fail").style.display="none";
                    document.getElementById("part_of_ascend").style.display="none";
                    if($("#student_type_line").empty()){
                        Morris.Area({
                            element: 'student_type_line',
                            data:grind_data,
                            xkey: 'grade',
                            ykeys: studentType,
                            labels: studentType,
                            // xmax:"auto",
                            // ymax:"auto",
                            units:'人',
                            // hideHover: 'auto',
                            lineWidth: 1,
                            pointSize: 5,
                            lineColors: ['#4a8bc2', '#a9d86e', '#ff6c60'],//蓝绿红
                            fillOpacity: 0.5,
                            smooth: true
                        });
                        Morris.Donut({
                            element: 'student_type_donut',
                            data: grind_percent,
                            colors: ['#4a8bc2', '#a9d86e', '#ff6c60'],
                            formatter: function (y) { return y + "%" }
                        });
                    }
                }};
            else if(i>=7)
                obj.handlers = {click: function() {
                    document.getElementById("part_of_grind").style.display="none";
                    document.getElementById("part_of_fail").style.display="none";
                    document.getElementById("part_of_ascend").style.display="block";
                        if($("#ascend_line").empty()){
                            Morris.Area({
                                element: 'ascend_line',
                                data:ascend_data,
                                xkey: 'grade',
                                ykeys: ascendType,
                                labels: ascendType,
                                // xmax:"auto",
                                // ymax:"auto",
                                units:'人',
                                // hideHover: 'auto',
                                lineWidth: 1,
                                pointSize: 5,
                                lineColors: ['#4a8bc2', '#a9d86e', '#ff6c60'],//蓝绿红
                                fillOpacity: 0.5,
                                smooth: true
                            });
                            Morris.Donut({
                                element: 'ascend_donut',
                                data: ascend_percent,
                                colors: ['#4a8bc2', '#a9d86e', '#ff6c60'],
                                formatter: function (y) { return y + "%" }
                            });
                        }
                }};
            else
                obj.handlers = {click: function() {
                    document.getElementById("part_of_grind").style.display="none";
                    document.getElementById("part_of_fail").style.display="block";
                    document.getElementById("part_of_ascend").style.display="none";
                    if($("#fail_line").empty()){
                        Morris.Area({
                            element: 'fail_line',
                            data:fail_data,
                            xkey: 'grade',
                            ykeys: ['无挂科', '有挂科', '有留级风险','有退学风险'],
                            labels: failType,
                            // xmax:"auto",
                            // ymax:"auto",
                            units:'人',
                            // hideHover: 'auto',
                            lineWidth: 1,
                            pointSize: 5,
                            lineColors: ['#4a8bc2', '#a9d86e', '#ff6c60','#8075c4'],
                            fillOpacity: 0.5,
                            smooth: true
                        });
                        Morris.Donut({
                            element: 'fail_donut',
                            data: fail_percent,
                            colors: ['#4a8bc2', '#a9d86e', '#ff6c60','#8075c4'],
                            formatter: function (y) { return y + "%" }
                        });
                    }
                }};
            array.push(obj);
        }
        $("#cloud").jQCloud(array, {
            removeOverflowing: true,
            shape: "elliptic",
            // width:550,
            height: 200
        });

    });

    function getGraphByLabel(label) {
        if($("#fail_line").empty())
            ;
        else
            $("#fail_line").clean();
        if(studentType.includes(label)){
            document.getElementById("part_of_grind").style.display="block";
            document.getElementById("part_of_fail").style.display="none";
            document.getElementById("part_of_ascend").style.display="none";
            var index=studentType.indexOf(label);
            var colors=['#4a8bc2', '#a9d86e', '#ff6c60'];//蓝绿红
            var lineColors=['#AAAAAA','#AAAAAA','#AAAAAA'];//灰
            lineColors[index]=colors[index];
            console.log(lineColors);
            Morris.Area({
                element: 'student_type_line',
                data:grind_data,
                xkey: 'grade',
                ykeys: studentType,
                labels: studentType,
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                // hideHover: 'auto',
                lineWidth: 1,
                pointSize: 5,
                lineColors: lineColors,
                fillOpacity: 0.5,
                smooth: true
            });
            Morris.Donut({
                element: 'student_type_donut',
                data: grind_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
        else if(failType.includes(label)){

        }
        else{

        }

    }


</script>

</body>
</html>

