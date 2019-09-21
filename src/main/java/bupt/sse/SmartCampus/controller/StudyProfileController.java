package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.model.*;
import bupt.sse.SmartCampus.model.Class;
import bupt.sse.SmartCampus.service.*;
import bupt.sse.SmartCampus.utils.Message;
import bupt.sse.SmartCampus.utils.PageBean;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/study")
public class StudyProfileController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentStudyService studentStudyService;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/")
    public String index(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            return "studyProfile";
        }
        return "login";
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
                                 @RequestParam(value = "draw", required = false)Integer draw) {
        System.out.println("====================searchStudent" + grade + studentId + studentName + "=======================");
        System.out.println(collegeName);
        System.out.println(majorName);
        System.out.println(grade);
        System.out.println(studentId);
        System.out.println(studentName);
        Message result;
        User user = (User) session.getAttribute("user");
        if (user != null) {
            collegeName="%"+collegeName+"%";
            majorName="%"+majorName+"%";
            grade="%"+grade+"%";
            studentId="%"+studentId+"%";
            studentName="%"+studentName+"%";
            int totalRecord;
            int pageSize=10;
            List<Map> recordWithPageSize;
            totalRecord=studentService.fizzySearchSum(collegeName,majorName,grade,studentId,studentName,pageNum,pageSize);
            recordWithPageSize=studentService.fizzySearchData(collegeName,majorName,grade,studentId,studentName,pageNum,pageSize);

            PageBean pb=new PageBean(pageNum,pageSize,totalRecord,draw);
            pb.setList(recordWithPageSize);
            if(pb == null){
                result=Message.fail("nopb");
            }else {
                result=Message.success().add("pb",pb);
            }
            return result;

        }
        return Message.fail("请先登录系统！");
    }


    //获取某学院或某专业某个标签下的各年级/学年统计数据及总占比
    @RequestMapping("/countDataByLabelAndId")
    @ResponseBody
    public Message countDataByLabelAndId(HttpSession session,
                                         @RequestParam(value ="label", required = false) String label,
                                         @RequestParam(value ="id", required = false) String id
    ){
        System.out.println("====================countDataByLabelAndId"+label+id+"=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            List<Map> countData=studentService.getCountDataByLabelAndId(label,id);
            Map<String,Long> sumData=studentService.getSumDataByLabelAndId(label,id);

            List<Integer> percentList=new ArrayList<>();
            Integer sum=0;
            for(String key : sumData.keySet()) {
                sum = sum + sumData.get(key).intValue();
            }
            for(String key : sumData.keySet()){
                if (sum==0){
                    return Message.fail("数据缺失！");
                }else{
                    percentList.add(sumData.get(key).intValue()*100/sum);
                }
            }
            result=Message.success().add("percentList",percentList).add("countData",countData);
            return result;


        }
        return Message.fail("请先登录系统！");
    }


    //抽取符合标签的学生数据
    @RequestMapping("/studentDataByLabelAndId")
    @ResponseBody
    public Message studentDataByLabelAndId(@RequestParam(value ="label", required = false) String label,
                                      @RequestParam(value ="grade", required = false) String grade,
                                      @RequestParam(value ="id", required = false) String id,
                                      @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                      @RequestParam(value = "draw", required = false)Integer draw,
                                      HttpSession session)throws IOException{
        System.out.println("====================studentDataByLabelAndId"+label+id+grade+"=======================");
        Message result;
        System.out.println(id);
        User user= (User) session.getAttribute("user");
        if(user!=null){
        //已经登录,跳转到学业画像页面
            int totalRecord;
            int pageSize=10;
            List<Student> recordWithPageSize;
            totalRecord=studentService.getStudentSumByLabelAndGradeAndId(label,grade,id);
            recordWithPageSize=studentService.getStudentPageDataByLabelAndGradeAndId(label,grade,id,pageNum,pageSize);

            PageBean pb=new PageBean(pageNum,pageSize,totalRecord,draw);
            pb.setList(recordWithPageSize);
            if(pb == null){
                result=Message.fail("nopb");
            }else {
                result=Message.success().add("datawithpage",pb);
            }
            System.out.print("打印pb:");
            System.out.print(pb);
            return result;
        }
        return Message.fail("请先登录系统！");
    }



    //获取某个学生的所有数据
    @RequestMapping("/allDataByStudent")
    @ResponseBody
    public Message allDataByStudent(@RequestParam(value ="studentId", required = false) String studentId,
                                    HttpSession session)throws IOException{
        System.out.println("====================allDataByStudent"+studentId+"=======================");
        System.out.println(studentId);
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
//            List<String> studentLabels=studentService.getLabelsByStudentId(studentId);
            Student curStudent=studentService.getStudentDataByStudentId(studentId);
            College curClass=collegeService.getCollegeDataByStudentId(studentId);
            List<StudentStudy> curStudentStudyList=studentStudyService.getStudentStudyDataByStudentId(studentId);
            String[] studyLabels={"学霸","学习普通","学渣","无挂科","有挂科","有留级风险","有退学风险","成绩上升","成绩稳定","成绩下降"};
            List<String> curStudentLabels=new ArrayList<>();
            if (curStudent!=null){
                curStudentLabels.add(studyLabels[curStudent.getGrind()]);
                curStudentLabels.add(studyLabels[curStudent.getFail()+3]);
            }
            if (curStudentStudyList.size()!=0){
                for(int i=0;i<curStudentStudyList.size();i++){
                    String curAscendLabel=studyLabels[curStudentStudyList.get(i).getAscend()+7];
                    if (curStudentLabels.contains(curAscendLabel))
                        continue;
                    else
                        curStudentLabels.add(curAscendLabel);
                }
            }

            if (curStudentLabels==null)
                result=Message.fail("nodata");
            else
                result=Message.success().add("studentLabels",curStudentLabels)
                        .add("studentData",curStudent)
                        .add("studentStudyData",curStudentStudyList)
                        .add("classData",curClass);

            return result;
        }
        return Message.fail("请先登录系统！");
    }

    //某学生某学年所有课程成绩信息
    @RequestMapping("/courseDataByStudent")
    @ResponseBody
    public Message courseDataByStudent(@RequestParam(value ="studentId", required = false) String studentId,
                                       @RequestParam(value ="year", required = false) String year,
                                       HttpSession session)throws IOException {
        System.out.println("====================courseDataByStudent" + studentId + "=======================");
        System.out.println(studentId);
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Map> courseDataList=studentCourseService.getCourseDataByStudentId(studentId,year);
            result=Message.success().add("courseData",courseDataList);
            return result;
        }
        return Message.fail("请先登录系统！");
    }



    //所有学院信息
    @RequestMapping("/collegeIdAndName")
    @ResponseBody
    public Message collegeIdAndName(HttpSession session)throws IOException {
        System.out.println("====================collegeIdAndName=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Map> collegeDataList=collegeService.getAllCollegeIdAndName();
            result=Message.success().add("collegeData",collegeDataList);
            return result;
        }
        return Message.fail("请先登录系统！");
    }



    //某学院所有专业信息
    @RequestMapping("/majorIdAndName")
    @ResponseBody
    public Message majorIdAndName(HttpSession session,
                                  @RequestParam(value ="collegeId", required = false) String collegeId)throws IOException {
        System.out.println("====================majorIdAndName=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Map> majorDataList=collegeService.getMajorIdAndNameByCollegeId(collegeId);
            System.out.println(majorDataList);
            result=Message.success().add("majorData",majorDataList);
            return result;
        }
        return Message.fail("请先登录系统！");
    }

}
