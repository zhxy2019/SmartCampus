package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentStudyMapper;
import bupt.sse.SmartCampus.model.StudentExample;
import bupt.sse.SmartCampus.model.StudentStudy;
import bupt.sse.SmartCampus.model.StudentStudyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentStudyServiceImpl implements StudentStudyService {
    @Autowired
    StudentStudyMapper studentStudyMapper;


    @Override
    public List<StudentStudy> getStudentStudyDataByStudentId(String studentId){
        return studentStudyMapper.getStudentStudyDataByStudentId(studentId);
    }

    @Override
    public List<StudentStudy> getStudentStudyById(String studentId) {
        StudentStudyExample studentStudyExample=new StudentStudyExample();
        StudentStudyExample.Criteria criteria=studentStudyExample.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        return studentStudyMapper.selectByExample(studentStudyExample);
    }
}
