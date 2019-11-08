package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.ClassMapper;
import bupt.sse.SmartCampus.model.Class;
import bupt.sse.SmartCampus.model.ClassExample;
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

    @Override
    public List<Class> getClassListByCounselorId(String counselorId) {
        ClassExample classExample=new ClassExample();
        ClassExample.Criteria criteria=classExample.createCriteria();
        criteria.andCounseloridEqualTo(counselorId);
        return classMapper.selectByExample(classExample);
    }
}
