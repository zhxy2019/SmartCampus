package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.StudentStudy;
import bupt.sse.SmartCampus.model.StudentStudyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentStudyMapper {
    long countByExample(StudentStudyExample example);

    int deleteByExample(StudentStudyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentStudy record);

    int insertSelective(StudentStudy record);

    List<StudentStudy> selectByExample(StudentStudyExample example);

    StudentStudy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentStudy record, @Param("example") StudentStudyExample example);

    int updateByExample(@Param("record") StudentStudy record, @Param("example") StudentStudyExample example);

    int updateByPrimaryKeySelective(StudentStudy record);

    int updateByPrimaryKey(StudentStudy record);


    //graph所需数据
    List<Map> countAscend();
    List<Map> countAscendById(@Param("id") String id);
    Map sumAscend();
    Map sumAscendById(@Param("id") String id);
    Integer sumStudentByAscend(@Param("ascend") Integer ascend);

    //datatable所需totalrecords
    Integer sumStudentByAscendAndYear(@Param("ascend") Integer ascend,@Param("year") String year);
    Integer sumStudentByAscendAndYearAndId(@Param("ascend") Integer ascend,@Param("year") String year,@Param("id") String id);


    List<StudentStudy> getStudentStudyDataByStudentId(@Param("studentId") String studentId);
}