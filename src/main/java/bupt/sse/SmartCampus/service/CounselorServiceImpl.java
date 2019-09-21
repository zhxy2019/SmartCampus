package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.CounselorMapper;
import bupt.sse.SmartCampus.model.Counselor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounselorServiceImpl implements CounselorService {
    @Autowired
    CounselorMapper counselorMapper;
    @Override
    public Counselor getCounselorInfo(String userId) {
        return counselorMapper.selectByPrimaryKey(userId);
    }
}
