package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.model.*;
import bupt.sse.SmartCampus.model.Class;
import bupt.sse.SmartCampus.service.*;
import bupt.sse.SmartCampus.utils.Message;
import bupt.sse.SmartCampus.utils.PageBean;
import net.sf.json.JSONObject;
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
public class StudyProfileController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentStudyService studentStudyService;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ClassService classService;


    public Message searchStudent_admin(HttpSession session,String collegeName,String majorName,String grade,String studentId,
                                      String studentName,Integer pageNum,Integer draw) {
        System.out.println("====================searchStudent_admin" + grade + studentId + studentName + "=======================");
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

    public Message searchStudent_counselor(HttpSession session,String classId,String studentId,
                                       String studentName,Integer pageNum,Integer draw) {
        System.out.println("====================searchStudent_counselor" + classId + studentId + studentName + "=======================");
        Message result;
        User user = (User) session.getAttribute("user");
        if (user != null) {
            JSONObject counselor=(JSONObject) session.getAttribute("counselor");
            String counselorId= counselor.getString("counselorid");
            classId="%"+classId+"%";
            studentId="%"+studentId+"%";
            studentName="%"+studentName+"%";
            int totalRecord;
            int pageSize=10;
            List<Map> recordWithPageSize;
            totalRecord=studentService.fizzySearchSum_counselor(counselorId,classId,studentId,studentName,pageNum,pageSize);
            recordWithPageSize=studentService.fizzySearchData_counselor(counselorId,classId,studentId,studentName,pageNum,pageSize);
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
    public Message countDataByLabelAndId_admin(HttpSession session,String label,String id
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

    //获取某辅导员下所有或某班级的统计数据及标签占比
    public Message countDataByLabelAndId_counselor(HttpSession session,String label,String id){
        System.out.println("====================countDataByLabelAndId_counselor"+label+id+"=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            JSONObject counselor=(JSONObject) session.getAttribute("counselor");
            String counselorId= counselor.getString("counselorid");
            List<Integer> countList=new ArrayList<>();
            Map<String,Long> sumData;
            int index=studentService.getIndex(label);
            if (index<3){
                Map<String,Long> countGrindData=studentService.getCountGrindDataById_counselor(counselorId,id);
                for(String key : countGrindData.keySet()) {
                    countList.add(countGrindData.get(key).intValue());
                }
                result=Message.success().add("countData",countList);
                sumData=countGrindData;
                System.out.println(sumData);
            }
            else if(index>6){
                List<Map> countAscendData=studentService.getCountAscendDataById_counselor(counselorId,id);
                result=Message.success().add("countData",countAscendData);
                sumData=studentService.getSumAscendDataById_counselor(counselorId,id);
            }
            else{
                Map<String,Long> countFailData=studentService.getCountFailDataById_counselor(counselorId,id);
                for(String key : countFailData.keySet()) {
                    countList.add(countFailData.get(key).intValue());
                }
                result=Message.success().add("countData",countList);
                sumData=countFailData;
                System.out.println(sumData);
            }
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
            result.add("percentList",percentList);
            return result;
        }
        return Message.fail("请先登录系统！");
    }


    //抽取符合标签的学生数据
    public Message studentDataByLabelAndId_admin(HttpSession session,String label,String grade,
                                                 String id,Integer pageNum,Integer draw)throws IOException{
        System.out.println("====================studentDataByLabelAndId"+label+id+grade+"=======================");
        Message result;
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

    //抽取符合标签的学生数据-辅导员
    public Message studentDataByLabelAndId_counselor(HttpSession session,String label,String year,
                                                 String id,Integer pageNum,Integer draw)throws IOException{
        System.out.println("====================studentDataByLabelAndId"+label+id+year+"=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            JSONObject counselor=(JSONObject) session.getAttribute("counselor");
            String counselorId= counselor.getString("counselorid");
            int totalRecord;
            int pageSize=10;
            List<Student> recordWithPageSize;
            totalRecord=studentService.getStudentSumByLabelAndYearAndId_counselor(label,year,counselorId,id);
            recordWithPageSize=studentService.getStudentPageDataByLabelAndYearAndId_counselor(label,year,counselorId,id,pageNum,pageSize);

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
    public Message allDataByStudent(HttpSession session,String studentId)throws IOException{
        System.out.println("====================allDataByStudent"+studentId+"=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
//            List<String> studentLabels=studentService.getLabelsByStudentId(studentId);
            Student curStudent=studentService.getStudentDataByStudentId(studentId);
            College curClass=collegeService.getCollegeDataByStudentId(studentId);
            List<StudentStudy> curStudentStudyList=studentStudyService.getStudentStudyDataByStudentId(studentId);
            String[] studyLabels={"学习优秀","学习普通","学习困难","无挂科","有挂科","有留级风险","有退学风险","成绩上升","成绩稳定","成绩下降"};
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
    public Message courseDataByStudent(HttpSession session,String studentId,String year)throws IOException {
        System.out.println("====================courseDataByStudent" + studentId + "=======================");
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
    public Message majorIdAndName(HttpSession session,String collegeId)throws IOException {
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

    //某辅导员所有班级信息
    public Message classIdByCounselor(HttpSession session)throws IOException {
        System.out.println("====================classIdByCounselor=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            JSONObject counselor=(JSONObject) session.getAttribute("counselor");
            String counselorId= counselor.getString("counselorid");
            List<Integer> classDataList=classService.getClassIdByCounselorId(counselorId);
            System.out.println(classDataList);
            result=Message.success().add("classData",classDataList);
            return result;
        }
        return Message.fail("请先登录系统！");
    }

}
