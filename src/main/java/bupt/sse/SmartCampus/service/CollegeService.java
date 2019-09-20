package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.College;

import java.util.List;
import java.util.Map;

public interface CollegeService {
    List<Map> getAllCollegeIdAndName();
    List<Map> getMajorIdAndNameByCollegeId(String collegeId);
    College getCollegeDataByStudentId(String studentId);
}
