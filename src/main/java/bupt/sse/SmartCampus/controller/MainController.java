package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.model.PredictScore;
import bupt.sse.SmartCampus.model.Student;
import bupt.sse.SmartCampus.service.PredictScoreService;
import bupt.sse.SmartCampus.service.StudentService;
import bupt.sse.SmartCampus.utils.Message;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class MainController {
    //注入学生service
    @Autowired
    StudentService studentService;
    @Autowired
    PredictScoreService predictScoreService;
    private Integer getCurrentGrade(){
        //获取当前年份
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int currentGrade=0;
        if(month<7){
            //7月之前year-4还是在校生
            currentGrade=year-4;
        }else{
            currentGrade=year-3;
        }
        return currentGrade;
    }
    //获取菜单统计数据，在校生人数、有留级风险人数、有退学风险人数
    public Message getMenuData_admin(){
        Message result= null;
        int currentGrade=getCurrentGrade();
        //查询在校生人数
        long studentNum=studentService.getStudentSumInSchool(currentGrade);
        //查询在校生中有留级风险人数,标签value为2
        long studentNum_fail=studentService.getStudentSumInSchoolByFail(currentGrade,2);
        //查询在校生中有退学风险的人数，标签value为3
        long studentNum_out=studentService.getStudentSumInSchoolByFail(currentGrade,3);
        result=Message.success().add("studentNum",studentNum).add("studentNum_fail",studentNum_fail).add("studentNum_out",studentNum_out);
        return result;
    }

    public Message getFailChartData_admin() {
        Message result= null;
        int currentGrade=getCurrentGrade();
        //获取各学院挂科率
        Map<String,List> percentage=studentService.getCollegeFailPercentage(currentGrade);
        result=Message.success().add("collegeNameList",percentage.get("collegeNameList")).add("percentageList",percentage.get("percentageList"));
        return result;
    }


    public Message getPredictStudentList_admin(Map<String, String> req) {
        Message result=null;
        String draw=req.get("draw");
        String startIndex = req.get("start");
        String pageSize = req.get("length");
//        String searchCondition = req.get("search");
//        if (searchCondition == "") {
//            searchCondition = null;
//        }
        String collegeName=req.get("collegeName");
        int currentGrade=getCurrentGrade();
        //因为当前只预测了2015级软件学院学生，所以currentGrade暂时设为2014
        currentGrade=2014;
        PageHelper.offsetPage(Integer.parseInt(startIndex), Integer.parseInt(pageSize));
        List<Student> predictStudentList=studentService.getPredictStudentList(collegeName,currentGrade);
        PageInfo<Student> pageInfo=new PageInfo<>(predictStudentList);
        Map<Object,Object> info=new HashMap<>();
        if(pageInfo!=null){
            info.put("pageData", pageInfo.getList());
            info.put("total", pageInfo.getTotal());
            info.put("draw", draw);
            result = Message.success().add("info", JSONObject.fromObject(info));
        }else {
            result = Message.fail("查询失败，请刷新重试!");
        }
        return result;
    }

    public Message getPredictCourse_admin(String studentId) {
        Message result=null;
        //从predictscore中查询该学生所有可能挂科课程成绩
        List<PredictScore> predictScores=predictScoreService.getPredictScoreWithCourse(studentId);
        if (predictScores!=null){
            result=Message.success().add("predictScoreList",predictScores);
        }else{
            result=Message.fail("查询挂科成绩失败，请重试！");
        }
        return result;
    }

    public Message getReasonList_admin(String studentId, String courseId) {
        Message result=null;
        //从predictscore中查询该学生所有可能挂科课程成绩
        List<PredictScore> predictScores=predictScoreService.getPredictScoreByStudentIdCourseId(studentId,courseId);
        if (predictScores!=null){
            PredictScore predictScore=predictScores.get(0);
            JSONObject reasonObject=JSONObject.fromObject(predictScore.getReason());
            List<String> cqlList=new ArrayList<>();
            Map<String,Integer> alreadyAdd=new HashMap<>();
            Iterator<String> sIterator = reasonObject.keys();
            while(sIterator.hasNext()){
                // 获得key
                String key = sIterator.next();
                JSONObject value = reasonObject.getJSONObject(key);
                String otherId= (String) value.get("otherId");
                if(!alreadyAdd.containsKey(otherId)){
                    String cql="Match p=(s:Student)-[:have]-(l)-[r1:have]-(other:Student)-[r2:get_score]-(c:Course) where s.studentId=\"%s\" and other.studentId=\"%s\" and (r1.term=r2.term or r1.term=\"all\") return p";
                    cql=String.format(cql,studentId,otherId,value.get("courseId"));
                    cqlList.add(cql);
                    alreadyAdd.put(otherId,1);
                }
            }
            result=Message.success().add("cqlList",cqlList);
        }else{
            result=Message.fail("查询挂科成绩失败，请重试！");
        }
        return result;
    }
}
