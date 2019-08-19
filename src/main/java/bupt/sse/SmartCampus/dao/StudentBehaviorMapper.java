package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.StudentBehavior;
import bupt.sse.SmartCampus.model.StudentBehaviorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentBehaviorMapper {
    long countByExample(StudentBehaviorExample example);

    int deleteByExample(StudentBehaviorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentBehavior record);

    int insertSelective(StudentBehavior record);

    List<StudentBehavior> selectByExample(StudentBehaviorExample example);

    StudentBehavior selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentBehavior record, @Param("example") StudentBehaviorExample example);

    int updateByExample(@Param("record") StudentBehavior record, @Param("example") StudentBehaviorExample example);

    int updateByPrimaryKeySelective(StudentBehavior record);

    int updateByPrimaryKey(StudentBehavior record);
}