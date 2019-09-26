<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2019/9/3
  Time: 9:59
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
    <%--DataTables--%>
    <link href="static/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->

    <style>
        tfoot input {
            width: 100%;
            padding: 3px;
            box-sizing: border-box;
        }
    </style>
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
                    <a href="consumption/">
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
                            消费标签
                        </header>
                        <div class="panel-body">
                            <div id="cloud"></div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <%--定向搜索--%>
                        <div class="panel-body">
                            <div class=" col-lg-2">
                                <input type="text" class="form-control" id="college" placeholder="请输入学院">
                            </div>
                            <div class=" col-lg-2">
                                <input type="text" class="form-control" id="major" placeholder="请输入专业">
                            </div>
                            <div class=" col-lg-2">
                                <input type="text" class="form-control" id="year" placeholder="请输入年级">
                            </div>
                            <div class=" col-lg-2">
                                <input type="text" class="form-control" id="studentId" placeholder="请输入学号">
                            </div>
                            <div class=" col-lg-2">
                                <input type="text" class="form-control" id="studentName" placeholder="请输入姓名">
                            </div>
                            <div class=" col-lg-2">
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
            <div class="row" id="part_of_graph" style="display: none">
                <div class="col-lg-6">
                    <select class="form-control m-bot15" id="selectCollege">
                    </select>
                </div>
                <div class="col-lg-6">
                    <select class="form-control m-bot15" id="selectMajor">
                        <option>所有专业</option>
                    </select>
                </div>
                <div class="col-lg-8">
                    <section class="panel">
                        <header class="panel-heading" id="graph_line_head">
                        </header>
                        <div class="panel-body">
                            <div id="graph_line" class="graph"></div>
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

            <div class="row" id="part_of_dataTable" style="display: none">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading" id="myHead">
                        </header>
                        <div class="panel-body">
                            <ul class="nav nav-tabs" id="myTab">
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
                                            <i class=" icon-tasks"></i>
                                        </td>
                                        <td>学院</td>
                                        <td id="curCollege"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-tasks"></i>
                                        </td>
                                        <td>专业</td>
                                        <td id="curMajor"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class=" icon-tasks"></i>
                                        </td>
                                        <td>年级</td>
                                        <td id="curYear"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="icon-warning-sign"></i>
                                        </td>
                                        <td>班级</td>
                                        <td id="curClassId"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="icon-warning-sign"></i>
                                        </td>
                                        <td>学号</td>
                                        <td id="curStudentId"></td>
                                    </tr>
<%--                                    <tr>--%>
<%--                                        <td>--%>
<%--                                            <i class="icon-envelope"></i>--%>
<%--                                        </td>--%>
<%--                                        <td>早餐情况</td>--%>
<%--                                        <td id="curBreakfastLabel"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>--%>
<%--                                            <i class="icon-envelope"></i>--%>
<%--                                        </td>--%>
<%--                                        <td>三餐情况</td>--%>
<%--                                        <td id="curMealLabel"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>--%>
<%--                                            <i class=" icon-bell-alt"></i>--%>
<%--                                        </td>--%>
<%--                                        <td>消费情况</td>--%>
<%--                                        <td id="curConsumptionLabel"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>--%>
<%--                                            <i class=" icon-bell-alt"></i>--%>
<%--                                        </td>--%>
<%--                                        <td>晚睡情况</td>--%>
<%--                                        <td id="curSleeplateLabel"></td>--%>
<%--                                    </tr>--%>
                                    </tbody>
                                </table>
                            </div>
                        </section>
                        <!--user info table end-->
                    </div>
                    <div class="col-lg-8">
                        <section class="panel">

                            <div class="panel-body">
                                <header class="panel-heading">消费情况</header>
                                <table class="table table-hover personal-task text-center" id="behaviorTable">
                                    <thead>
                                    <tr>
                                        <th class="text-center">学年</th>
                                        <th class="text-center">学期</th>
                                        <th class="text-center">早餐情况</th>
                                        <th class="text-center">三餐情况</th>
                                        <th class="text-center">消费情况</th>
                                        <th class="text-center">晚睡情况</th>
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

