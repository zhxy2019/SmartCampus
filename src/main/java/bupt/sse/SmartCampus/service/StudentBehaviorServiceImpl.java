package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentBehaviorMapper;
import bupt.sse.SmartCampus.model.StudentBehavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBehaviorServiceImpl implements StudentBehaviorService {

    @Autowired
    StudentBehaviorMapper studentBehaviorMapper;

    @Override
    public List<StudentBehavior> getStudentBehaviorDataByStudentId(String studentId) {
        return studentBehaviorMapper.getStudentBehaviorDataByStudentId(studentId);
    }
}
