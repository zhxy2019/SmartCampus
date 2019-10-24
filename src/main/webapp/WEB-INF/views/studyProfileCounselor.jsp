<%--
  Created by IntelliJ IDEA.
  User: phoebe
  Date: 2019-09-21
  Time: 19:48
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
    <%--Mirris--%>
    <link href="static/assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
    <%--jQCloud--%>
    <link href="//cdn.bootcss.com/jqcloud/1.0.4/jqcloud.min.css" rel="stylesheet">
    <%--DataTables--%>
    <link href="static/DataTables/datatables.min.css" rel="stylesheet" />
    <%--jQCloud--%>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css">--%>
    <%--<link rel="stylesheet" href="static/assets/data-tables/DT_bootstrap.css" />--%>

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
                    <a href="counselor/study/">
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
            <%--标签云--%>
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
            <%--标签云--%>
            <%--定向搜索--%>
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <%--<header class="panel-heading">--%>
                        <%--定向搜索--%>
                        <%--</header>--%>
                        <div class="panel-body">
                            <div class=" col-lg-3">
                                <input type="text" class="form-control" id="classId" placeholder="请输入班级">
                            </div>
                            <div class=" col-lg-3">
                                <input type="text" class="form-control" id="studentId" placeholder="请输入学号">
                            </div>
                            <div class=" col-lg-3">
                                <input type="text" class="form-control" id="studentName" placeholder="请输入姓名">
                            </div>
                            <div class=" col-lg-3">
                                <button class="btn btn-info" id="searchbtn" onclick="fizzySearch()">搜索</button>
                            </div>
                        </div>
                    </section>
                    <section class="panel" id="part_of_searchTable" style="display:none;">
                        <header class="panel-heading">搜索结果</header>
                        <table class="table table-hover text-center" id="searchTable" >
                            <thead>
                            <tr>
                                <th class="text-center">学院</th>
                                <th class="text-center">专业</th>
                                <th class="text-center">年级</th>
                                <th class="text-center">班级</th>
                                <th class="text-center">学号</th>
                                <th class="text-center">姓名</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </section>
                </div>
            </div>
            <%--定向搜索--%>
            <%--统计图--%>
            <div class="row" id="part_of_graph" style="display: none">
                <div class="col-lg-12">
                    <select class="form-control m-bot15" id="selectClass">
                    </select>
                </div>
                <div class="col-lg-8">
                    <section class="panel">
                        <header class="panel-heading" id="graph_line_head">
                        </header>
                        <div class="panel-body">
                            <div id="graph_bar" class="graph"></div>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4">
                    <section class="panel">
                        <header class="panel-heading" id="graph_donut_head">
                        </header>
                        <div class="panel-body">
                            <div id="graph_donut" class="graph"></div>
                        </div>
                    </section>
                </div>
            </div>
            <%--统计图--%>
                <%--datatable--%>
                <div class="row" id="part_of_dataTable" style="display: none">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading" id="myHead">
                            </header>
                            <div class="panel-body">
                                <ul class="nav nav-tabs" id="ascendTab" style="display: none">
                                </ul>
                                <div>
                                    <table class="table table-hover text-center" id="myTable">
                                        <thead>
                                        <tr>

                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            <%--学生数据--%>
            <div id="part_of_student" style="display: none">
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                当前学生：
                                <a id="curStudentName"></a>
                            </header>
                            <div class="panel-body" id="student_cloud_panel">
                                <div id="student_cloud"></div>
                            </div>
                        </section>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <section class="panel">

                            <div class="panel-body">
                                <header class="panel-heading">基本信息</header>
                                <table class="table table-hover personal-task">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <i class=" icon-building"></i>
                                        </td>
                                        <td>学院</td>
                                        <td id="curCollege"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-group"></i>
                                        </td>
                                        <td>专业</td>
                                        <td id="curMajor"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-bookmark"></i>
                                        </td>
                                        <td>年级</td>
                                        <td id="curGrade"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="icon-sitemap"></i>
                                        </td>
                                        <td>班级</td>
                                        <td id="curClassId"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-certificate"></i>
                                        </td>
                                        <td>学号</td>
                                        <td id="curStudentId"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-star"></i>
                                        </td>
                                        <td>平均加权成绩</td>
                                        <td id="curWeightScore"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-sort-by-attributes"></i>
                                        </td>
                                        <td>平均排名</td>
                                        <td id="curStudentRank"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="icon-exclamation-sign"></i>
                                        </td>
                                        <td>挂科数目</td>
                                        <td id="curFailureNum"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="icon-warning-sign"></i>
                                        </td>
                                        <td>挂科学分</td>
                                        <td id="curFailureCredit"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </section>
                        <!--user info table end-->
                    </div>
                    <div class="col-lg-8">
                        <section class="panel">
                            <div class="panel-body">
                                <header class="panel-heading">成绩变化情况</header>
                                <table class="table table-hover personal-task text-center" id="ascendTable">
                                    <thead>
                                    <tr>
                                        <th class="text-center">学年</th>
                                        <th class="text-center">学期</th>
                                        <th class="text-center">加权成绩</th>
                                        <th class="text-center">排名</th>
                                        <th class="text-center">成绩变化</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>

                        </section>
                        <!--user info table end-->
                    </div>
                </div>
                <div class="row" id="part_of_course" style="display: none">
                    <div class="col-lg-12">
                        <section class="panel">
                            <div class="panel-body">
                                <header class="panel-heading">课程成绩</header>
                                <table class="table table-hover personal-task text-center" id="courseTable">
                                    <thead>
                                    <tr>
                                        <th class="text-center">学年</th>
                                        <th class="text-center">学期</th>
                                        <th class="text-center">课程代码</th>
                                        <th class="text-center">课程名称</th>
                                        <th class="text-center">学时</th>
                                        <th class="text-center">学分</th>
                                        <th class="text-center">课程成绩</th>
                                        <th class="text-center">课程排名</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
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
<%--DataTabels--%>
<script src="static/DataTables/datatables.min.js" type="text/javascript"></script>
<%--<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>--%>
<%--<script type="text/javascript" src="static/assets/data-tables/jquery.dataTables.js"></script>--%>
<%--<script type="text/javascript" src="static/assets/data-tables/DT_bootstrap.js"></script>--%>

