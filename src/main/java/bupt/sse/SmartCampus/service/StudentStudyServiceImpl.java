package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentStudyMapper;
import bupt.sse.SmartCampus.model.StudentStudy;
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
}
