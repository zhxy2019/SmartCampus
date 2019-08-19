package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.StudentStudy;
import bupt.sse.SmartCampus.model.StudentStudyExample;
import java.util.List;
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
}