<!--common script for all pages-->
<script src="static/js/common-scripts.js"></script>


<script>
    // 学生类型数据
    var grind_data,grind_percent;
    var studentType=['学习优秀', '学习普通', '学习困难'];
    // 学业困难数据
    var fail_data,fail_percent;
    var failType=['无挂科(0)', '有挂科(<10)', '有留级风险(<20)','有退学风险(<30)'];
    var failType2=['无挂科', '有挂科', '有留级风险','有退学风险'];
    // 成绩变化数据
    var ascend_data,ascend_percent;
    var ascendType=['成绩上升', '成绩稳定', '成绩下降'];
    var curLabel;


    $(document).ready(function (e) {
        // 标签云
        var labelText=['学习优秀','学习普通','学习困难','无挂科','有挂科','有留级风险','有退学风险','成绩上升','成绩稳定','成绩下降'];
        // var labelWeight=['19','15','11','10','16','18','12','13','17','14'];
        var labelWeight=['10','9','10.5','8','11','12','13','11','10','12'];
        var i;
        var obj;
        var array = new Array();
        for (i = 0; i < labelText.length; i++) {
            obj = new Object();
            obj.text = labelText[i];
            obj.weight = labelWeight[i];
            if (i===0){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('学习优秀','all');selectNewLabel();}}
            } else if (i===1){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('学习普通','all');selectNewLabel();}}
            } else if (i===2){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('学习困难','all');selectNewLabel();}}
            } else if (i===3){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('无挂科','all');selectNewLabel();}}
            } else if (i===4){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('有挂科','all');selectNewLabel();}}
            } else if (i===5){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('有留级风险','all');selectNewLabel();}}
            } else if (i===6){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('有退学风险','all');selectNewLabel();}}
            } else if (i===7){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('成绩上升','all');selectNewLabel();}}
            } else if (i===8){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('成绩稳定','all');selectNewLabel();}}
            } else{
                obj.handlers = {click: function () {getGraphDataByLabelAndId('成绩下降','all');selectNewLabel();}}
            }

            array.push(obj);
        }
        $("#cloud").jQCloud(array, {
            removeOverflowing: true,
            shape: "elliptic",
            // width:550,
            height: 200
        });

        //获取班级信息
        $.ajax({
            url:$('base').attr('href')+"counselor/classIdByCounselor",
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    $('#selectClass').html('<option value=\"all\" >所有班级</option>');
                    var classId =data.content.classData;
                    console.log(classId);
                    for(var i=0;i<classId.length;i++){
                        $('#selectClass').append('<option value=\"'+classId[i]+'\">'+classId[i]+'</option>');
                    }
                    $('#selectClass').off("change");
                    $('#selectClass').on('change',function(e){
                        e.preventDefault();
                        getGraphDataByLabelAndId(curLabel,e.target.value);
                    });
                } else {
                    alert(data.msg);
                }
            }
        });
    });

    function selectNewLabel() {
        document.getElementById('selectClass').options[0].selected=true;
        document.getElementById("part_of_searchTable").style.display="none";
    }

    // 从后端获取统计数据 辅导员下某个班级
    function getGraphDataByLabelAndId(label,classId) {
        $.ajax({
            url:$('base').attr('href')+"counselor/countDataByLabelAndId_counselor",
            type: "post",
            data:{"label":label,"id":classId},
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    //全局label
                    curLabel = label;
                    console.log(data.content.countData);
                    console.log(data.content.percentList);
                    var yearflag=0;
                    var curHead="<br/>"+$('#selectClass').find("option:selected").text()+":";
                    if(studentType.includes(label)){
                        //--------------------------------grind------------------------------------------
                        $('#graph_line_head').html("总体评估类型学生人数统计"+curHead);
                        $('#graph_donut_head').html("总体评估总比例"+curHead);
                        var grindData=data.content.countData;
                        console.log(grindData);
                        var grindPercent=data.content.percentList;
                        grind_data=[];
                        grind_percent = [];
                        for(var i=0;i<=2;i++){
                            grind_data.push({
                                label:studentType[i],
                                num:grindData[i]
                            });
                            grind_percent.push({
                                label:studentType[i],
                                value: grindPercent[i]
                            });
                        }
                        console.log(grind_data);
                    }else if (ascendType.includes(label)){
                        //--------------------------------ascend------------------------------------------
                        $('#graph_line_head').html("成绩变化类型学生人数统计"+curHead);
                        $('#graph_donut_head').html("成绩变化总比例"+curHead);
                        ascend_data=data.content.countData;
                        console.log(ascend_data);
                        var ascendPercent=data.content.percentList;
                        ascend_percent = [];
                        for(var i=0;i<=2;i++){
                            ascend_percent.push({
                                label:ascendType[i],
                                value: ascendPercent[i]
                            });
                        }
                        yearflag=1;
                    }else{
                        //--------------------------------fail------------------------------------------
                        $('#graph_line_head').html("历年学业困难类型学生人数统计"+curHead);
                        $('#graph_donut_head').html("学业困难总比例"+curHead);
                        var failData = data.content.countData;
                        console.log(failData);
                        var failPercent=data.content.percentList;
                        fail_data=[];
                        fail_percent = [];
                        for(var i=0;i<=3;i++){
                            fail_data.push({
                                label:failType[i],
                                num:failData[i]
                            });
                            fail_percent.push({
                                label:failType[i],
                                value: failPercent[i]
                            });
                        }
                        console.log(fail_data);
                    }
                    //显示line与donut两个图
                    getGraphByLabel(label);
                    //添加tab及绑定click事件
                    if(yearflag===1){
                        $('#ascendTab').html('<li class="active"><a id="'+data.content.countData[0].year+'">'+data.content.countData[0].year+'学年</a></li>');
                        for(var i=1;i<data.content.countData.length;i++){
                            $('#ascendTab').append('<li><a id="'+data.content.countData[i].year+'">'+data.content.countData[i].year+'学年</a></li>');
                        }
                        $('#ascendTab a').click(function (e) {
                            e.preventDefault();
                            $(this).tab('show');
                            var year=e.target.getAttribute('id');
                            getTable(curLabel,year,classId);
                            document.getElementById("part_of_student").style.display="none";
                        });
                    }
                    //学生数据
                    if(yearflag===1)
                        getTable(label, data.content.countData[0].year,classId);
                    else{
                        var year='';//总体评估与学业困难的datatable没有tab
                        getTable(label, year,classId);
                    }

                    $('#myHead').html('当前标签：' + label);
                    document.getElementById("part_of_dataTable").style.display = "block";
                    document.getElementById("part_of_student").style.display="none";
                    document.getElementById("part_of_course").style.display="none";
                } else {
                    alert("查询失败:"+data.msg);
                }
            }
        });
    }

    function getGraphByLabel(label) {
        if($("#graph_bar").empty()===false)
            $("#graph_bar").remove();
        document.getElementById("part_of_graph").style.display="block";
        if(studentType.includes(label)){
            var index=studentType.indexOf(label);
            // var colors=['#FF0000', '#66CD00', '#1874CD'];//深虹绿蓝
            // var lineColors=['#F08080', '#B4EEB4', '#B0E2FF'];//浅
            var colors=['#1874CD', '#66CD00', '#FF0000'];//深蓝绿红
            var lineColors=[ '#B0E2FF','#B4EEB4', '#F08080'];//浅
            var color=lineColors[index];//浅
            // var colors=['#4a8bc2', '#a9d86e', '#ff6c60'];//蓝绿红
            // var lineColors=['#AAAAAA','#AAAAAA','#AAAAAA'];//灰
            lineColors[index]=colors[index];
            Morris.Bar({
                element: 'graph_bar',
                data:grind_data,
                xkey: 'label',
                ykeys: ['num'],
                labels: ['数量'],
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                hideHover: 'auto',
                barRatio: 0.4,
                xLabelAngle: 35,
                barColors: [color],
            });
            Morris.Donut({
                element: 'graph_donut',
                data: grind_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
        else if(ascendType.includes(label)){
            var index=ascendType.indexOf(label);
            var colors=['#1874CD', '#66CD00', '#FF0000'];//深蓝绿红
            var lineColors=[ '#B0E2FF','#B4EEB4', '#F08080'];//浅
            lineColors[index]=colors[index];
            Morris.Area({
                element: 'graph_bar',
                data:ascend_data,
                xkey: 'year',
                ykeys: ['ascend0','ascend1','ascend2'],
                labels: ascendType,
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                // hideHover: 'auto',
                lineWidth: 1,
                pointSize: 5,
                lineColors:lineColors,
                parseTime:false,
                fillOpacity: 0.5,
                smooth: true
            });
            Morris.Donut({
                element: 'graph_donut',
                data: ascend_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
        else{
            var index=failType2.indexOf(label);
            var colors=['#66CD00','#1874CD','#EEC900','#FF0000' ];//深绿蓝黄红
            var lineColors=['#B4EEB4','#B0E2FF' ,'#FFEC8B','#F08080'];//浅
            var color=lineColors[index];//浅
            lineColors[index]=colors[index];
            Morris.Bar({
                element: 'graph_bar',
                data:fail_data,
                xkey: 'label',
                ykeys: ['num'],
                labels: ['数量'],
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                hideHover: 'auto',
                barRatio: 0.4,
                xLabelAngle: 35,
                barColors: [color],
            });
            Morris.Donut({
                element: 'graph_donut',
                data: fail_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }

    }

    var myTable=null;
    function getTable(label,year,id) {
        if (myTable === null)
            ;
        else {
            $('#myTable thead tr').html('');
            myTable.destroy();
        }
        var columns;
        if (failType2.includes(label)) {
            $('#myTable thead tr').html('<th class=\"text-center\">年级</th>\n' +
                '                                        <th class=\"text-center\">班级</th>\n' +
                '                                        <th class=\"text-center\">学号</th>\n' +
                '                                        <th class=\"text-center\">姓名</th>\n' +
                '                                        <th class=\"text-center\">挂科数目</th>\n' +
                '                                        <th class=\"text-center\">挂科学分</th>\n' +
                '                                        <th class=\"text-center\">操作</th>');
            columns = [
                {"data": "grade"},
                {"data": "classid"},
                {"data": "studentid"},
                {"data": "studentname"},
                {"data": "failurenum"},
                {"data": "failurecredit"},
                {
                    "data": null, "render": function (data, type, row) {
                        var button = "<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('" + row.studentid.toString() + "')\">查看学生</button>";
                        return button;
                    }
                }
            ];
        } else {
            $('#myTable thead tr').html('<th class="text-center">年级</th>\n' +
                '                                        <th class="text-center">班级</th>\n' +
                '                                        <th class="text-center">学号</th>\n' +
                '                                        <th class="text-center">姓名</th>\n' +
                '                                        <th class="text-center">平均加权成绩</th>\n' +
                '                                        <th class="text-center">平均排名</th>\n' +
                '                                        <th class="text-center">操作</th>');
            columns = [
                {"data": "grade"},
                {"data": "classid"},
                {"data": "studentid"},
                {"data": "studentname"},
                {
                    "data": null, "render": function (data, type, row) {
                        return Math.round(data.weightscore)
                    }
                },
                {"data": "studentrank"},
                {
                    "data": null, "render": function (data, type, row) {
                        var button = "<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('" + row.studentid.toString() + "')\">查看学生</button>";
                        return button;
                    }
                }
            ];
        }
        if (ascendType.includes(label)){
            document.getElementById("ascendTab").style.display="block";
        }else{
            document.getElementById("ascendTab").style.display="none";
        }
        // DataTable
        myTable = $('#myTable').DataTable({
            lengthChange: false,
            processing: true,//刷新的那个对话框
            serverSide: true,//服务器端获取数据
            paging: true,//开启分页
            searchable: false,
            autoWidth: false,
            info: true,
            filter: false,//搜索框
            ordering: false,
            destroy: true,
            stateSave: false,
            oLanguage: { // 国际化配置
                "sProcessing": "正在获取数据，请稍后...",
                "sLengthMenu": "显示 _MENU_ 条",
                "sZeroRecords": "没有找到数据",
                "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                "sInfoPostFix": "",
                "sSearch": "查询",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "第一页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "最后一页"
                }
            },
            ajax: {
                type: "post",
                url: $('base').attr('href') + "counselor/studentDataByLabelAndId_counselor",
                async: true,
                cache: true,
                // dataType:'json',
                // contentType:false,
                // processData:false,
                data: function (d) {
                    console.log('打印d');
                    console.log(d);
                    // var param = new FormData();
                    var param = {};
                    var pageNum = (d.start + d.length) / d.length;
                    var draw = d.draw;
                    param.label = label;
                    param.year = year;
                    param.id = id;
                    param.pageNum = pageNum;
                    param.draw = draw;
                    return param;
                    // param.append("label","学习优秀");
                    // param.append("pageNum",pageNum);
                    // param.append("draw",draw);
                    // return param;
                },
                dataFilter: function (data) {
                    var result = JSON.parse(data);
                    if (result.code === 100) {
                        var pb = result.content.datawithpage;
                        var returnData = {};
                        returnData.draw = pb.draw;
                        returnData.recordsTotal = pb.totalRecord;
                        returnData.recordsFiltered = pb.totalRecord;
                        returnData.data = pb.list;
                        return JSON.stringify(returnData);
                    } else if (result.code === 200) {
                        alert('datatable错误');
                    }
                }
            },
            columns: columns

        });
    }



    var searchTable;
    function fizzySearch(){
        var classId=$('#calssId').val();
        var studentId=$('#studentId').val();
        var studentName=$('#studentName').val();
        if(classId='' && studentId=='' && studentName=='')
            alert("请输入搜索信息！");
        else{
            // document.getElementById("part_of_graph").style.display="none";
            // document.getElementById("part_of_dataTable").style.display="none";
            document.getElementById("part_of_student").style.display="none";
            document.getElementById("part_of_course").style.display="none";
            document.getElementById("part_of_searchTable").style.display="block";
            searchTable=$('#searchTable').dataTable({
                lengthChange:false,
                processing: true,//刷新的那个对话框
                serverSide: true,//服务器端获取数据
                paging: true,//开启分页
                searchable:false,
                autoWidth:false,
                info:true,
                filter:false,//搜索框
                ordering: false,
                destroy:true,
                stateSave:false,
                oLanguage : { // 国际化配置
                    "sProcessing" : "正在获取数据，请稍后...",
                    "sLengthMenu" : "显示 _MENU_ 条",
                    "sZeroRecords" : "没有找到数据",
                    "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                    "sInfoEmpty" : "记录数为0",
                    "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                    "sInfoPostFix" : "",
                    "sSearch" : "查询",
                    "sUrl" : "",
                    "oPaginate" : {
                        "sFirst" : "第一页",
                        "sPrevious" : "上一页",
                        "sNext" : "下一页",
                        "sLast" : "最后一页"
                    }
                },
                ajax: {
                    type: "post",
                    url: $('base').attr('href') + "counselor/searchStudent_counselor",
                    async:true,
                    cache:true,
                    data:function(d){
                        console.log('打印d');
                        console.log(d);
                        // var param = new FormData();
                        var param={};
                        var pageNum=(d.start+d.length)/d.length;
                        var draw=d.draw;
                        param.classId=classId;
                        param.studentId=studentId;
                        param.studentName=studentName;
                        param.pageNum=pageNum;
                        param.draw=draw;
                        return param;
                    },
                    dataFilter:function (data) {
                        var result=JSON.parse(data);
                        if(result.code === 100){
                            var pb=result.content.pb;
                            var returnData={};
                            returnData.draw=pb.draw;
                            returnData.recordsTotal=pb.totalRecord;
                            returnData.recordsFiltered=pb.totalRecord;
                            returnData.data=pb.list;
                            return JSON.stringify(returnData);
                        }else if (result.code=== 200){
                            alert("搜索失败："+data.msg);
                        }
                    }
                },
                columns:[
                    { "data": "collegeName" },
                    { "data": "majorName" },
                    { "data": "grade" },
                    { "data": "classId" },
                    { "data": "studentId"},
                    { "data": "studentName"},
                    { "data": null,"render":function(data,type,row){
                            var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('"+row.studentId.toString()+"')\">查看学生</button>";
                            return button;
                        }}
                ]
            });


        }
    }

    var ascendTable=null;
    var studentCloud=null;
    function checkStudent(studentId){
        document.getElementById("part_of_student").style.display="block";
        document.getElementById("part_of_course").style.display="none";
        if (ascendTable===null)
            ;
        else{
            ascendTable.destroy();
        }
        if (studentCloud===null)
            ;
        else{
            $("#student_cloud_panel").html('<div id="student_cloud"></div>');
        }
        $.ajax({
            url:$('base').attr('href')+"counselor/allDataByStudent",
            type: "post",
            dataType: 'json',
            data:{'studentId':studentId},
            success: function (data) {
                if (data.code === 100) {
                    var labels=data.content.studentLabels;
                    var studentData=data.content.studentData;
                    var studentStudyData=data.content.studentStudyData;
                    var classData=data.content.classData;
                    var i;
                    var obj;
                    var array = new Array();
                    for (i = 0; i < labels.length; i++) {
                        obj = new Object();
                        obj.text = labels[i];
                        obj.weight = Math.random()*5;
                        array.push(obj);
                    }
                    studentCloud=$("#student_cloud").jQCloud(array, {
                        removeOverflowing: true,
                        shape: "elliptic",
                        // width:550,
                        height: 95
                    });
                    console.log(studentData);
                    console.log(studentStudyData);
                    console.log(classData);
                    if(classData!=null){
                        $('#curCollege').html(classData.collegename);
                        $('#curMajor').html(classData.majorname);

                    }else{
                        $('#curCollege').html("信息缺失");
                        $('#curMajor').html("信息缺失");
                    }
                    $('#curStudentName').html(studentData.studentname);
                    $('#curStudentId').html(studentData.studentid);
                    $('#curGrade').html(studentData.grade);
                    $('#curClassId').html(studentData.classid);
                    $('#curWeightScore').html(Math.round(studentData.weightscore));
                    $('#curStudentRank').html(studentData.studentrank);
                    $('#curFailureNum').html(studentData.failurenum);
                    $('#curFailureCredit').html(studentData.failurecredit);
                    ascendTable=$('#ascendTable').DataTable({
                        paging:false,
                        searchable:false,
                        autoWidth:false,
                        info:false,
                        filter:false,//搜索框
                        ordering: false,
                        destroy:true,
                        stateSave:false,
                        data:studentStudyData,
                        columns:[
                            { "data": "year" },
                            { "data": "term" },
                            { "data": null,"render":function(data,type,row){
                                    return Math.round(data.weightscore);
                                } },
                            { "data": "studentrank" },
                            { "data": null,"render":function(data,type,row){
                                    return ascendType[data.ascend].substr(2,2);
                                }},
                            { "data": null,"render":function(data,type,row){
                                    var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkCourse('"+row.studentid.toString()+"','"+row.year.toString()+"')\">查看课程成绩</button>";
                                    return button;
                                }}
                        ]
                    });
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询学生学业画像失败", data.msg, "warning", {
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
    }


    var courseTable=null;
    function checkCourse(studentId,year) {
        document.getElementById("part_of_course").style.display = "block";
        if (courseTable === null)
            ;
        else {
            courseTable.destroy();
        }
        var courseData;
        $.ajax({
            type: "post",
            url: $('base').attr('href') + "counselor/courseDataByStudent",
            data: {'studentId': studentId, "year": year},
            success: function (data) {
                if (data.code === 100) {
                    courseData = data.content.courseData;
                    console.log(courseData);
                    courseTable = $('#courseTable').DataTable({
                        lengthChange: false,
                        paging: true,
                        searchable: false,
                        autoWidth: false,
                        info: false,
                        filter: false,//搜索框
                        ordering: false,
                        destroy: true,
                        stateSave: false,
                        data: courseData,
                        oLanguage: { // 国际化配置
                            "sProcessing": "正在获取数据，请稍后...",
                            "sLengthMenu": "显示 _MENU_ 条",
                            "sZeroRecords": "没有找到数据",
                            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                            "sInfoEmpty": "记录数为0",
                            "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                            "sInfoPostFix": "",
                            "sSearch": "查询",
                            "sUrl": "",
                            "oPaginate": {
                                "sFirst": "第一页",
                                "sPrevious": "上一页",
                                "sNext": "下一页",
                                "sLast": "最后一页"
                            }
                        },
                        columns: [
                            {"data": "year"},
                            {"data": "term"},
                            {"data": "courseId"},
                            {"data": "courseName"},
                            {"data": "classHour"},
                            {"data": "credit"},
                            {"data": "score"},
                            {"data": "studentRank"}
                        ]
                    });
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled", false);
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
    }
</script>