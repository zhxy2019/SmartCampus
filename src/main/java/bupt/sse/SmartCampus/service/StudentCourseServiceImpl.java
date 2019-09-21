package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.CourseMapper;
import bupt.sse.SmartCampus.dao.StudentCourseMapper;
import bupt.sse.SmartCampus.model.Course;
import bupt.sse.SmartCampus.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{
    @Autowired
    StudentCourseMapper studentCourseMapper;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Map> getCourseDataByStudentId(String studentId,String year){
//        List<StudentCourse> studentCourseList=studentCourseMapper.getStudentCourseDataByStudentId(studentId,year);
//        List<String> courseIdList=new ArrayList<>();
//        for(int i=0;i<studentCourseList.size();i++) {
//            courseIdList.add(studentCourseList.get(i).getCourseid());
////            classIdList.add(Integer.valueOf(studentCourseList.get(i).getCourseid()));
//        }
//        List<Course> courseList=courseMapper.getCourseDataByClassId(courseIdList);
//        List<List> courseDataList=new ArrayList<>();
//        for(int j=0;j<studentCourseList.size();j++){
//            List curCourseData =new ArrayList();
//            curCourseData.add(studentCourseList.get(j).getYear());
//            curCourseData.add(studentCourseList.get(j).getTerm());
//            curCourseData.add(studentCourseList.get(j).getCourseid());
//            curCourseData.add(courseList.get(j).getCoursename());
//            curCourseData.add(courseList.get(j).getClasshour());
//            curCourseData.add(courseList.get(j).getCredit());
//            curCourseData.add(studentCourseList.get(j).getScore());
//            curCourseData.add(studentCourseList.get(j).getStudentrank());
//            courseDataList.add(curCourseData);
//        }
        List<Map> courseDataList=studentCourseMapper.getCourseDataByStudentId(studentId,year);
        return courseDataList;
    }
}
