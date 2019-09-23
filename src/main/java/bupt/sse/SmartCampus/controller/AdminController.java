package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.service.StudentService;
import bupt.sse.SmartCampus.utils.Message;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MainController mainController;
    //注入学生service
    @Autowired
    StudentService studentService;
    //获取菜单统计数据，在校生人数、有留级风险人数、有退学风险人数
    @RequestMapping(value = "/getMenuData",method = RequestMethod.POST)
    @ResponseBody
    public Message getMenuData(){
        return mainController.getMenuData_admin();
    }
    //获取菜单统计数据，在校生人数、有留级风险人数、有退学风险人数
    @RequestMapping(value = "/getFailChartData",method = RequestMethod.POST)
    @ResponseBody
    public Message getFailChartData(){
        return mainController.getFailChartData_admin();
    }
    //获取点击的某学院预测挂科的学生列表
    @RequestMapping(value = "/getPredictStudentList",method = RequestMethod.POST)
    @ResponseBody
    public Message getPredictStudentList(@RequestBody Map<String,String> req){
        return mainController.getPredictStudentList_admin(req);
    }

    //获取点击的某学生对应预测成绩课程详情
    @RequestMapping(value = "/getPredictCourse",method = RequestMethod.POST)
    @ResponseBody
    public Message getPredictCourse(@RequestParam("studentId") String studentId){
        return mainController.getPredictCourse_admin(studentId);
    }
    //获取点击的学生可能挂科的课程原因列表
    @RequestMapping(value = "/getReasonList",method = RequestMethod.POST)
    @ResponseBody
    public Message getReasonList(@RequestParam("studentId") String studentId,@RequestParam("courseId") String courseId){
        return mainController.getReasonList_admin(studentId,courseId);
    }
    //获取点击的学生的所有标签
    @RequestMapping(value = "/getStudentLabel",method = RequestMethod.POST)
    @ResponseBody
    public Message getStudentLabel(@RequestParam("studentId") String studentId){
        return mainController.getStudentLabel_admin(studentId);
    }
    //获取首页挂科告警百分比
    @RequestMapping(value = "/getAlertPercentage",method = RequestMethod.POST)
    @ResponseBody
    public Message getAlertPercentage(@RequestParam("collegeName") String collegeName){
        return mainController.getAlertPercentage_admin(collegeName);
    }
}
