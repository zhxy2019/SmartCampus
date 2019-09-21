package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.Student;
import bupt.sse.SmartCampus.model.StudentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String studentid);

    List<Map<String, Object>> selectFailPercentage(@Param("grade") Integer grade);

    List<Student> selectStudentWithPredictNum(@Param("collegeName") String collegeName,@Param("currentGrade") Integer currentGrade);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Integer> countStudentByGrind(@Param("grind") Integer grind);
    Integer sumStudentByGrind(@Param("grind") Integer grind);

    //    Map<Integer,Integer> countFailByGrade(@Param("grade") Integer grade);
    List<Integer> countFailByGrade(@Param("grade") Integer grade);
    Integer sumStudentByFail(@Param("fail") Integer fail);

}