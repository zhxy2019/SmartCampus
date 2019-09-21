package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Integer> getStudentNumByGrind(Integer grind);
    Integer getStudentSumByGrind(Integer grind);

    //    Map<Integer,Integer> getFailNumByGrade(Integer grade);
    List<Integer> getFailNumByGrade(Integer grade);
    Integer getStudentSumByFail(Integer fail);

    List<Integer> getAscendNumByYear(String year);
    Integer getStudentSumByAscend(Integer ascend);

    long getStudentSumInSchool(int currentGrade);

    long getStudentSumInSchoolByFail(int currentGrade, int value);

    Map<String, List> getCollegeFailPercentage(Integer currentGrade);

    List<Student> getPredictStudentList(String collegeName, int currentGrade);
}
