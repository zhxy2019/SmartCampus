package bupt.sse.SmartCampus.controller;


import bupt.sse.SmartCampus.model.Administrator;
import bupt.sse.SmartCampus.model.Counselor;
import bupt.sse.SmartCampus.model.User;
import bupt.sse.SmartCampus.model.Class;
import bupt.sse.SmartCampus.service.AdministratorService;
import bupt.sse.SmartCampus.service.ClassService;
import bupt.sse.SmartCampus.service.CounselorService;
import bupt.sse.SmartCampus.service.UserService;
import bupt.sse.SmartCampus.utils.Message;
import bupt.sse.SmartCampus.utils.VerifyCodeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")

public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private CounselorService counselorService;
    @Autowired
    private ClassService classService;
    //默认首页
    @RequestMapping("/")
    public String index(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已经登录
            return "forward:/main";
        }
        return "login";
    }

    //正常访问login页面
    @RequestMapping("/login")
    public String login(HttpSession session){
        if(session.getAttribute("user")!=null){
            //已经登录
            return "forward:/main";
        }
        return "login";
    }
//
    //表单提交过来的路径
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin(HttpServletRequest request, HttpSession session, User formUser){
        Map<String, Object> resultMap = new HashMap<>();
        //获取用户输入的验证码
        String verifyCode= (String) request.getParameter("verifyCode");
        //从session获取验证码
        String sessionVerifyCode= (String) session.getAttribute("verifyCodeValue");
        if(!verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            //直接返回不做下面的验证
            resultMap.put("success",false);
            resultMap.put("msg","验证码错误！");
            return resultMap;
        }

        //调用service方法
        User loginUser=userService.checkLogin(formUser.getUserId());
        //如果有user添加到model里并跳转到主页面
        if(loginUser!=null){
            if(loginUser.getUserPassword().equals(formUser.getUserPassword())){
                session.setAttribute("user",loginUser);
                resultMap.put("success",true);
            }
            else {
                resultMap.put("success",false);
                resultMap.put("msg","密码错误！");
            }
        }else {
            resultMap.put("success",false);
            resultMap.put("msg","不存在该用户！");
        }
        return resultMap;
    }
//
    //跳转到主页面
    @RequestMapping("/main")
    public String mainPage(HttpServletRequest request, HttpSession session){
        //获取用户信息，判断应该跳转的页面
        User user=(User) session.getAttribute("user");
        String info= (String) request.getAttribute("info");
        if(info!=null){
            session.setAttribute("info",info);
        }
        int role=user.getRole();
        switch (role){
            case 0:
                //教务处学生处
                return "redirect:/admin/";
            case 1:
                //辅导员
                return "redirect:/counselor/";
//            case 2:
//                //学生
//                return "redirect:/student/";
        }
        return null;
    }
    //跳转到管理员首页
    @RequestMapping("/admin/")
    public String adminMain(HttpSession session){
        //查询教务管理员基本信息
        User user = (User) session.getAttribute("user");
        Administrator administrator = administratorService.getAdministratorInfo(user.getUserId());
        JSONObject jsonObject = JSONObject.fromObject(administrator);
        session.setAttribute("administrator", jsonObject);
        return "adminMain";
    }
    //跳转到辅导员首页
    @RequestMapping("/counselor/")
    public String counselorMain(HttpSession session){
        //查询教务管理员基本信息
        User user = (User) session.getAttribute("user");
        Counselor counselor= counselorService.getCounselorInfo(user.getUserId());
        JSONObject jsonObject = JSONObject.fromObject(counselor);
        session.setAttribute("counselor", jsonObject);
        //查询管理员所在班级列表存储到list里
        //该辅导员管理的班级列表
        List<Class> classes = classService.getClassListByCounselorId(counselor.getCounselorid());
        JSONArray jsonArray = JSONArray.fromObject(classes);
        session.setAttribute("classList", jsonArray);
        List<String> classIdList = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            classIdList.add(classes.get(i).getClassid());
        }
        JSONArray classIdArray=JSONArray.fromObject(classIdList);
        session.setAttribute("classIdList",classIdArray);
        return "counselorMain";
    }
//
    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        //通过session.invalidate方法注销当前session
        session.removeAttribute("user");
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }
//
    /*
    获取验证码
     */
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session){
        ByteArrayOutputStream output=new ByteArrayOutputStream();
        String verifyCodeValue= VerifyCodeUtil.drawImg(output);
        //将验证码保存到session中
        session.setAttribute("verifyCodeValue",verifyCodeValue);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    /*
//    获取公钥
//     */
//    @RequestMapping(value="/getPublic",method= RequestMethod.POST)
//    @ResponseBody
//    public Message getPublic() {
//        String publicKey = RSAUtils.generateBase64PublicKey();
//        Message result = null;
//        if (publicKey == null) {
//            result = Message.fail("获取公钥失败，请重试！");
//        } else {
//            result = Message.success().add("publicKey", publicKey);
//        }
//        return result;
//    }
}
