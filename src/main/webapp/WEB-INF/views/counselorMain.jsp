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
    <link href="static/assets/datatables/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="static/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/style-responsive.css" rel="stylesheet" />

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
                        <span class="username">${sessionScope.counselor.counselorname}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li><a href="<%=path%>/logout"><i class="icon-key"></i> Log Out</a></li>
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
                        <span>成绩分析预测</span>
                    </a>
                </li>

                <li>
                    <a href="counselor/study">
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
                            <h1 id="studentSumInSchool"class="count">
                                0
                            </h1>
                            <p>在校生人数</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <section class="panel">
                        <div class="symbol red">
                            <i class="icon-frown"></i>
                        </div>
                        <div class="value">
                            <h1 class="count2">
                                0
                            </h1>
                            <p>有留级风险人数</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <section class="panel">
                        <div class="symbol yellow">
                            <i class="icon-lightbulb"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count3">
                                0
                            </h1>
                            <p>有退学风险人数</p>
                        </div>
                    </section>
                </div>
            </div>
            <!--state overview end-->
            <div class="row">
                <div id="failChartContainer" class="col-lg-8">
                    <!--custom chart start-->
                    <div class="border-head">
                        <h3>各学院挂科人数占比</h3>
                    </div>
                    <div id="failChart" style="width:100%; height: 230px;"></div>
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
                <div class="col-sm-12">
                    <section id="predictStudentListPanel" class="panel">
                        <header id="predictStudentListHeader" class="panel-heading">
                            预测挂科学生名单
                        </header>
                        <table id="predictStudentList" class="table table-hover">
                            <thead>
                            <tr>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>专业</th>
                                <th>年级</th>
                                <th>已挂科数</th>
                                <th>预测挂科数</th>
                                <th>总加权成绩</th>
                                <th>总排名</th>
                                <th>标签</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </section>
                </div>
            </div>
            <div class="row">
                <div id="studentInfo" class="col-lg-4">

                </div>
                <div id="predictCourse" class="col-lg-8">
                    <!--work progress start-->
                    <section class="panel">
                        <div class="panel-body progress-panel">
                            <div class="task-progress">
                                <h1>预测可能挂科课程</h1>
                            </div>
                            <table id="predictCourseTable" class="table table-hover personal-task">
                                <thead>
                                <tr>
                                    <%--<th>课程名称</th>--%>
                                </tr>
                                </thead>
                                <tbody id="predictCourseTableBody">

                                </tbody>
                            </table>
                        </div>

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

<script class="include" type="text/javascript" src="static/js/jquery.dcjqaccordion.2.7.js"></script>

<!--common script for all pages-->
<script src="static/js/common-scripts.js"></script>

