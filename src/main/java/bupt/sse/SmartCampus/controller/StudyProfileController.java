package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.model.User;
import bupt.sse.SmartCampus.service.StudentService;
import bupt.sse.SmartCampus.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/study")
public class StudyProfileController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            return "studyProfile";
        }
        return "login";
    }

    @RequestMapping("/allGrindsData")
    @ResponseBody
    public Message allGrindsData(HttpSession session){
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Integer> grind0=studentService.getStudentNumByGrind(0);
            List<Integer> grind1=studentService.getStudentNumByGrind(1);
            List<Integer> grind2=studentService.getStudentNumByGrind(2);
            List<Integer> sumList=new ArrayList<>();
            List<Integer> percentList=new ArrayList<>();
            Integer sum=0;
            for(int i=0;i<3;i++){
                int sumIndex=studentService.getStudentSumByGrind(i);
                sumList.add(sumIndex);
                sum =sum+sumIndex;
            }
            for(int j=0;j<3;j++){
                percentList.add(sumList.get(j)*100/sum);
            }
            result=Message.success().add("grind0",grind0).add("grind1",grind1).add("grind2",grind2).add("percent",percentList);
//            System.out.print();
//            System.out.print(grind0);
//            System.out.print(grind1);
//            System.out.print(grind2);
            return result;
        }
        return Message.fail("请先登录系统！");
    }

    @RequestMapping("/allFailData")
    @ResponseBody
    public Message allFailData(HttpSession session){
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Integer> fail0=new ArrayList<>();
            List<Integer> fail1=new ArrayList<>();
            List<Integer> fail2=new ArrayList<>();
            List<Integer> fail3=new ArrayList<>();
            List<Integer> failList2006=studentService.getFailNumByGrade(2006);
            fail0.add(failList2006.get(0));
            fail1.add(failList2006.get(1));
            fail2.add(failList2006.get(2));
            fail3.add(0);
            for(int grade=2007;grade<=2018;grade++){
                List<Integer> failList=studentService.getFailNumByGrade(grade);
                fail0.add(failList.get(0));
                fail1.add(failList.get(1));
                fail2.add(failList.get(2));
                fail3.add(failList.get(3));
            }
            List<Integer> sumList=new ArrayList<>();
            List<Integer> percentList=new ArrayList<>();
            Integer sum=0;
            for(int i=0;i<=3;i++){
                int sumIndex=studentService.getStudentSumByFail(i);
                sumList.add(sumIndex);
                sum =sum+sumIndex;
            }
            for(int j=0;j<=3;j++){
                percentList.add(sumList.get(j)*100/sum);
            }
            result=Message.success().add("fail0",fail0).add("fail1",fail1).add("fail2",fail2).add("fail3",fail3).add("percent",percentList);
//            System.out.println(percentList);
//            System.out.println(fail0);
//            System.out.println(fail1);
//            System.out.println(fail2);
//            System.out.println(fail3);
            return result;
        }
        return Message.fail("请先登录系统！");
    }

    @RequestMapping("/allAscendData")
    @ResponseBody
    public Message allAscendData(HttpSession session){
        Message result;
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录,跳转到学业画像页面
            List<Integer> ascend0=new ArrayList<>();
            List<Integer> ascend1=new ArrayList<>();
            List<Integer> ascend2=new ArrayList<>();
            List<String> year=new ArrayList<>();
            for(int i=2006;i<=2017;i++){
                String indexYear=String.valueOf(i).concat("-").concat(String.valueOf(i+1));
                year.add(indexYear);
            }
            System.out.println(year);
            for(int i=0;i<=11;i++){
                List<Integer> ascendList=studentService.getAscendNumByYear(year.get(i));
                ascend0.add(ascendList.get(0));
                ascend1.add(ascendList.get(1));
                ascend2.add(ascendList.get(2));
            }
            List<Integer> sumList=new ArrayList<>();
            List<Integer> percentList=new ArrayList<>();
            Integer sum=0;
            for(int i=0;i<=3;i++){
                int sumIndex=studentService.getStudentSumByAscend(i);
                sumList.add(sumIndex);
                sum =sum+sumIndex;
            }
            for(int j=0;j<=3;j++){
                percentList.add(sumList.get(j)*100/sum);
            }
            result=Message.success().add("ascend0",ascend0).add("ascend1",ascend1).add("ascend2",ascend2).add("percent",percentList);
            System.out.println(percentList);
            System.out.println(ascend0);
            System.out.println(ascend1);
            System.out.println(ascend2);
            return result;
        }
        return Message.fail("请先登录系统！");
    }
}
