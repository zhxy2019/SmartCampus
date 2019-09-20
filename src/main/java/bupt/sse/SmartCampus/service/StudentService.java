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

    Student getStudentDataByStudentId(String studentId);

    //辅助函数
    Integer getIndex(String label);
}
