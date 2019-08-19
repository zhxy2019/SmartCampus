package bupt.sse.SmartCampus.model;

import java.util.ArrayList;
import java.util.List;

public class StudentBehaviorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentBehaviorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Integer value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Integer value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Integer value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Integer value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Integer value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Integer> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Integer> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Integer value1, Integer value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Integer value1, Integer value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(String value) {
            addCriterion("studentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(String value) {
            addCriterion("studentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(String value) {
            addCriterion("studentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(String value) {
            addCriterion("studentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(String value) {
            addCriterion("studentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(String value) {
            addCriterion("studentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLike(String value) {
            addCriterion("studentId like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotLike(String value) {
            addCriterion("studentId not like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<String> values) {
            addCriterion("studentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<String> values) {
            addCriterion("studentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(String value1, String value2) {
            addCriterion("studentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(String value1, String value2) {
            addCriterion("studentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastIsNull() {
            addCriterion("count_breakfast is null");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastIsNotNull() {
            addCriterion("count_breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastEqualTo(Integer value) {
            addCriterion("count_breakfast =", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastNotEqualTo(Integer value) {
            addCriterion("count_breakfast <>", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastGreaterThan(Integer value) {
            addCriterion("count_breakfast >", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_breakfast >=", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastLessThan(Integer value) {
            addCriterion("count_breakfast <", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastLessThanOrEqualTo(Integer value) {
            addCriterion("count_breakfast <=", value, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastIn(List<Integer> values) {
            addCriterion("count_breakfast in", values, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastNotIn(List<Integer> values) {
            addCriterion("count_breakfast not in", values, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastBetween(Integer value1, Integer value2) {
            addCriterion("count_breakfast between", value1, value2, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountBreakfastNotBetween(Integer value1, Integer value2) {
            addCriterion("count_breakfast not between", value1, value2, "countBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastIsNull() {
            addCriterion("mean_breakfast is null");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastIsNotNull() {
            addCriterion("mean_breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastEqualTo(Integer value) {
            addCriterion("mean_breakfast =", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastNotEqualTo(Integer value) {
            addCriterion("mean_breakfast <>", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastGreaterThan(Integer value) {
            addCriterion("mean_breakfast >", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastGreaterThanOrEqualTo(Integer value) {
            addCriterion("mean_breakfast >=", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastLessThan(Integer value) {
            addCriterion("mean_breakfast <", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastLessThanOrEqualTo(Integer value) {
            addCriterion("mean_breakfast <=", value, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastIn(List<Integer> values) {
            addCriterion("mean_breakfast in", values, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastNotIn(List<Integer> values) {
            addCriterion("mean_breakfast not in", values, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastBetween(Integer value1, Integer value2) {
            addCriterion("mean_breakfast between", value1, value2, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andMeanBreakfastNotBetween(Integer value1, Integer value2) {
            addCriterion("mean_breakfast not between", value1, value2, "meanBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastIsNull() {
            addCriterion("sum_breakfast is null");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastIsNotNull() {
            addCriterion("sum_breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastEqualTo(Integer value) {
            addCriterion("sum_breakfast =", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastNotEqualTo(Integer value) {
            addCriterion("sum_breakfast <>", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastGreaterThan(Integer value) {
            addCriterion("sum_breakfast >", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_breakfast >=", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastLessThan(Integer value) {
            addCriterion("sum_breakfast <", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastLessThanOrEqualTo(Integer value) {
            addCriterion("sum_breakfast <=", value, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastIn(List<Integer> values) {
            addCriterion("sum_breakfast in", values, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastNotIn(List<Integer> values) {
            addCriterion("sum_breakfast not in", values, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastBetween(Integer value1, Integer value2) {
            addCriterion("sum_breakfast between", value1, value2, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andSumBreakfastNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_breakfast not between", value1, value2, "sumBreakfast");
            return (Criteria) this;
        }

        public Criteria andCountLunchIsNull() {
            addCriterion("count_lunch is null");
            return (Criteria) this;
        }

        public Criteria andCountLunchIsNotNull() {
            addCriterion("count_lunch is not null");
            return (Criteria) this;
        }

        public Criteria andCountLunchEqualTo(Integer value) {
            addCriterion("count_lunch =", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchNotEqualTo(Integer value) {
            addCriterion("count_lunch <>", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchGreaterThan(Integer value) {
            addCriterion("count_lunch >", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_lunch >=", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchLessThan(Integer value) {
            addCriterion("count_lunch <", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchLessThanOrEqualTo(Integer value) {
            addCriterion("count_lunch <=", value, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchIn(List<Integer> values) {
            addCriterion("count_lunch in", values, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchNotIn(List<Integer> values) {
            addCriterion("count_lunch not in", values, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchBetween(Integer value1, Integer value2) {
            addCriterion("count_lunch between", value1, value2, "countLunch");
            return (Criteria) this;
        }

        public Criteria andCountLunchNotBetween(Integer value1, Integer value2) {
            addCriterion("count_lunch not between", value1, value2, "countLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchIsNull() {
            addCriterion("mean_lunch is null");
            return (Criteria) this;
        }

        public Criteria andMeanLunchIsNotNull() {
            addCriterion("mean_lunch is not null");
            return (Criteria) this;
        }

        public Criteria andMeanLunchEqualTo(Integer value) {
            addCriterion("mean_lunch =", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchNotEqualTo(Integer value) {
            addCriterion("mean_lunch <>", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchGreaterThan(Integer value) {
            addCriterion("mean_lunch >", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchGreaterThanOrEqualTo(Integer value) {
            addCriterion("mean_lunch >=", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchLessThan(Integer value) {
            addCriterion("mean_lunch <", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchLessThanOrEqualTo(Integer value) {
            addCriterion("mean_lunch <=", value, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchIn(List<Integer> values) {
            addCriterion("mean_lunch in", values, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchNotIn(List<Integer> values) {
            addCriterion("mean_lunch not in", values, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchBetween(Integer value1, Integer value2) {
            addCriterion("mean_lunch between", value1, value2, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andMeanLunchNotBetween(Integer value1, Integer value2) {
            addCriterion("mean_lunch not between", value1, value2, "meanLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchIsNull() {
            addCriterion("sum_lunch is null");
            return (Criteria) this;
        }

        public Criteria andSumLunchIsNotNull() {
            addCriterion("sum_lunch is not null");
            return (Criteria) this;
        }

        public Criteria andSumLunchEqualTo(Integer value) {
            addCriterion("sum_lunch =", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchNotEqualTo(Integer value) {
            addCriterion("sum_lunch <>", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchGreaterThan(Integer value) {
            addCriterion("sum_lunch >", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_lunch >=", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchLessThan(Integer value) {
            addCriterion("sum_lunch <", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchLessThanOrEqualTo(Integer value) {
            addCriterion("sum_lunch <=", value, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchIn(List<Integer> values) {
            addCriterion("sum_lunch in", values, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchNotIn(List<Integer> values) {
            addCriterion("sum_lunch not in", values, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchBetween(Integer value1, Integer value2) {
            addCriterion("sum_lunch between", value1, value2, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andSumLunchNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_lunch not between", value1, value2, "sumLunch");
            return (Criteria) this;
        }

        public Criteria andCountDinnerIsNull() {
            addCriterion("count_dinner is null");
            return (Criteria) this;
        }

        public Criteria andCountDinnerIsNotNull() {
            addCriterion("count_dinner is not null");
            return (Criteria) this;
        }

        public Criteria andCountDinnerEqualTo(Integer value) {
            addCriterion("count_dinner =", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerNotEqualTo(Integer value) {
            addCriterion("count_dinner <>", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerGreaterThan(Integer value) {
            addCriterion("count_dinner >", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_dinner >=", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerLessThan(Integer value) {
            addCriterion("count_dinner <", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerLessThanOrEqualTo(Integer value) {
            addCriterion("count_dinner <=", value, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerIn(List<Integer> values) {
            addCriterion("count_dinner in", values, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerNotIn(List<Integer> values) {
            addCriterion("count_dinner not in", values, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerBetween(Integer value1, Integer value2) {
            addCriterion("count_dinner between", value1, value2, "countDinner");
            return (Criteria) this;
        }

        public Criteria andCountDinnerNotBetween(Integer value1, Integer value2) {
            addCriterion("count_dinner not between", value1, value2, "countDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerIsNull() {
            addCriterion("mean_dinner is null");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerIsNotNull() {
            addCriterion("mean_dinner is not null");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerEqualTo(Integer value) {
            addCriterion("mean_dinner =", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerNotEqualTo(Integer value) {
            addCriterion("mean_dinner <>", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerGreaterThan(Integer value) {
            addCriterion("mean_dinner >", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("mean_dinner >=", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerLessThan(Integer value) {
            addCriterion("mean_dinner <", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerLessThanOrEqualTo(Integer value) {
            addCriterion("mean_dinner <=", value, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerIn(List<Integer> values) {
            addCriterion("mean_dinner in", values, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerNotIn(List<Integer> values) {
            addCriterion("mean_dinner not in", values, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerBetween(Integer value1, Integer value2) {
            addCriterion("mean_dinner between", value1, value2, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andMeanDinnerNotBetween(Integer value1, Integer value2) {
            addCriterion("mean_dinner not between", value1, value2, "meanDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerIsNull() {
            addCriterion("sum_dinner is null");
            return (Criteria) this;
        }

        public Criteria andSumDinnerIsNotNull() {
            addCriterion("sum_dinner is not null");
            return (Criteria) this;
        }

        public Criteria andSumDinnerEqualTo(Integer value) {
            addCriterion("sum_dinner =", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerNotEqualTo(Integer value) {
            addCriterion("sum_dinner <>", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerGreaterThan(Integer value) {
            addCriterion("sum_dinner >", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_dinner >=", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerLessThan(Integer value) {
            addCriterion("sum_dinner <", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerLessThanOrEqualTo(Integer value) {
            addCriterion("sum_dinner <=", value, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerIn(List<Integer> values) {
            addCriterion("sum_dinner in", values, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerNotIn(List<Integer> values) {
            addCriterion("sum_dinner not in", values, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerBetween(Integer value1, Integer value2) {
            addCriterion("sum_dinner between", value1, value2, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andSumDinnerNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_dinner not between", value1, value2, "sumDinner");
            return (Criteria) this;
        }

        public Criteria andCountMealIsNull() {
            addCriterion("count_meal is null");
            return (Criteria) this;
        }

        public Criteria andCountMealIsNotNull() {
            addCriterion("count_meal is not null");
            return (Criteria) this;
        }

        public Criteria andCountMealEqualTo(Integer value) {
            addCriterion("count_meal =", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealNotEqualTo(Integer value) {
            addCriterion("count_meal <>", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealGreaterThan(Integer value) {
            addCriterion("count_meal >", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_meal >=", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealLessThan(Integer value) {
            addCriterion("count_meal <", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealLessThanOrEqualTo(Integer value) {
            addCriterion("count_meal <=", value, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealIn(List<Integer> values) {
            addCriterion("count_meal in", values, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealNotIn(List<Integer> values) {
            addCriterion("count_meal not in", values, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealBetween(Integer value1, Integer value2) {
            addCriterion("count_meal between", value1, value2, "countMeal");
            return (Criteria) this;
        }

        public Criteria andCountMealNotBetween(Integer value1, Integer value2) {
            addCriterion("count_meal not between", value1, value2, "countMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealIsNull() {
            addCriterion("sum_meal is null");
            return (Criteria) this;
        }

        public Criteria andSumMealIsNotNull() {
            addCriterion("sum_meal is not null");
            return (Criteria) this;
        }

        public Criteria andSumMealEqualTo(Integer value) {
            addCriterion("sum_meal =", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealNotEqualTo(Integer value) {
            addCriterion("sum_meal <>", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealGreaterThan(Integer value) {
            addCriterion("sum_meal >", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_meal >=", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealLessThan(Integer value) {
            addCriterion("sum_meal <", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealLessThanOrEqualTo(Integer value) {
            addCriterion("sum_meal <=", value, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealIn(List<Integer> values) {
            addCriterion("sum_meal in", values, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealNotIn(List<Integer> values) {
            addCriterion("sum_meal not in", values, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealBetween(Integer value1, Integer value2) {
            addCriterion("sum_meal between", value1, value2, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMealNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_meal not between", value1, value2, "sumMeal");
            return (Criteria) this;
        }

        public Criteria andSumMarketIsNull() {
            addCriterion("sum_market is null");
            return (Criteria) this;
        }

        public Criteria andSumMarketIsNotNull() {
            addCriterion("sum_market is not null");
            return (Criteria) this;
        }

        public Criteria andSumMarketEqualTo(Integer value) {
            addCriterion("sum_market =", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketNotEqualTo(Integer value) {
            addCriterion("sum_market <>", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketGreaterThan(Integer value) {
            addCriterion("sum_market >", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_market >=", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketLessThan(Integer value) {
            addCriterion("sum_market <", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketLessThanOrEqualTo(Integer value) {
            addCriterion("sum_market <=", value, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketIn(List<Integer> values) {
            addCriterion("sum_market in", values, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketNotIn(List<Integer> values) {
            addCriterion("sum_market not in", values, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketBetween(Integer value1, Integer value2) {
            addCriterion("sum_market between", value1, value2, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andSumMarketNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_market not between", value1, value2, "sumMarket");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateIsNull() {
            addCriterion("count_sleeplate is null");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateIsNotNull() {
            addCriterion("count_sleeplate is not null");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateEqualTo(Integer value) {
            addCriterion("count_sleeplate =", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateNotEqualTo(Integer value) {
            addCriterion("count_sleeplate <>", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateGreaterThan(Integer value) {
            addCriterion("count_sleeplate >", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_sleeplate >=", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateLessThan(Integer value) {
            addCriterion("count_sleeplate <", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateLessThanOrEqualTo(Integer value) {
            addCriterion("count_sleeplate <=", value, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateIn(List<Integer> values) {
            addCriterion("count_sleeplate in", values, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateNotIn(List<Integer> values) {
            addCriterion("count_sleeplate not in", values, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateBetween(Integer value1, Integer value2) {
            addCriterion("count_sleeplate between", value1, value2, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andCountSleeplateNotBetween(Integer value1, Integer value2) {
            addCriterion("count_sleeplate not between", value1, value2, "countSleeplate");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelIsNull() {
            addCriterion("breakfastLabel is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelIsNotNull() {
            addCriterion("breakfastLabel is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelEqualTo(Integer value) {
            addCriterion("breakfastLabel =", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelNotEqualTo(Integer value) {
            addCriterion("breakfastLabel <>", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelGreaterThan(Integer value) {
            addCriterion("breakfastLabel >", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakfastLabel >=", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelLessThan(Integer value) {
            addCriterion("breakfastLabel <", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelLessThanOrEqualTo(Integer value) {
            addCriterion("breakfastLabel <=", value, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelIn(List<Integer> values) {
            addCriterion("breakfastLabel in", values, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelNotIn(List<Integer> values) {
            addCriterion("breakfastLabel not in", values, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelBetween(Integer value1, Integer value2) {
            addCriterion("breakfastLabel between", value1, value2, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andBreakfastlabelNotBetween(Integer value1, Integer value2) {
            addCriterion("breakfastLabel not between", value1, value2, "breakfastlabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelIsNull() {
            addCriterion("mealLabel is null");
            return (Criteria) this;
        }

        public Criteria andMeallabelIsNotNull() {
            addCriterion("mealLabel is not null");
            return (Criteria) this;
        }

        public Criteria andMeallabelEqualTo(Integer value) {
            addCriterion("mealLabel =", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelNotEqualTo(Integer value) {
            addCriterion("mealLabel <>", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelGreaterThan(Integer value) {
            addCriterion("mealLabel >", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("mealLabel >=", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelLessThan(Integer value) {
            addCriterion("mealLabel <", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelLessThanOrEqualTo(Integer value) {
            addCriterion("mealLabel <=", value, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelIn(List<Integer> values) {
            addCriterion("mealLabel in", values, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelNotIn(List<Integer> values) {
            addCriterion("mealLabel not in", values, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelBetween(Integer value1, Integer value2) {
            addCriterion("mealLabel between", value1, value2, "meallabel");
            return (Criteria) this;
        }

        public Criteria andMeallabelNotBetween(Integer value1, Integer value2) {
            addCriterion("mealLabel not between", value1, value2, "meallabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelIsNull() {
            addCriterion("consumptionLabel is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelIsNotNull() {
            addCriterion("consumptionLabel is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelEqualTo(Integer value) {
            addCriterion("consumptionLabel =", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelNotEqualTo(Integer value) {
            addCriterion("consumptionLabel <>", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelGreaterThan(Integer value) {
            addCriterion("consumptionLabel >", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumptionLabel >=", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelLessThan(Integer value) {
            addCriterion("consumptionLabel <", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelLessThanOrEqualTo(Integer value) {
            addCriterion("consumptionLabel <=", value, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelIn(List<Integer> values) {
            addCriterion("consumptionLabel in", values, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelNotIn(List<Integer> values) {
            addCriterion("consumptionLabel not in", values, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelBetween(Integer value1, Integer value2) {
            addCriterion("consumptionLabel between", value1, value2, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andConsumptionlabelNotBetween(Integer value1, Integer value2) {
            addCriterion("consumptionLabel not between", value1, value2, "consumptionlabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelIsNull() {
            addCriterion("sleeplateLabel is null");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelIsNotNull() {
            addCriterion("sleeplateLabel is not null");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelEqualTo(Integer value) {
            addCriterion("sleeplateLabel =", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelNotEqualTo(Integer value) {
            addCriterion("sleeplateLabel <>", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelGreaterThan(Integer value) {
            addCriterion("sleeplateLabel >", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("sleeplateLabel >=", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelLessThan(Integer value) {
            addCriterion("sleeplateLabel <", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelLessThanOrEqualTo(Integer value) {
            addCriterion("sleeplateLabel <=", value, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelIn(List<Integer> values) {
            addCriterion("sleeplateLabel in", values, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelNotIn(List<Integer> values) {
            addCriterion("sleeplateLabel not in", values, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelBetween(Integer value1, Integer value2) {
            addCriterion("sleeplateLabel between", value1, value2, "sleeplatelabel");
            return (Criteria) this;
        }

        public Criteria andSleeplatelabelNotBetween(Integer value1, Integer value2) {
            addCriterion("sleeplateLabel not between", value1, value2, "sleeplatelabel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}