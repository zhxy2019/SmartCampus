package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.CollegeMapper;
import bupt.sse.SmartCampus.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public List<Map> getAllCollegeIdAndName(){
        return collegeMapper.getAllCollegeIdAndName();
    }

    @Override
    public List<Map> getMajorIdAndNameByCollegeId(String collegeId){
        return collegeMapper.getMajorIdAndNameByCollegeId(collegeId);
    }

    @Override
    public College getCollegeDataByStudentId(String studentId){
        return collegeMapper.selectCollegeDataByStudentId(studentId);
    }
}
