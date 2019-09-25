package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Integer fizzySearchSum(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize);
    List<Map> fizzySearchData(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize);

    Integer fizzySearchSum_counselor(String counselorId,String classId,String studentId,String studentName,Integer pageNum,Integer pageSize);
    List<Map> fizzySearchData_counselor(String counselorId,String classId,String studentId,String studentName,Integer pageNum,Integer pageSize);


    //教务员学生列表
    Integer getStudentSumByLabelAndGradeAndId(String Label,String grade,String id);
    List<Student> getStudentPageDataByLabelAndGradeAndId(String label,String grade,String id,Integer pageNum,Integer pageSize);
    //辅导员学生列表
    Integer getStudentSumByLabelAndYearAndId_counselor(String Label,String year,String counselorId,String classId);
    List<Student> getStudentPageDataByLabelAndYearAndId_counselor(String label,String year,String counselorId,String classId,Integer pageNum,Integer pageSize);


    //教务员统计数据
    List<Map> getCountDataByLabelAndId(String label,String id);
    Map getSumDataByLabelAndId(String label,String id);
    //辅导员统计数据
    Map getCountGrindDataById_counselor(String counselorId,String id);
    Map getCountFailDataById_counselor(String counselorId,String id);
    List<Map> getCountAscendDataById_counselor(String counselorId,String id);
    Map getSumAscendDataById_counselor(String counselorId,String id);

    //单个学生数据
    Student getStudentDataByStudentId(String studentId);

    //辅助函数
    Integer getIndex(String label);

    long getStudentSumInSchool(int currentGrade);

    long getStudentSumInSchoolByFail(int currentGrade, int value);

    Map<String, List> getCollegeFailPercentage(Integer currentGrade);

    List<Student> getPredictStudentList(String collegeName, int currentGrade);

    Float getCollegePredictPercentage(int currentGrade, String collegeName);
}
