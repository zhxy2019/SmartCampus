package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.dao.StudentMapper;
import bupt.sse.SmartCampus.dao.StudentStudyMapper;
import bupt.sse.SmartCampus.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentStudyMapper studentStudyMapper;

    @Override
    public Integer fizzySearchSum(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize){
        return studentMapper.selectStudentSumByCollegeOrMajorOrGradeOrStudent(collegeName,majorName,grade,studentId,studentName,pageNum,pageSize);
    }

    @Override
    public List<Map> fizzySearchData(String collegeName,String majorName,String grade,String studentId,String studentName,Integer pageNum,Integer pageSize){
       return studentMapper.selectStudentDataByCollegeOrMajorOrGradeOrStudent(collegeName,majorName,grade,studentId,studentName,pageNum,pageSize);
    }

    //datatable所需totalrecords
    @Override
    public Integer getStudentSumByLabelAndGradeAndId(String label,String grade,String id){
        int index=getIndex(label);
        Integer studentSum;
        if(index<3){
            //grind-----------------------------------------------------------------------------------
            if(id.equals("all"))
                //所有学院-------------------------------------
                studentSum=studentMapper.sumStudentByGrindAndGrade(index,grade);
            else
                studentSum=studentMapper.sumStudentByGrindAndGradeAndId(index,grade,id);

        }else if(index>6){
            //ascend-----------------------------------------------------------------------------------
            if(id.equals("all"))
                studentSum=studentStudyMapper.sumStudentByAscendAndYear(index-7,grade+"%");
            else
                studentSum=studentStudyMapper.sumStudentByAscendAndYearAndId(index-7,grade+"%",id);

        }else{
            //fail-----------------------------------------------------------------------------------
            if(id.equals("all"))
                studentSum=studentMapper.sumStudentByFailAndGrade(index-3,grade);
            else
                studentSum=studentMapper.sumStudentByFailAndGradeAndId(index-3,grade,id);
        }
        return studentSum;
    }


    //////////////////////////////////////////////////////////////////////////////////
    //datatable所需单页学生列表
    @Override
    public List<Student> getStudentPageDataByLabelAndGradeAndId(String label,String grade,String id,Integer pageNum,Integer pageSize){
        int index=getIndex(label);
        Integer rowNum=(pageNum-1)*pageSize;
        List<Student> studentList;
        if(index<3){
            //grind-----------------------------------------------------------------------------------
            if(id.equals("all"))
                //所有学院-------------------------------------
                studentList=studentMapper.getGrindStudentDataByPage(index,grade,rowNum,pageSize);
            else
                studentList=studentMapper.getGrindStudentDataByPageAndId(index,grade,id,rowNum,pageSize);

        }else if(index>6){
            //ascend-----------------------------------------------------------------------------------
            if(id.equals("all"))
                studentList=studentMapper.getAscendStudentDataByPage(index-7,grade,rowNum,pageSize);
            else
                studentList=studentMapper.getAscendStudentDataByPageAndId(index-7,grade,id,rowNum,pageSize);

        }else{
            //fail-----------------------------------------------------------------------------------
            if(id.equals("all"))
                studentList=studentMapper.getFailStudentDataByPage(index-3,grade,rowNum,pageSize);
            else
                studentList=studentMapper.getFailStudentDataByPageAndId(index-3,grade,id,rowNum,pageSize);
        }
        return studentList;

    }


    //graph所需统计数据
    @Override
    public List<Map> getCountDataByLabelAndId(String label,String id){
        int index=getIndex(label);
        List<Map> countData;
        if(index<3){
            //grind-----------------------------------------------------------------------------------
            if(id.equals("all"))
                //所有学院-------------------------------------
                countData=studentMapper.countGrind();
            else
                countData=studentMapper.countGrindById(id);

        }else if(index>6){
            //ascend-----------------------------------------------------------------------------------
            if(id.equals("all"))
                countData=studentStudyMapper.countAscend();
            else
                countData=studentStudyMapper.countAscendById(id);

        }else{
            //fail-----------------------------------------------------------------------------------
            if(id.equals("all"))
                countData=studentMapper.countFail();
            else
                countData=studentMapper.countFailById(id);
        }
        return countData;
    }

    //graph占比所需数据
    @Override
    public Map getSumDataByLabelAndId(String label,String id){
        int index=getIndex(label);
        Map sumData;
        if(index<3){
            //grind-----------------------------------------------------------------------------------
            if(id.equals("all"))
                //所有学院-------------------------------------
                sumData=studentMapper.sumGrind();
            else
                sumData=studentMapper.sumGrindById(id);

        }else if(index>6){
            //ascend-----------------------------------------------------------------------------------
            if(id.equals("all"))
                sumData=studentStudyMapper.sumAscend();
            else
                sumData=studentStudyMapper.sumAscendById(id);

        }else{
            //fail-----------------------------------------------------------------------------------
            if(id.equals("all"))
                sumData=studentMapper.sumFail();
            else
                sumData=studentMapper.sumFailById(id);
        }
        return sumData;
    }


    @Override
    public Student getStudentDataByStudentId(String studentId){
        return studentMapper.getStudentDataByStudentId(studentId);
    }

    //辅助函数
    @Override
    public Integer getIndex(String label){
        String[] labels={"学霸","学习普通","学渣","无挂科","有挂科","有留级风险","有退学风险","成绩上升","成绩稳定","成绩下降"};
        int index=0;
        for(;index<labels.length;index++){
            if(labels[index].equals(label))
                break;
        }
        return index;
    }


}
