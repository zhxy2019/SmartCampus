package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.StudentBehavior;

import java.util.List;

public interface StudentBehaviorService {
    List<StudentBehavior> getStudentBehaviorById(String studentId);
}
