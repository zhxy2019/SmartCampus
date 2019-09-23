package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.StudentStudy;

import java.util.List;
import java.util.Map;

public interface StudentStudyService {

    List<StudentStudy> getStudentStudyDataByStudentId(String studentId);

    List<StudentStudy> getStudentStudyById(String studentId);
}