<!--script for this page-->
<script src="static/js/sparkline-chart.js"></script>
<script src="static/js/easy-pie-chart.js"></script>
<script src="static/assets/echarts/echarts.common.min.js"></script>
<script src="static/assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="static/js/count.js"></script>
<script type="text/javascript">
    function ajaxShowKnowledgeGraph(studentId,courseId) {
        //首先查询出所有reason并解析出otherId,otherCourseId,
        var basepath = $('base').attr('href');
        var getReasonListUrl=basepath+'admin/getReasonList';
        $.ajax({
            url: getReasonListUrl,
            async: true,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {studentId:studentId,courseId:courseId},
            success: function (data) {
                if (data.code==100) {

                } else {
                    $.Toast("查询预测原因失败", data.msg, "warning", {
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
                $.Toast("查询学生数量失败","请重试！", "warning", {
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
    }
    $(document).ready(function (e) {
        $('#predictStudentListPanel').hide();
        $('#studentInfo').hide();
        $('#predictCourse').hide();
        function showFailChart(failChart,dataAxis,data){
            var dataAxis=dataAxis;
            var option = {
                tooltip: {
                    formatter: function(params, ticket, callback) {
                        return dataAxis[params.dataIndex] + ":<br />" +
                            params.value+'%';
                    }
                },
                grid:{
                    x:45,
                    x2:20,
                    y:20,
                    y2:25,
                },
                xAxis: {
                    data: dataAxis,
                    axisLabel: {
                        inside: false,
                        textStyle: {
                            color: '#040404'
                        }
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    z: 10
                },
                yAxis: {
                    splitLine :{    //网格线
                        lineStyle:{
                            type:'dashed'    //设置网格线类型 dotted：虚线   solid:实线
                        },
                        show:true //隐藏或显示
                    },
                    axisLine: {
                        show: false
                    },
                    axisTick: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#999'
                        },
                        formatter:'{value}%'
                    }
                },
                dataZoom: [
                    {
                        type: 'inside'
                    }
                ],
                series: [
                    // { // For shadow
                    //     type: 'bar',
                    //     itemStyle: {
                    //         normal: {color: 'rgba(0,0,0,0.05)'}
                    //     },
                    //     barGap:'-100%',
                    //     barCategoryGap:'40%',
                    //     data: dataShadow,
                    //     animation: false
                    // },
                    {
                        type: 'bar',
                        itemStyle: {
                            normal: {
                                barBorderRadius:[5, 5, 0, 0],
                                formatter:'{a}%',
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#bfc2cd'},

                                    ]
                                ),
                            },
                            emphasis: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#e8403f'},
                                    ]
                                )
                            }
                        },
                        data: data
                    }
                ]
            };
            // Enable data zoom when user click bar.
            var zoomSize = 6;
            failChart.on('click', function (params) {
                failChart.dispatchAction({
                    type: 'dataZoom',
                    startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
                    endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
                });
                //获取选择的学院
                var selectCollegeName=dataAxis[params.dataIndex];
                //查询该学院所有可能挂科学生,并显示更新datatables
                ajaxGetPredictResult(selectCollegeName);
            });
            failChart.clear();
            failChart.setOption(option);
            /*窗口自适应，关键代码*/
            $(".sidebar-toggle-box").on("click",function () {
                failChart.resize();
            });
            window.onresize = function () {
                failChart.resize();
            };

        }
        function ajaxGetPredictResult(collegeName){
            var basepath = $('base').attr('href');
            var headerText=$("#predictStudentListHeader").text();
            $("#predictStudentListHeader").text(collegeName+'-'+headerText);
            $('#predictStudentListPanel').show();
            var predictScoreListTable = $('#predictStudentList').DataTable({
                serverSide: true,
                processing: true,//载入数据的时候是否显示载入中
                pageLength: 10,
                ordering: false,
                pagingType: "full_numbers",
                autoWidth: false,
                stateSave: true,
                searching: false,
                lengthChange: false,
                paging: true,
                scrollCollapse: true,
                destroy: true,
                //select: true,
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                ajax: {
                    type: "post",
                    url: basepath + "admin/getPredictStudentList",
                    async: true,
                    cache: true,
                    dataType: "json",
                    contentType: "application/json;charset=UTF-8",
                    data: function (d) {
                        var param={};
                        param.draw = d.draw;
                        param.start = d.start;
                        param.length = d.length;
                        var searchStr = $('#searchInput').val();
                        if (searchStr != null && searchStr != "") {
                            param.search = searchStr;
                        }
                        param.collegeName=collegeName;
                        return JSON.stringify(param);//自定义需要传递的参数。
                    },
                    dataFilter: function (data) {
                        result = JSON.parse(data);
                        if (result.code == 100) {
                            //封装返回数据
                            var returnData = {};
                            var info = result.content.info;
                            returnData.draw = info.draw;
                            returnData.recordsTotal = info.total;
                            returnData.recordsFiltered = info.total;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = info.pageData;//返回的数据列表
                            return JSON.stringify(returnData);//这几个参数都是datatable需要的，必须要
                        } else if (result.code == 200) {
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

                },
                "drawCallback": function (settings) {
                    //渲染完毕后的回调
                    //注册行点击事件
                },
                /*
                <th>学号</th>
                                <th>姓名</th>
                                <th>学院</th>
                                <th>专业</th>
                                <th>年级</th>
                                <th>已挂科数</th>
                                <th>预测挂科数</th>
                                <th>总加权成绩</th>
                                <th>总排名</th>
                 */
                columns: [
                    {"data": "studentid"},
                    {"data": "studentname"},
                    {"data": "majorname"},
                    {"data": "grade"},
                    {"data": "failurenum"},
                    {"data": "predictfailnum"},
                    {"data": "weightscore"},
                    {"data": "studentrank"},
                ],
                columnDefs:[{
                    targets: 8,
                    render: function (data, type, row, meta) {
                        var grind=row.grind;
                        var fail=row.fail;
                        var label=null;
                        if(grind==0){
                            label='<span class="badge bg-success">学霸</span>';
                        }else if(grind==1){
                            label='<span class="badge bg-info">学习普通</span>';
                        }else if(grind==2){
                            label='<span class="badge bg-important">学渣</span>';
                        }
                        if(fail==0){
                            label+='<span class="badge bg-success">无挂科</span>';
                        }else if(fail==1){
                            label+='<span class="badge bg-info">有挂科</span>';
                        }else if(fail==2){
                            label+='<span class="badge bg-warning">有留级风险</span>';
                        }else if(fail==3){
                            label+='<span class="badge bg-important">有退学风险</span>';
                        }
                        return label;
                    }
                }],
            });
            $('#predictStudentList').off("click").on('click', 'tr', function () {
                ajaxShowStudentDetail(predictScoreListTable.row(this).data());
            });
            $('#predictStudentList').mouseover(function(){
                $(this).css("cursor","Pointer");
            });
        }

        function ajaxShowStudentDetail(row) {
            var basepath = $('base').attr('href');
            $("#studentInfo").show();
            $("#predictCourse").show();
            $("#studentInfo").html(" <!--user info table start-->\n" +
                "                    <section class=\"panel\">\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <a href=\"#\" class=\"task-thumb\">\n" +
                "                                <%--<img src=\"img/avatar1.jpg\" alt=\"\">--%>\n" +
                "                            </a>\n" +
                "                            <div class=\"task-thumb-details\">\n" +
                "                                <h1><a href=\"#\">"+row.studentname+"</a></h1>\n" +
                "                                <p>"+row.collegename+"</p>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <table class=\"table table-hover personal-task\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <i class=\" icon-tasks\"></i>\n" +
                "                                </td>\n" +
                "                                <td>专业</td>\n" +
                "                                <td>"+row.majorname+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <i class=\" icon-tasks\"></i>\n" +
                "                                </td>\n" +
                "                                <td>学号</td>\n" +
                "                                <td>"+row.studentid+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <i class=\"icon-warning-sign\"></i>\n" +
                "                                </td>\n" +
                "                                <td>班级</td>\n" +
                "                                <td>"+row.classid+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <i class=\"icon-envelope\"></i>\n" +
                "                                </td>\n" +
                "                                <td>总加权成绩</td>\n" +
                "                                <td>"+row.weightscore+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <i class=\" icon-bell-alt\"></i>\n" +
                "                                </td>\n" +
                "                                <td>总排名</td>\n" +
                "                                <td>"+row.studentrank+"</td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </section>\n" +
                "                    <!--user info table end-->")
            //post 请求数据,学生挂科数据详情，以及图谱
            var getPredictCourseUrl=basepath+'admin/getPredictCourse';
            var studentid=row.studentid;
            var predictCourseTable = $('#predictCourseTable').DataTable({
                lengthChange: false,
                paging: false,
                searching: false,
                autoWidth: true,
                info: false,
                scrollY: "250px",
                scrollCollapse: true,
                destroy: true,
                ordering:false,
                //select: true,
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                ajax:{
                    url: getPredictCourseUrl,
                    async: true,
                    cache: false,
                    type: "post",
                    dataType: 'json',
                    data: {studentId:studentid},
                    dataFilter:function(data){
                        result=JSON.parse(data);
                        if (result.code == 100) {
                            //封装返回数据
                            var returnData = {};
                            returnData.data = result.content.predictScoreList;
                            return JSON.stringify(returnData);//这几个参数都是datatable需要的，必须要
                        } else if (result.code == 200) {
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
                },
                columns:[{
                    "data":"coursename"
                }],
                columnDefs:[{
                    targets: 1,
                    render: function (data, type, row, meta) {
                        var html=null;
                        html='<span class="badge bg-important">不及格</span>';
                        return html;
                    }
                },
                    {
                        targets: 2,
                        render: function (data, type, row, meta) {
                            var studentid=row.studentid;
                            var courseid=row.courseid;
                            var html=null;
                            html='<button class="btn btn-info btn-xs" onclick=ajaxShowKnowledgeGraph('+studentid+','+courseid+')> 点击查看详情</button>';
                            return html;
                        }
                    },],
            });
        }

        var basepath = $('base').attr('href');
        //post 请求数据，在校生人数、有留级风险人数
        var getMenuDataUrl=basepath+'admin/getMenuData';
        $.ajax({
            url: getMenuDataUrl,
            async: true,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {},
            success: function (data) {
                if (data.code==100) {
                    countUp(data.content.studentNum);
                    countUp2(data.content.studentNum_fail);
                    countUp3(data.content.studentNum_out);
                } else {
                    $.Toast("查询学生数量失败", data.msg, "warning", {
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
                $.Toast("查询学生数量失败","请重试！", "warning", {
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
        //请求挂科统计图数据
        var getFailChartData=basepath+'admin/getFailChartData';
        //初始化echarts
        var failChart=echarts.init(document.getElementById("failChart"));
        $.ajax({
            url: getFailChartData,
            async: true,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {},
            success: function (data) {
                if (data.code==100) {
                    var collegeNameList=data.content.collegeNameList;
                    var percentageList=data.content.percentageList;
                    showFailChart(failChart,collegeNameList,percentageList);
                } else {
                    $.Toast("查询学院挂科率失败", data.msg, "warning", {
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
                $.Toast("查询学院挂科率失败","请重试！", "warning", {
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

        $(document).on('mouseover','#container', function () {
            $(this).getNiceScroll().resize();
        });
    });
</script>
</body>
</html>
