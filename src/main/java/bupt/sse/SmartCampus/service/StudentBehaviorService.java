package bupt.sse.SmartCampus.service;

import java.util.List;
import bupt.sse.SmartCampus.model.StudentBehavior;


public interface StudentBehaviorService {
    List<StudentBehavior> getStudentBehaviorDataByStudentId(String studentId);
}