<script type="text/javascript">
    // 早餐情况数据
    var breakfast_data,breakfast_percent;
    var breakfastType=['有早餐习惯', '无早餐习惯'];
    // 消费情况数据
    var consumption_data,consumption_percent;
    var consumptionType=['消费较低', '消费正常', '消费较高','消费过高','消费过低'];
    // 三餐情况数据
    var meal_data,meal_percent;
    var mealType=['三餐很规律', '三餐较规律', '三餐不规律'];
    // 晚睡情况数据
    var sleeplate_data,sleeplate_percent;
    var sleeplateType=['晚睡','不晚睡'];
    var curLabel;
    var graphYear=[2015,2016,2017,2018];

    $(document).ready(function (e) {

        // 标签云
        var labelText=['有早餐习惯','无早餐习惯','三餐很规律','三餐较规律','三餐不规律','消费较低','消费正常','消费较高','消费过高','消费过低','晚睡','不晚睡'];
        var labelWeight=['19','15','11','10','16','18','12','13','17','14','18','12'];
        var i;
        var obj;
        var array = new Array();
        for (i = 0; i < 12; i++) {
            obj = new Object();
            obj.text = labelText[i];
            obj.weight = labelWeight[i];
            if (i===0){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('有早餐习惯','all');selectNewLabel();}}
            } else if (i===1){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('无早餐习惯','all');selectNewLabel();}}
            } else if (i===2){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('三餐很规律','all');selectNewLabel();}}
            } else if (i===3){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('三餐较规律','all');selectNewLabel();}}
            } else if (i===4){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('三餐不规律','all');selectNewLabel();}}
            } else if (i===5){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('消费较低','all');selectNewLabel();}}
            } else if (i===6){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('消费正常','all');selectNewLabel();}}
            } else if (i===7){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('消费较高','all');selectNewLabel();}}
            } else if (i===8){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('消费过高','all');selectNewLabel();}}
            } else if (i===9){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('消费过低','all');selectNewLabel();}}
            } else if (i===10){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('晚睡','all');selectNewLabel();}}
            } else if (i===11){
                obj.handlers = {click: function () {getGraphDataByLabelAndId('不晚睡','all');selectNewLabel();}}
            }

            array.push(obj);
        }
        $("#cloud").jQCloud(array, {
            removeOverflowing: true,
            shape: "elliptic",
            // width:550,
            height: 300
        });

        //获取学院信息
        $.ajax({
            url:$('base').attr('href')+"consumption/collegeIdAndName",
            type: "post",
            dataType: 'json',
            success: function (datac) {
                if (datac.code === 100) {
                    $('#selectMajor').html('<option>所有专业</option>');
                    $('#selectCollege').html('<option value=\"all\" >所有学院</option>');
                    var college=datac.content.collegeData;
                    for(var i=0;i<college.length;i++){
                        $('#selectCollege').append('<option value=\"'+college[i].collegeId+'\">'+college[i].collegeName+'</option>');
                    }
                    $('#selectCollege').off("change");
                    $('#selectCollege').on('change',function(ec){
                        ec.preventDefault();
                        getGraphDataByLabelAndId(curLabel,ec.target.value);
                        //获取专业信息
                        $.ajax({
                            url:$('base').attr('href')+"consumption/majorIdAndName",
                            type: "post",
                            data:{"collegeId":ec.target.value},
                            dataType: 'json',
                            success: function (datam) {
                                if (datam.code === 100) {
                                    $('#selectMajor').html();
                                    $('#selectMajor').html('<option value=\"'+ec.target.value+'\" >所有专业</option>');
                                    var major=datam.content.majorData;
                                    console.log(major);
                                    for(var i=0;i<major.length;i++){
                                        $('#selectMajor').append('<option value=\"'+major[i].majorId+'\">'+major[i].majorName+'</option>')
                                    }
                                    $('#selectMajor').off("change");
                                    $('#selectMajor').on('change',function(em){
                                        em.preventDefault();
                                        getGraphDataByLabelAndId(curLabel,em.target.value);

                                    });
                                } else {
                                    //$("#errorMsg").text(data.msg);
                                    $('#subbtn').attr("disabled",false);
                                    changeImage();
                                    $.Toast("查询失败", data.msg, "warning", {
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
                    });
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询行为画像失败", data.msg, "warning", {
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


    });

    var searchTable;
    function fizzySearch(){
        var collegeName=$('#college').val();
        var majorName=$('#major').val();
        var year=$('#year').val();
        var studentId=$('#studentId').val();
        var studentName=$('#studentName').val();
        if(collegeName=='' && majorName=='' && year=='' && studentId=='' && studentName=='')
            alert("请输入搜索信息！");
        else{
            document.getElementById("part_of_graph").style.display="none";
            document.getElementById("part_of_dataTable").style.display="none";
            document.getElementById("part_of_student").style.display="none";
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
                    url: $('base').attr('href') + "consumption/searchStudent",
                    async:true,
                    cache:true,
                    data:function(d){
                        console.log('打印d');
                        console.log(d);
                        // var param = new FormData();
                        var param={};
                        var pageNum=(d.start+d.length)/d.length;
                        var draw=d.draw;
                        param.collegeName=collegeName;
                        param.majorName=majorName;
                        param.year=year;
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
                    { "data": "year" },
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

    function selectNewLabel() {
        document.getElementById('selectCollege').options[0].selected=true;
        document.getElementById("part_of_searchTable").style.display="none";
        $('#selectMajor').html('<option>所有专业</option>');
    }


    // 从后端获取统计数据 某个标签下的某个学院的某个专业
    function getGraphDataByLabelAndId(label,id) {
        $.ajax({
            url:$('base').attr('href')+"consumption/countBehaviorDataByLabelAndId",
            type: "post",
            data:{"label":label,"id":id},
            dataType: 'json',
            success: function (data) {
                if (data.code === 100) {
                    console.log(data.content.countData);
                    console.log(data.content.percentList);
                    var yearflag=0;
                    var curHead="<br/>"+$('#selectCollege').find("option:selected").text()+"/"+$('#selectMajor').find("option:selected").text()+":";
                    if(breakfastType.includes(label)){
                        //--------------------------------breakfast------------------------------------------
                        $('#graph_line_head').html("历年学生早餐情况人数统计"+curHead);
                        $('#graph_donut_head').html("早餐情况总比例"+curHead);
                        breakfast_data=data.content.countData;
                        var breakfastPercent=data.content.percentList;
                        breakfast_percent = [];
                        for(var i=0;i<=1;i++){
                            breakfast_percent.push({
                                label:breakfastType[i],
                                value: breakfastPercent[i]
                            });
                        }
                    }else if (mealType.includes(label)){
                        //--------------------------------meal------------------------------------------
                        $('#graph_line_head').html("历年学生三餐情况类型人数统计"+curHead);
                        $('#graph_donut_head').html("三餐情况总比例"+curHead);
                        meal_data=data.content.countData;
                        console.log(meal_data);
                        var mealPercent=data.content.percentList;
                        meal_percent = [];
                        for(var i=0;i<=2;i++){
                            meal_percent.push({
                                label:mealType[i],
                                value: mealPercent[i]
                            });
                        }
                    }else if(consumptionType.includes(label)){
                        //----------------------------consumption------------------------------------
                        $('#graph_line_head').html("历年学生消费情况类型人数统计"+curHead);
                        $('#graph_donut_head').html("消费情况总比例"+curHead);
                        consumption_data=data.content.countData;
                        var consumptionPercent=data.content.percentList;
                        consumption_percent = [];
                        for(var i=0;i<=4;i++){
                            consumption_percent.push({
                                label:consumptionType[i],
                                value: consumptionPercent[i]
                            });
                        }
                    }else{
                        //-----------------------sleeplate-----------------------------------
                        $('#graph_line_head').html("历年学生晚睡情况类型人数统计"+curHead);
                        $('#graph_donut_head').html("晚睡情况总比例"+curHead);
                        sleeplate_data=data.content.countData;
                        var sleeplatePercent=data.content.percentList;
                        sleeplate_percent = [];
                        for(var i=0;i<=1;i++){
                            sleeplate_percent.push({
                                label:sleeplateType[i],
                                value: sleeplatePercent[i]
                            });
                        }
                    }

                    //显示line与donut两个图
                    getGraphByLabel(label);
                    //添加tab及绑定click事件
                    if(yearflag===0){
                        $('#myTab').html('<li class="active"><a id="'+data.content.countData[0].year+'">'+data.content.countData[0].year+'级</a></li>');
                        for(var i=1;i<data.content.countData.length;i++){
                            $('#myTab').append('<li><a id="'+data.content.countData[i].year+'">'+data.content.countData[i].year+'级</a></li>');
                        }
                        $('#myTab a').click(function (e) {
                            e.preventDefault();
                            $(this).tab('show');
                            var year=e.target.getAttribute('id');
                            getTable(curLabel,year,id);
                            document.getElementById("part_of_student").style.display="none";
                        });
                    }else{
                        $('#myTab').html('<li class="active"><a id="'+data.content.countData[0].year+'">'+data.content.countData[0].year+'学年</a></li>');
                        for(var i=1;i<data.content.countData.length;i++){
                            $('#myTab').append('<li><a id="'+data.content.countData[i].year+'">'+data.content.countData[i].year+'学年</a></li>');
                        }
                        $('#myTab a').click(function (e) {
                            e.preventDefault();
                            $(this).tab('show');
                            var year=e.target.getAttribute('id');
                            getTable(curLabel,year,id);
                            document.getElementById("part_of_student").style.display="none";
                            console.log(year);
                        });
                    }
                    //学生数据
                    if(yearflag===1)
                        getTable(label, data.content.countData[0].year,id);
                    else
                        getTable(label, data.content.countData[0].year,id);
                    //全局label
                    curLabel = label;
                    $('#myHead').html('当前标签：' + label);
                    document.getElementById("part_of_dataTable").style.display = "block";
                    document.getElementById("part_of_student").style.display="none";
                } else {
                    alert("查询失败:"+data.msg);
                }
            }
        });
    }

    function getGraphByLabel(label) {
        if($("#graph_line").empty()===false)
            $("#graph_line").remove();
        document.getElementById("part_of_graph").style.display="block";
        if(breakfastType.includes(label)){
            var index=breakfastType.indexOf(label);
            var colors=['#FF0000', '#66CD00'];//深虹绿蓝
            var lineColors=['#F08080', '#B4EEB4'];//浅
            lineColors[index]=colors[index];
            Morris.Area({
                element: 'graph_line',
                data:breakfast_data,
                xkey: 'year',
                ykeys: ['breakfastLabel0','breakfastLabel1'],
                labels: breakfastType,
                units:'人',
                lineWidth: 1,
                pointSize: 5,
                lineColors: lineColors,
                fillOpacity: 0.5,
                smooth: true,
                parseTime:false
            });
            Morris.Donut({
                element: 'graph_donut',
                data: breakfast_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
        else if(mealType.includes(label)){
            var index=mealType.indexOf(label);
            var colors=['#FF0000', '#66CD00', '#1874CD'];//深虹绿蓝
            var lineColors=['#F08080', '#B4EEB4', '#B0E2FF'];//浅
            lineColors[index]=colors[index];
            Morris.Area({
                element: 'graph_line',
                data:meal_data,
                xkey: 'year',
                ykeys: ['mealLabel0','mealLabel1','mealLabel2'],
                labels: mealType,
                units:'人',
                lineWidth: 1,
                pointSize: 5,
                lineColors:lineColors,
                fillOpacity: 0.5,
                smooth: true,
                parseTime:false
            });
            Morris.Donut({
                element: 'graph_donut',
                data: meal_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
        else if(consumptionType.includes(label)){

            var index=consumptionType.indexOf(label);
            var colors=['#FF0000', '#66CD00', '#1874CD','#FF0000', '#66CD00'];//深虹绿蓝
            var lineColors=['#F08080', '#B4EEB4', '#B0E2FF','#F08080', '#B4EEB4'];//浅
            lineColors[index]=colors[index];
            Morris.Area({
                element: 'graph_line',
                data:consumption_data,
                xkey: 'year',
                ykeys: ['consumptionLabel0','consumptionLabel1','consumptionLabel2','consumptionLabel3','consumptionLabel4'],
                labels: consumptionType,
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                // hideHover: 'auto',
                lineWidth: 1,
                pointSize: 5,
                lineColors:lineColors,
                fillOpacity: 0.5,
                smooth: true,
                parseTime:false
            });
            Morris.Donut({
                element: 'graph_donut',
                data: consumption_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        } else{

            var index=sleeplateType.indexOf(label);
            var colors=['#FF0000', '#66CD00'];//深虹绿蓝
            var lineColors=['#F08080', '#B4EEB4'];//浅
            lineColors[index]=colors[index];
            Morris.Area({
                element: 'graph_line',
                data:sleeplate_data,
                xkey: 'year',
                ykeys: ['sleeplateLabel0','sleeplateLabel1'],
                labels: sleeplateType,
                // xmax:"auto",
                // ymax:"auto",
                units:'人',
                // hideHover: 'auto',
                lineWidth: 1,
                pointSize: 5,
                lineColors:lineColors,
                fillOpacity: 0.5,
                smooth: true,
                parseTime:false
            });
            Morris.Donut({
                element: 'graph_donut',
                data: sleeplate_percent,
                colors: lineColors,
                formatter: function (y) { return y + "%" }
            });
        }
    }

    var behaviorTable=null;
    var studentCloud=null;
    function checkStudent(studentId){
        document.getElementById("part_of_student").style.display="block";
        if (behaviorTable===null)
            ;
        else{
            behaviorTable.destroy();
        }
        if (studentCloud===null)
            ;
        else{
            $("#student_cloud_panel").html('<div id="student_cloud"></div>');
        }
        $.ajax({
            url:$('base').attr('href')+"consumption/allDataByStudent",
            type: "post",
            dataType: 'json',
            data:{'studentId':studentId},
            success: function (data) {
                if (data.code === 100) {
                    var labels=data.content.studentLabels;
                    var studentData=data.content.studentData;
                    var studentBehaviorData=data.content.studentBehaviorData;
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
                    console.log(studentBehaviorData);
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
                    $('#curYear').html(studentData.year);
                    $('#curClassId').html(studentData.classid);
                    $('#curBreakfastLabel').html(studentData.breakfastLabel);
                    $('#curMealLabel').html(studentData.mealLabel);
                    $('#curConsumptionLabel').html(studentData.consumptionLabel);
                    $('#curSleeplateLabel').html(studentData.sleeplateLabel);
                    behaviorTable=$('#behaviorTable').DataTable({
                        paging:false,
                        searchable:false,
                        autoWidth:false,
                        info:false,
                        filter:false,//搜索框
                        ordering: false,
                        destroy:true,
                        stateSave:false,
                        data:studentBehaviorData,
                        columns:[
                            { "data": "year" },
                            { "data": "term" },
                            { "data": null,"render":function(data,type,row){
                                    return breakfastType[data.breakfastLabel].substr(0);
                                }},
                            { "data": null,"render":function(data,type,row){
                                    return mealType[data.mealLabel].substr(0);
                                }},
                            { "data": null,"render":function(data,type,row){
                                    return consumptionType[data.consumptionLabel].substr(0);
                                }},
                            { "data": null,"render":function(data,type,row){
                                    return sleeplateType[data.sleeplateLabel].substr(0);
                                }}
                        ]
                    });
                } else {
                    //$("#errorMsg").text(data.msg);
                    $('#subbtn').attr("disabled",false);
                    changeImage();
                    $.Toast("查询学生行为画像失败", data.msg, "warning", {
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

    var myTable=null;
    function getTable(label,year,id){
        if (myTable===null)
            ;
        else{
            $('#myTable thead tr').html('');
            myTable.destroy();
        }
        var columns;
        if(breakfastType.includes(label)){
            $('#myTable thead tr').html(/*'<th class=\"text-center\">年级</th>\n' +*/
                '                                        <th class=\"text-center\">班级</th>\n' +
                '                                        <th class=\"text-center\">学号</th>\n' +
                '                                        <th class=\"text-center\">姓名</th>\n' +
                /*'                                        <th class=\"text-center\">早餐情况</th>\n' +*/
                '                                        <th class=\"text-center\">操作</th>');
            columns=[
                /*{ "data": "year" },*/
                { "data": "classid" },
                { "data": "studentid" },
                { "data": "studentname" },
                /*{ "data": "breakfastLabel" },*/
                { "data": null,"render":function(data,type,row){
                        var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('"+row.studentid.toString()+"')\">查看学生</button>";
                        return button;
                    }}
            ];
        }
        else if(mealType.includes(label)){
            $('#myTable thead tr').html(/*'<th class="text-center">年级</th>\n' +*/
                '                                        <th class="text-center">班级</th>\n' +
                '                                        <th class="text-center">学号</th>\n' +
                '                                        <th class="text-center">姓名</th>\n' +
                /*'                                        <th class="text-center">三餐情况</th>\n' +*/
                '                                        <th class="text-center">操作</th>');
            columns=[
                /*{ "data": "year" },*/
                { "data": "classid" },
                { "data": "studentid" },
                { "data": "studentname" },
                /*{ "data": "mealLabel" },*/
                { "data": null,"render":function(data,type,row){
                        var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('"+row.studentid.toString()+"')\">查看学生</button>";
                        return button;
                    }}
            ];
        }else if(consumptionType.includes(label)){
            $('#myTable thead tr').html(/*'<th class="text-center">年级</th>\n' +*/
                '                                        <th class="text-center">班级</th>\n' +
                '                                        <th class="text-center">学号</th>\n' +
                '                                        <th class="text-center">姓名</th>\n' +
                /*'                                        <th class="text-center">消费情况</th>\n' +*/
                '                                        <th class="text-center">操作</th>');
            columns=[
                /*{ "data": "year" },*/
                { "data": "classid" },
                { "data": "studentid" },
                { "data": "studentname" },
                /*{ "data": "consumptionLabel" },*/
                { "data": null,"render":function(data,type,row){
                        var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('"+row.studentid.toString()+"')\">查看学生</button>";
                        return button;
                    }}
            ];
        }else{
            $('#myTable thead tr').html(/*'<th class="text-center">年级</th>\n' +*/
                '                                        <th class="text-center">班级</th>\n' +
                '                                        <th class="text-center">学号</th>\n' +
                '                                        <th class="text-center">姓名</th>\n' +
                /*'                                        <th class="text-center">晚睡情况</th>\n' +*/
                '                                        <th class="text-center">操作</th>');
            columns=[
                /*{ "data": "year" },*/
                { "data": "classid" },
                { "data": "studentid" },
                { "data": "studentname" },
                /*{ "data": "sleeplateLabel" },*/
                { "data": null,"render":function(data,type,row){
                        var button="<button type=\"button\" class=\"btn btn-info\" onclick=\"checkStudent('"+row.studentid.toString()+"')\">查看学生</button>";
                        return button;
                    }}
            ];
        }



        // DataTable
        myTable = $('#myTable').DataTable({
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
                url: $('base').attr('href') + "consumption/studentBehaviorDataByLabelAndId",
                async:true,
                cache:true,
                data:function(d){
                    console.log('打印d');
                    console.log(d);
                    // var param = new FormData();
                    var param={};
                    var pageNum=(d.start+d.length)/d.length;
                    var draw=d.draw;
                    param.label=label;
                    param.year=year;
                    param.id=id;
                    param.pageNum=pageNum;
                    param.draw=draw;
                    return param;
                },
                dataFilter:function (data) {
                    var result=JSON.parse(data);
                    if(result.code === 100){
                        var pb=result.content.datawithpage;
                        var returnData={};
                        returnData.draw=pb.draw;
                        returnData.recordsTotal=pb.totalRecord;
                        returnData.recordsFiltered=pb.totalRecord;
                        returnData.data=pb.list;
                        return JSON.stringify(returnData);
                    }else if (result.code=== 200){
                        alert('datatable错误');
                    }
                }
            },
            columns:columns

        });
    }

</script>


</body>
</html>




