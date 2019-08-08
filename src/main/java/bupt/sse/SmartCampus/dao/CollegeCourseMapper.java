package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.CollegeCourse;
import bupt.sse.SmartCampus.model.CollegeCourseExample;
import bupt.sse.SmartCampus.model.CollegeCourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeCourseMapper {
    long countByExample(CollegeCourseExample example);

    int deleteByExample(CollegeCourseExample example);

    int deleteByPrimaryKey(CollegeCourseKey key);

    int insert(CollegeCourse record);

    int insertSelective(CollegeCourse record);

    List<CollegeCourse> selectByExample(CollegeCourseExample example);

    CollegeCourse selectByPrimaryKey(CollegeCourseKey key);

    int updateByExampleSelective(@Param("record") CollegeCourse record, @Param("example") CollegeCourseExample example);

    int updateByExample(@Param("record") CollegeCourse record, @Param("example") CollegeCourseExample example);

    int updateByPrimaryKeySelective(CollegeCourse record);

    int updateByPrimaryKey(CollegeCourse record);
}