package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

    @Override
    public List<Integer> getClassIdByCounselorId(String counselorId){
        return classMapper.selectClassIdByCounselorId(counselorId);
    }
}
