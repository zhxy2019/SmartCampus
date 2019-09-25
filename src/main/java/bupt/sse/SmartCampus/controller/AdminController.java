package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.service.StudentService;
import bupt.sse.SmartCampus.utils.Message;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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


    //=======================================================
    @Autowired
    StudyProfileController studyProfileController;

    @RequestMapping("/study")
    public String study(){
        return "studyProfileAdmin";
    }

    @RequestMapping("/searchStudent_admin")
    @ResponseBody
    public Message searchStudent_admin(HttpSession session,
                                 @RequestParam(value ="collegeName", required = false) String collegeName,
                                 @RequestParam(value ="majorName", required = false) String majorName,
                                 @RequestParam(value ="grade", required = false) String grade,
                                 @RequestParam(value ="studentId", required = false) String studentId,
                                 @RequestParam(value ="studentName", required = false) String studentName,
                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                 @RequestParam(value = "draw", required = false)Integer draw){
        return studyProfileController.searchStudent_admin(session,collegeName, majorName,grade,studentId, studentName,pageNum,draw);
    }

    //获取某学院或某专业某个标签下的各年级/学年统计数据及总占比
    @RequestMapping("/countDataByLabelAndId_admin")
    @ResponseBody
    public Message countDataByLabelAndId_admin(HttpSession session,
                                         @RequestParam(value ="label", required = false) String label,
                                         @RequestParam(value ="id", required = false) String id
    ){
        return studyProfileController.countDataByLabelAndId_admin(session,label,id);
    }

    //抽取符合标签的学生数据
    @RequestMapping("/studentDataByLabelAndId_admin")
    @ResponseBody
    public Message studentDataByLabelAndId_admin(HttpSession session,
                                                 @RequestParam(value ="label", required = false) String label,
                                                 @RequestParam(value ="grade", required = false) String grade,
                                                 @RequestParam(value ="id", required = false) String id,
                                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                                 @RequestParam(value = "draw", required = false)Integer draw)throws IOException {
        return studyProfileController.studentDataByLabelAndId_admin(session,label,grade,id,pageNum,draw);
    }

    //获取某个学生的所有数据
    @RequestMapping("/allDataByStudent")
    @ResponseBody
    public Message allDataByStudent(HttpSession session,
                                    @RequestParam(value ="studentId", required = false) String studentId)throws IOException{
        return studyProfileController.allDataByStudent(session,studentId);
    }

    //某学生某学年所有课程成绩信息
    @RequestMapping("/courseDataByStudent")
    @ResponseBody
    public Message courseDataByStudent(HttpSession session,
                                       @RequestParam(value ="studentId", required = false) String studentId,
                                       @RequestParam(value ="year", required = false) String year)throws IOException {
        return studyProfileController.courseDataByStudent(session,studentId,year);
    }

    //所有学院信息
    @RequestMapping("/collegeIdAndName")
    @ResponseBody
    public Message collegeIdAndName(HttpSession session)throws IOException {
        return studyProfileController.collegeIdAndName(session);
    }

    //某学院所有专业信息
    @RequestMapping("/majorIdAndName")
    @ResponseBody
    public Message majorIdAndName(HttpSession session,
                                  @RequestParam(value ="collegeId", required = false) String collegeId)throws IOException {
        return studyProfileController.majorIdAndName(session,collegeId);
    }

    //=======================================================

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
