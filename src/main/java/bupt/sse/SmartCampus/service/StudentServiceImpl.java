package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentMapper;
import bupt.sse.SmartCampus.dao.StudentStudyMapper;
import bupt.sse.SmartCampus.model.Student;
import bupt.sse.SmartCampus.model.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentStudyMapper studentStudyMapper;

    @Override
    public List<Integer> getStudentNumByGrind(Integer grind){
        List<Integer> numList=studentMapper.countStudentByGrind(grind);
//        System.out.print(numList);
        return numList;
    }

    @Override
    public Integer getStudentSumByGrind(Integer grind){
        return studentMapper.sumStudentByGrind(grind);
    }

//    @Override
//    public Map<Integer,Integer> getFailNumByGrade(Integer grade){
//        Map<Integer,Integer> failMap=studentMapper.test(grade);
//        System.out.print(failMap);
//        return failMap;
//    }

    @Override
    public List<Integer> getFailNumByGrade(Integer grade){
        List<Integer> failList=studentMapper.countFailByGrade(grade);
//        System.out.print(failList);
        return failList;
    }

    @Override
    public Integer getStudentSumByFail(Integer fail){
        Integer num=studentMapper.sumStudentByFail(fail);
//        System.out.print(num);
        return num;
    }

    @Override
    public List<Integer> getAscendNumByYear(String year){
        List<Integer> ascendList=studentStudyMapper.countAscendByYear(year);
//        System.out.print(failList);
        return ascendList;
    }

    @Override
    public Integer getStudentSumByAscend(Integer ascend){
        Integer num=studentStudyMapper.sumStudentByAscend(ascend);
//        System.out.print(num);
        return num;
    }

    @Override
    public long getStudentSumInSchool(int currentGrade) {
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria=studentExample.createCriteria();
        criteria.andGradeGreaterThanOrEqualTo(String.valueOf(currentGrade));
        long num=studentMapper.countByExample(studentExample);
        return num;
    }

    @Override
    public long getStudentSumInSchoolByFail(int currentGrade, int value) {
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria=studentExample.createCriteria();
        criteria.andGradeGreaterThanOrEqualTo(String.valueOf(currentGrade));
        criteria.andFailEqualTo(value);
        long num=studentMapper.countByExample(studentExample);
        return num;
    }

    @Override
    public Map<String, List> getCollegeFailPercentage(Integer currentGrade) {
        List<Map<String,Object>> failPercentage=studentMapper.selectFailPercentage(currentGrade);
        Map<String, List> resultMap = new HashMap<String, List>();
        List<String> collegeNameList=new ArrayList<>();
        List<Float> percentageList=new ArrayList<>();
        for (Map<String,Object> map:failPercentage){
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if ("collegeName".equals(entry.getKey())) {
                    collegeNameList.add((String) entry.getValue());
                } else if ("percentage".equals(entry.getKey())) {
                    float percentage=Float.parseFloat(entry.getValue().toString());
                    percentageList.add((float)(Math.round(percentage*10000))/100);
                }
            }
        }
        resultMap.put("collegeNameList",collegeNameList);
        resultMap.put("percentageList",percentageList);
        return resultMap;
    }

    @Override
    public List<Student> getPredictStudentList(String collegeName, int currentGrade) {
        return studentMapper.selectStudentWithPredictNum(collegeName,currentGrade);
    }

}
