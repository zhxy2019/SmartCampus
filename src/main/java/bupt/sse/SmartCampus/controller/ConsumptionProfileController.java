package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.model.*;
import bupt.sse.SmartCampus.service.*;
import bupt.sse.SmartCampus.utils.Message;
import bupt.sse.SmartCampus.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumption")
public class ConsumptionProfileController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private StudentBehaviorService studentBehaviorService;

    @RequestMapping("/")
    public String index(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到消费画像页面
            return "consumptionProfile";
        }
        return "login";
    }

    @RequestMapping("/searchStudent")
    @ResponseBody
    public Message searchStudent(HttpSession session,
                                 @RequestParam(value ="collegeName", required = false) String collegeName,
                                 @RequestParam(value ="majorName", required = false) String majorName,
                                 @RequestParam(value ="year", required = false) String year,
                                 @RequestParam(value ="studentId", required = false) String studentId,
                                 @RequestParam(value ="studentName", required = false) String studentName,
                                 @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                 @RequestParam(value = "draw", required = false)Integer draw) {
        System.out.println("====================searchStudent" + year + studentId + studentName + "=======================");
        System.out.println(collegeName);
        System.out.println(majorName);
        System.out.println(year);
        System.out.println(studentId);
        System.out.println(studentName);
        Message result;
        User user = (User) session.getAttribute("user");
        if (user != null) {
            collegeName="%"+collegeName+"%";
            majorName="%"+majorName+"%";
            year="%"+year+"%";
            studentId="%"+studentId+"%";
            studentName="%"+studentName+"%";
            int totalRecord;
            int pageSize=10;
            List<Map> recordWithPageSize;
            totalRecord=studentService.fizzySearchSum(collegeName,majorName,year,studentId,studentName,pageNum,pageSize);
            recordWithPageSize=studentService.fizzySearchData(collegeName,majorName,year,studentId,studentName,pageNum,pageSize);

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
    @RequestMapping("/countBehaviorDataByLabelAndId")
    @ResponseBody
    public Message countBehaviorDataByLabelAndId(HttpSession session,
                                         @RequestParam(value ="label", required = false) String label,
                                         @RequestParam(value ="id", required = false) String id
    ){
        System.out.println("====================countDataByLabelAndId"+label+id+"=======================");
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            List<Map> countData=studentService.getBehaviorCountDataByLabelAndId(label,id);
            Map<String,Long> sumData=studentService.getBehaviorSumDataByLabelAndId(label,id);

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
    @RequestMapping("/studentBehaviorDataByLabelAndId")
    @ResponseBody
    public Message studentBehaviorDataByLabelAndId(@RequestParam(value ="label", required = false) String label,
                                           @RequestParam(value ="year", required = false) String year,
                                           @RequestParam(value ="id", required = false) String id,
                                           @RequestParam(value = "pageNum", required = false)Integer pageNum,
                                           @RequestParam(value = "draw", required = false)Integer draw,
                                           HttpSession session)throws IOException{
        System.out.println("====================studentDataByLabelAndId"+label+id+year+"=======================");
        Message result;
        System.out.println(id);
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到消费画像页面
            int totalRecord;
            int pageSize=10;
            List<Student> recordWithPageSize;
            totalRecord=studentService.getStudentBehaviorSumByLabelAndGradeAndId(label,year,id);
            recordWithPageSize=studentService.getStudentBehaviorPageDataByLabelAndGradeAndId(label,year,id,pageNum,pageSize);

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
            //已经登录,跳转到消费画像页面
//            List<String> studentLabels=studentService.getLabelsByStudentId(studentId);
            Student curStudent=studentService.getStudentDataByStudentId(studentId);
            College curClass=collegeService.getCollegeDataByStudentId(studentId);
            List<StudentBehavior> curStudentBehaviorList= studentBehaviorService.getStudentBehaviorDataByStudentId(studentId);
            String[] behaviorLabels={"有早餐习惯","无早餐习惯","三餐很规律","三餐较规律","三餐不规律","消费较低","消费正常","消费较高","消费过高","消费过低","晚睡","不晚睡"};
            List<String> curStudentLabels=new ArrayList<>();
            if(curStudentBehaviorList.size()!=0){
                for(int i=0;i<curStudentBehaviorList.size();i++){
                    String curBreakfastLabel=behaviorLabels[curStudentBehaviorList.get(i).getBreakfastLabel()];
                    if(curStudentLabels.contains(curBreakfastLabel))
                        continue;
                    else
                        curStudentLabels.add(curBreakfastLabel);
                    String curMealLabel=behaviorLabels[curStudentBehaviorList.get(i).getMealLabel()+2];
                    if(curStudentLabels.contains(curMealLabel))
                        continue;
                    else
                        curStudentLabels.add(curMealLabel);
                    String curConsumptionLabel=behaviorLabels[curStudentBehaviorList.get(i).getConsumptionLabel()+5];
                    if(curStudentLabels.contains(curConsumptionLabel))
                        continue;
                    else
                        curStudentLabels.add(curConsumptionLabel);
                    String curSleeplateLabel=behaviorLabels[curStudentBehaviorList.get(i).getSleeplateLabel()+5];
                    if(curStudentLabels.contains(curSleeplateLabel))
                        continue;
                    else
                        curStudentLabels.add(curSleeplateLabel);
                }
            }

            if (curStudentLabels==null)
                result=Message.fail("nodata");
            else
                result=Message.success().add("studentLabels",curStudentLabels)
                        .add("studentData",curStudent)
                        .add("studentBehaviorData",curStudentBehaviorList)
                        .add("classData",curClass);

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
