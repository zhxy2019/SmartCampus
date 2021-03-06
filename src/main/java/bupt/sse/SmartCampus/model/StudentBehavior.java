package bupt.sse.SmartCampus.model;

public class StudentBehavior {
    private Integer id;

    private String year;

    private Integer term;

    private String studentid;

    private Integer countBreakfast;

    private Integer meanBreakfast;

    private Integer sumBreakfast;

    private Integer countLunch;

    private Integer meanLunch;

    private Integer sumLunch;

    private Integer countDinner;

    private Integer meanDinner;

    private Integer sumDinner;

    private Integer countMeal;

    private Integer sumMeal;

    private Integer sumMarket;

    private Integer countSleeplate;

    private Integer breakfastlabel;

    private Integer meallabel;

    private Integer consumptionlabel;

    private Integer sleeplatelabel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Integer getCountBreakfast() {
        return countBreakfast;
    }

    public void setCountBreakfast(Integer countBreakfast) {
        this.countBreakfast = countBreakfast;
    }

    public Integer getMeanBreakfast() {
        return meanBreakfast;
    }

    public void setMeanBreakfast(Integer meanBreakfast) {
        this.meanBreakfast = meanBreakfast;
    }

    public Integer getSumBreakfast() {
        return sumBreakfast;
    }

    public void setSumBreakfast(Integer sumBreakfast) {
        this.sumBreakfast = sumBreakfast;
    }

    public Integer getCountLunch() {
        return countLunch;
    }

    public void setCountLunch(Integer countLunch) {
        this.countLunch = countLunch;
    }

    public Integer getMeanLunch() {
        return meanLunch;
    }

    public void setMeanLunch(Integer meanLunch) {
        this.meanLunch = meanLunch;
    }

    public Integer getSumLunch() {
        return sumLunch;
    }

    public void setSumLunch(Integer sumLunch) {
        this.sumLunch = sumLunch;
    }

    public Integer getCountDinner() {
        return countDinner;
    }

    public void setCountDinner(Integer countDinner) {
        this.countDinner = countDinner;
    }

    public Integer getMeanDinner() {
        return meanDinner;
    }

    public void setMeanDinner(Integer meanDinner) {
        this.meanDinner = meanDinner;
    }

    public Integer getSumDinner() {
        return sumDinner;
    }

    public void setSumDinner(Integer sumDinner) {
        this.sumDinner = sumDinner;
    }

    public Integer getCountMeal() {
        return countMeal;
    }

    public void setCountMeal(Integer countMeal) {
        this.countMeal = countMeal;
    }

    public Integer getSumMeal() {
        return sumMeal;
    }

    public void setSumMeal(Integer sumMeal) {
        this.sumMeal = sumMeal;
    }

    public Integer getSumMarket() {
        return sumMarket;
    }

    public void setSumMarket(Integer sumMarket) {
        this.sumMarket = sumMarket;
    }

    public Integer getCountSleeplate() {
        return countSleeplate;
    }

    public void setCountSleeplate(Integer countSleeplate) {
        this.countSleeplate = countSleeplate;
    }

    public Integer getBreakfastlabel() {
        return breakfastlabel;
    }

    public void setBreakfastlabel(Integer breakfastlabel) {
        this.breakfastlabel = breakfastlabel;
    }

    public Integer getMeallabel() {
        return meallabel;
    }

    public void setMeallabel(Integer meallabel) {
        this.meallabel = meallabel;
    }

    public Integer getConsumptionlabel() {
        return consumptionlabel;
    }

    public void setConsumptionlabel(Integer consumptionlabel) {
        this.consumptionlabel = consumptionlabel;
    }

    public Integer getSleeplatelabel() {
        return sleeplatelabel;
    }

    public void setSleeplatelabel(Integer sleeplatelabel) {
        this.sleeplatelabel = sleeplatelabel;
    }
}