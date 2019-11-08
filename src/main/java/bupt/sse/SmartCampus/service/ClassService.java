package bupt.sse.SmartCampus.service;

import java.util.List;
import bupt.sse.SmartCampus.model.Class;

public interface ClassService {
    List<Integer> getClassIdByCounselorId(String counselorId);

    List<Class> getClassListByCounselorId(String userId);
}
