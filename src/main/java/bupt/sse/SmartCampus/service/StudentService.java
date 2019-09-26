package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Integer fizzySearchSum(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize);
    List<Map> fizzySearchData(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize);

    Integer getStudentSumByLabelAndGradeAndId(String Label,String grade,String id);

    List<Student> getStudentPageDataByLabelAndGradeAndId(String label,String grade,String id,Integer pageNum,Integer pageSize);

    List<Map> getCountDataByLabelAndId(String label,String id);
    Map getSumDataByLabelAndId(String label,String id);
    //Yu
    Integer getStudentBehaviorSumByLabelAndGradeAndId(String Label,String grade,String id);
    List<Student> getStudentBehaviorPageDataByLabelAndGradeAndId(String label,String grade,String id,Integer pageNum,Integer pageSize);
    List<Map> getBehaviorCountDataByLabelAndId(String label,String id);
    Map getBehaviorSumDataByLabelAndId(String label,String id);

    Student getStudentDataByStudentId(String studentId);

    //辅助函数
    Integer getIndex(String label);
    //辅助函数
    Integer getIndex1(String label);

    long getStudentSumInSchool(int currentGrade);

    long getStudentSumInSchoolByFail(int currentGrade, int value);

    Map<String, List> getCollegeFailPercentage(Integer currentGrade);

    List<Student> getPredictStudentList(String collegeName, int currentGrade);
}
