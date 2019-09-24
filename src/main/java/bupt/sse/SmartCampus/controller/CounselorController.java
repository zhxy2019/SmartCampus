package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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
}
