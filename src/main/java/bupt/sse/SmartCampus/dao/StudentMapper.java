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


    Integer selectStudentSumByCollegeOrMajorOrGradeOrStudent(@Param("collegeName") String collegeName,
                                                              @Param("majorName") String majorName,
                                                              @Param("grade") String grade,
                                                              @Param("studentId") String studentId,
                                                              @Param("studentName") String studentName,
                                                             @Param("rowNum") Integer rowNum,
                                                             @Param("pageSize") Integer pageSize);
    List<Map> selectStudentDataByCollegeOrMajorOrGradeOrStudent(@Param("collegeName") String collegeName,
                                                                @Param("majorName") String majorName,
                                                                @Param("grade") String grade,
                                                                @Param("studentId") String studentId,
                                                                @Param("studentName") String studentName,
                                                                @Param("rowNum") Integer rowNum,
                                                                @Param("pageSize") Integer pageSize);
    List<Map> countGrind();
    List<Map> countGrindById(@Param("id") String id);
    Map sumGrind();
    Map sumGrindById(@Param("id") String id);
    Integer sumStudentByGrind(@Param("grind") Integer grind);

    List<Map> countFail();
    List<Map> countFailById(@Param("id") String id);
    Map sumFail();
    Map sumFailById(@Param("id") String id);
    Integer sumStudentByFail(@Param("fail") Integer fail);

    Integer sumStudentByGrindAndGrade(@Param("grind") Integer grind,@Param("grade") String grade);
    Integer sumStudentByFailAndGrade(@Param("fail") Integer fail,@Param("grade") String grade);
    Integer sumStudentByGrindAndGradeAndId(@Param("grind") Integer grind,@Param("grade") String grade,@Param("id") String id);
    Integer sumStudentByFailAndGradeAndId(@Param("fail") Integer fail,@Param("grade") String grade,@Param("id") String id);


    List<Student> getGrindStudentDataByPage(@Param("grind") Integer grind,
                                            @Param("grade") String grade,
                                            @Param("rowNum") Integer rowNum,
                                            @Param("pageSize") Integer pageSize);
    List<Student> getFailStudentDataByPage(@Param("fail") Integer fail,
                                           @Param("grade") String grade,
                                           @Param("rowNum") Integer rowNum,
                                           @Param("pageSize") Integer pageSize);
    List<Student> getAscendStudentDataByPage(@Param("ascend") Integer ascend,
                                           @Param("year") String year,
                                           @Param("rowNum") Integer rowNum,
                                           @Param("pageSize") Integer pageSize);
    List<Student> getGrindStudentDataByPageAndId(@Param("grind") Integer grind,
                                                 @Param("grade") String grade,
                                                 @Param("id") String id,
                                                 @Param("rowNum") Integer rowNum,
                                                 @Param("pageSize") Integer pageSize);
    List<Student> getFailStudentDataByPageAndId(@Param("fail") Integer fail,
                                                @Param("grade") String grade,
                                                @Param("id") String id,
                                                @Param("rowNum") Integer rowNum,
                                                @Param("pageSize") Integer pageSize);
    List<Student> getAscendStudentDataByPageAndId(@Param("ascend") Integer ascend,
                                                  @Param("year") String year,
                                                  @Param("id") String id,
                                                  @Param("rowNum") Integer rowNum,
                                                  @Param("pageSize") Integer pageSize);


    Student getStudentDataByStudentId(@Param("studentId") String studentId);

}