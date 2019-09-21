package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.PredictScore;

import java.util.List;

public interface PredictScoreService {
    List<PredictScore> getPredictScoreWithCourse(String studentId);

    List<PredictScore> getPredictScoreByStudentIdCourseId(String studentId, String courseId);
}
