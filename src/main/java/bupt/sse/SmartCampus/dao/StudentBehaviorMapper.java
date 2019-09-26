package bupt.sse.SmartCampus.dao;

import bupt.sse.SmartCampus.model.StudentBehavior;
import bupt.sse.SmartCampus.model.StudentBehaviorExample;
import java.util.List;
import java.util.Map;

import bupt.sse.SmartCampus.model.StudentStudy;

import org.apache.ibatis.annotations.Param;

public interface StudentBehaviorMapper {
    long countByExample(StudentBehaviorExample example);

    int deleteByExample(StudentBehaviorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentBehavior record);

    int insertSelective(StudentBehavior record);

    List<StudentBehavior> selectByExample(StudentBehaviorExample example);

    StudentBehavior selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentBehavior record, @Param("example") StudentBehaviorExample example);

    int updateByExample(@Param("record") StudentBehavior record, @Param("example") StudentBehaviorExample example);

    int updateByPrimaryKeySelective(StudentBehavior record);

    int updateByPrimaryKey(StudentBehavior record);

    //graph所需数据
    List<Map> countBreakfast();
    List<Map> countBreakfastById(@Param("id") String id);
    Map sumBreakfast();
    Map sumBreakfastById(@Param("id") String id);
    Integer sumStudentByBreakfast(@Param("breakfastLabel") Integer breakfastLabel);

    //datatable所需totalrecords
    Integer sumStudentByBreakfastAndYear(@Param("breakfastLabel") Integer breakfastLabel,@Param("year") String year);
    Integer sumStudentByBreakfastAndYearAndId(@Param("breakfastLabel") Integer breakfastLabel,@Param("year") String year,@Param("id") String id);

    List<Map> countConsumption();
    List<Map> countConsumptionById(@Param("id") String id);
    Map sumConsumption();
    Map sumConsumptionById(@Param("id") String id);
    Integer sumStudentByConsumption(@Param("consumptionLabel") Integer consumptionLabel);

    //datatable所需totalrecords
    Integer sumStudentByConsumptionAndYear(@Param("consumptionLabel") Integer consumptionLabel,@Param("year") String year);
    Integer sumStudentByConsumptionAndYearAndId(@Param("consumptionLabel") Integer consumptionLabel,@Param("year") String year,@Param("id") String id);

    List<Map> countMeal();
    List<Map> countMealById(@Param("id") String id);
    Map sumMeal();
    Map sumMealById(@Param("id") String id);
    Integer sumStudentByMeal(@Param("mealLabel") Integer mealLabel);

    //datatable所需totalrecords
    Integer sumStudentByMealAndYear(@Param("mealLabel") Integer mealLabel,@Param("year") String year);
    Integer sumStudentByMealAndYearAndId(@Param("mealLabel") Integer mealLabel,@Param("year") String year,@Param("id") String id);

    List<Map> countSleeplate();
    List<Map> countSleeplateById(@Param("id") String id);
    Map sumSleeplate();
    Map sumSleeplateById(@Param("id") String id);
    Integer sumStudentBySleeplate(@Param("sleeplateLabel") Integer sleeplateLabel);

    //datatable所需totalrecords
    Integer sumStudentBySleeplateAndYear(@Param("sleeplateLabel") Integer sleeplateLabel,@Param("year") String year);
    Integer sumStudentBySleeplateAndYearAndId(@Param("sleeplateLabel") Integer sleeplateLabel,@Param("year") String year,@Param("id") String id);

    List<StudentBehavior> getStudentBehaviorDataByStudentId(@Param("studentId") String studentId);

}