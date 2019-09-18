package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentMapper;
import bupt.sse.SmartCampus.dao.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
