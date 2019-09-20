package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.StudentCourse;

import java.util.List;
import java.util.Map;

public interface StudentCourseService {
    List<Map> getCourseDataByStudentId(String studentId, String year);
}
