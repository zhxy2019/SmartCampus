package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/counselor")
public class CounselorController {
    @Autowired
    StudyProfileController studyProfileController;
    @RequestMapping("/study")
    public String study(){
        return "studyProfile";
    }

    @RequestMapping("/searchStudent")
    @ResponseBody
    public Message searchStudent(HttpSession session,
                                 @RequestParam(value ="collegeName", required = false) String collegeName,
                                 @RequestParam(value ="majorName", required = false) String majorName,
                                 @RequestParam(value ="grade", required = false) String grade,
                                 @RequestParam(value ="studentId", required = false) String studentId,
                                 @RequestParam(value ="studentName", required = false) String studentName,
                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                 @RequestParam(value = "draw", required = false)Integer draw){
        return studyProfileController.searchStudent(session,collegeName, majorName,grade,studentId,
                studentName,pageNum,draw);
    }
}
