package bupt.sse.SmartCampus.controller;

import bupt.sse.SmartCampus.utils.Message;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
@RequestMapping("/admin")
public class MainController {
    //获取菜单统计数据，在校生人数、有留级风险人数、有退学风险人数
    @RequestMapping(value = "/getMenuData",method = RequestMethod.POST)
    @ResponseBody
    public Message getMenuData(){
        Message result= null;
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
        //查询在校生人数

        //查询在校生中有留级风险人数
        //查询在校生中有退学风险的人数
        return result;
    }
}
