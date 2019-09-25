package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.PredictScore;
import bupt.sse.SmartCampus.model.PredictScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PredictScoreMapper {
    long countByExample(PredictScoreExample example);

    int deleteByExample(PredictScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PredictScore record);

    int insertSelective(PredictScore record);

    List<PredictScore> selectByExample(PredictScoreExample example);

    List<PredictScore> selectWithCourse(@Param("studentid") String studentId);

    PredictScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PredictScore record, @Param("example") PredictScoreExample example);

    int updateByExample(@Param("record") PredictScore record, @Param("example") PredictScoreExample example);

    int updateByPrimaryKeySelective(PredictScore record);

    int updateByPrimaryKey(PredictScore record);

    Float selectCollegePredictPercentage(@Param("currentGrade")int currentGrade,@Param("collegename") String collegeName);

    Float selectPredictPercentage(@Param("currentGrade")int currentGrade);
}