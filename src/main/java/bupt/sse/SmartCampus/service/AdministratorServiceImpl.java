package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.AdministratorMapper;
import bupt.sse.SmartCampus.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    @Override
    public Administrator getAdministratorInfo(String administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }
}
