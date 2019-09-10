package bupt.sse.SmartCampus.service;

import java.util.List;

public interface StudentService {
    List<Integer> getStudentNumByGrind(Integer grind);
    Integer getStudentSumByGrind(Integer grind);

    //    Map<Integer,Integer> getFailNumByGrade(Integer grade);
    List<Integer> getFailNumByGrade(Integer grade);
    Integer getStudentSumByFail(Integer fail);

    List<Integer> getAscendNumByYear(String year);
    Integer getStudentSumByAscend(Integer ascend);

}
