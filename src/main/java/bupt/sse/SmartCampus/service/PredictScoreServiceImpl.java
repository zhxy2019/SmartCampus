package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.PredictScoreMapper;
import bupt.sse.SmartCampus.model.PredictScore;
import bupt.sse.SmartCampus.model.PredictScoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictScoreServiceImpl implements PredictScoreService {
    @Autowired
    PredictScoreMapper predictScoreMapper;
    @Override
    public List<PredictScore> getPredictScoreWithCourse(String studentId) {
        return predictScoreMapper.selectWithCourse(studentId);
    }

    @Override
    public List<PredictScore> getPredictScoreByStudentIdCourseId(String studentId, String courseId) {
        PredictScoreExample predictScoreExample=new PredictScoreExample();
        PredictScoreExample.Criteria criteria=predictScoreExample.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        criteria.andCourseidEqualTo(courseId);
        return predictScoreMapper.selectByExample(predictScoreExample);
    }
}
