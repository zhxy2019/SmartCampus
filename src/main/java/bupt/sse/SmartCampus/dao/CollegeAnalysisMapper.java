package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.CollegeAnalysis;
import bupt.sse.SmartCampus.model.CollegeAnalysisExample;
import bupt.sse.SmartCampus.model.CollegeAnalysisKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeAnalysisMapper {
    long countByExample(CollegeAnalysisExample example);

    int deleteByExample(CollegeAnalysisExample example);

    int deleteByPrimaryKey(CollegeAnalysisKey key);

    int insert(CollegeAnalysis record);

    int insertSelective(CollegeAnalysis record);

    List<CollegeAnalysis> selectByExample(CollegeAnalysisExample example);

    CollegeAnalysis selectByPrimaryKey(CollegeAnalysisKey key);

    int updateByExampleSelective(@Param("record") CollegeAnalysis record, @Param("example") CollegeAnalysisExample example);

    int updateByExample(@Param("record") CollegeAnalysis record, @Param("example") CollegeAnalysisExample example);

    int updateByPrimaryKeySelective(CollegeAnalysis record);

    int updateByPrimaryKey(CollegeAnalysis record);
}