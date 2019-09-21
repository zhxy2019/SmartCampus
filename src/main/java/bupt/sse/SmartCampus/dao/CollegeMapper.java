package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.College;
import bupt.sse.SmartCampus.model.CollegeExample;
import bupt.sse.SmartCampus.model.CollegeKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(CollegeKey key);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(CollegeKey key);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    List<Map> getAllCollegeIdAndName();
    List<Map> getMajorIdAndNameByCollegeId(@Param("collegeId") String collegeId);
    College selectCollegeDataByStudentId(@Param("studentId")String studentId);
}