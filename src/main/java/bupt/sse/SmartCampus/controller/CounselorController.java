package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.service.StudentService;
import bupt.sse.SmartCampus.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/counselor")
public class CounselorController {
    @Autowired
    StudyProfileController studyProfileController;
    @RequestMapping("/study")
    public String study(){
        return "studyProfileCounselor";
    }

    @RequestMapping("/searchStudent_counselor")
    @ResponseBody
    public Message searchStudent(HttpSession session,
                                 @RequestParam(value ="classId", required = false) String classId,
                                 @RequestParam(value ="studentId", required = false) String studentId,
                                 @RequestParam(value ="studentName", required = false) String studentName,
                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                 @RequestParam(value = "draw", required = false)Integer draw){
        return studyProfileController.searchStudent_counselor(session,classId,studentId, studentName,pageNum,draw);
    }

    //获取某辅导员所有或某个班级的统计数据及总占比
    @RequestMapping("/countDataByLabelAndId_counselor")
    @ResponseBody
    public Message countDataByLabelAndId_counselor(HttpSession session,
                                               @RequestParam(value ="label", required = false) String label,
                                               @RequestParam(value ="id", required = false) String id){
        return studyProfileController.countDataByLabelAndId_counselor(session,label,id);
    }

    //抽取符合标签的学生数据
    @RequestMapping("/studentDataByLabelAndId_counselor")
    @ResponseBody
    public Message studentDataByLabelAndId_counselor(HttpSession session,
                                                 @RequestParam(value ="label", required = false) String label,
                                                 @RequestParam(value ="year", required = false) String year,
                                                 @RequestParam(value ="id", required = false) String id,
                                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                                 @RequestParam(value = "draw", required = false)Integer draw)throws IOException {
        return studyProfileController.studentDataByLabelAndId_counselor(session,label,year,id,pageNum,draw);
    }

    //获取某个辅导员所有班级信息
    @RequestMapping("/classIdByCounselor")
    @ResponseBody
    public Message classIdByCounselor(HttpSession session)throws IOException {
        return studyProfileController.classIdByCounselor(session);
    }

    //获取某个学生的所有数据
    @RequestMapping("/allDataByStudent")
    @ResponseBody
    public Message allDataByStudent(HttpSession session,
                                    @RequestParam(value ="studentId", required = false) String studentId)throws IOException {
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
    //cxp
    @Autowired
    MainController mainController;
    //注入学生service
    @Autowired
    StudentService studentService;
    //获取菜单统计数据，在校生人数、有留级风险人数、有退学风险人数
    @RequestMapping(value = "/getMenuData",method = RequestMethod.POST)
    @ResponseBody
    public Message getMenuData(HttpSession session){
        return mainController.getMenuData_counselor(session);
    }
    //获取首页挂科告警百分比
    @RequestMapping(value = "/getAlertPercentage",method = RequestMethod.POST)
    @ResponseBody
    public Message getAlertPercentage(HttpSession session){
        return mainController.getAlertPercentage_counselor(session);
    }
    //获取所管理预测挂科的学生列表
    @RequestMapping(value = "/getPredictStudentList",method = RequestMethod.POST)
    @ResponseBody
    public Message getPredictStudentList(@RequestBody Map<String,String> req,HttpSession session){
        return mainController.getPredictStudentList_counselor(req,session);
    }
//
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
}
