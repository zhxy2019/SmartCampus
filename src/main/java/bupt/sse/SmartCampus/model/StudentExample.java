package bupt.sse.SmartCampus.model;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classId is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classId is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(String value) {
            addCriterion("classId =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(String value) {
            addCriterion("classId <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(String value) {
            addCriterion("classId >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(String value) {
            addCriterion("classId >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(String value) {
            addCriterion("classId <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(String value) {
            addCriterion("classId <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLike(String value) {
            addCriterion("classId like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotLike(String value) {
            addCriterion("classId not like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<String> values) {
            addCriterion("classId in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<String> values) {
            addCriterion("classId not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(String value1, String value2) {
            addCriterion("classId between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(String value1, String value2) {
            addCriterion("classId not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andWeightscoreIsNull() {
            addCriterion("weightScore is null");
            return (Criteria) this;
        }

        public Criteria andWeightscoreIsNotNull() {
            addCriterion("weightScore is not null");
            return (Criteria) this;
        }

        public Criteria andWeightscoreEqualTo(Double value) {
            addCriterion("weightScore =", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreNotEqualTo(Double value) {
            addCriterion("weightScore <>", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreGreaterThan(Double value) {
            addCriterion("weightScore >", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreGreaterThanOrEqualTo(Double value) {
            addCriterion("weightScore >=", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreLessThan(Double value) {
            addCriterion("weightScore <", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreLessThanOrEqualTo(Double value) {
            addCriterion("weightScore <=", value, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreIn(List<Double> values) {
            addCriterion("weightScore in", values, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreNotIn(List<Double> values) {
            addCriterion("weightScore not in", values, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreBetween(Double value1, Double value2) {
            addCriterion("weightScore between", value1, value2, "weightscore");
            return (Criteria) this;
        }

        public Criteria andWeightscoreNotBetween(Double value1, Double value2) {
            addCriterion("weightScore not between", value1, value2, "weightscore");
            return (Criteria) this;
        }

        public Criteria andStudentrankIsNull() {
            addCriterion("studentRank is null");
            return (Criteria) this;
        }

        public Criteria andStudentrankIsNotNull() {
            addCriterion("studentRank is not null");
            return (Criteria) this;
        }

        public Criteria andStudentrankEqualTo(Integer value) {
            addCriterion("studentRank =", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankNotEqualTo(Integer value) {
            addCriterion("studentRank <>", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankGreaterThan(Integer value) {
            addCriterion("studentRank >", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentRank >=", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankLessThan(Integer value) {
            addCriterion("studentRank <", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankLessThanOrEqualTo(Integer value) {
            addCriterion("studentRank <=", value, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankIn(List<Integer> values) {
            addCriterion("studentRank in", values, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankNotIn(List<Integer> values) {
            addCriterion("studentRank not in", values, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankBetween(Integer value1, Integer value2) {
            addCriterion("studentRank between", value1, value2, "studentrank");
            return (Criteria) this;
        }

        public Criteria andStudentrankNotBetween(Integer value1, Integer value2) {
            addCriterion("studentRank not between", value1, value2, "studentrank");
            return (Criteria) this;
        }

        public Criteria andFailurenumIsNull() {
            addCriterion("failureNum is null");
            return (Criteria) this;
        }

        public Criteria andFailurenumIsNotNull() {
            addCriterion("failureNum is not null");
            return (Criteria) this;
        }

        public Criteria andFailurenumEqualTo(Integer value) {
            addCriterion("failureNum =", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumNotEqualTo(Integer value) {
            addCriterion("failureNum <>", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumGreaterThan(Integer value) {
            addCriterion("failureNum >", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("failureNum >=", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumLessThan(Integer value) {
            addCriterion("failureNum <", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumLessThanOrEqualTo(Integer value) {
            addCriterion("failureNum <=", value, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumIn(List<Integer> values) {
            addCriterion("failureNum in", values, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumNotIn(List<Integer> values) {
            addCriterion("failureNum not in", values, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumBetween(Integer value1, Integer value2) {
            addCriterion("failureNum between", value1, value2, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurenumNotBetween(Integer value1, Integer value2) {
            addCriterion("failureNum not between", value1, value2, "failurenum");
            return (Criteria) this;
        }

        public Criteria andFailurecreditIsNull() {
            addCriterion("failureCredit is null");
            return (Criteria) this;
        }

        public Criteria andFailurecreditIsNotNull() {
            addCriterion("failureCredit is not null");
            return (Criteria) this;
        }

        public Criteria andFailurecreditEqualTo(Integer value) {
            addCriterion("failureCredit =", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditNotEqualTo(Integer value) {
            addCriterion("failureCredit <>", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditGreaterThan(Integer value) {
            addCriterion("failureCredit >", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("failureCredit >=", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditLessThan(Integer value) {
            addCriterion("failureCredit <", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditLessThanOrEqualTo(Integer value) {
            addCriterion("failureCredit <=", value, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditIn(List<Integer> values) {
            addCriterion("failureCredit in", values, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditNotIn(List<Integer> values) {
            addCriterion("failureCredit not in", values, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditBetween(Integer value1, Integer value2) {
            addCriterion("failureCredit between", value1, value2, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andFailurecreditNotBetween(Integer value1, Integer value2) {
            addCriterion("failureCredit not between", value1, value2, "failurecredit");
            return (Criteria) this;
        }

        public Criteria andGrindIsNull() {
            addCriterion("grind is null");
            return (Criteria) this;
        }

        public Criteria andGrindIsNotNull() {
            addCriterion("grind is not null");
            return (Criteria) this;
        }

        public Criteria andGrindEqualTo(Integer value) {
            addCriterion("grind =", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindNotEqualTo(Integer value) {
            addCriterion("grind <>", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindGreaterThan(Integer value) {
            addCriterion("grind >", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindGreaterThanOrEqualTo(Integer value) {
            addCriterion("grind >=", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindLessThan(Integer value) {
            addCriterion("grind <", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindLessThanOrEqualTo(Integer value) {
            addCriterion("grind <=", value, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindIn(List<Integer> values) {
            addCriterion("grind in", values, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindNotIn(List<Integer> values) {
            addCriterion("grind not in", values, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindBetween(Integer value1, Integer value2) {
            addCriterion("grind between", value1, value2, "grind");
            return (Criteria) this;
        }

        public Criteria andGrindNotBetween(Integer value1, Integer value2) {
            addCriterion("grind not between", value1, value2, "grind");
            return (Criteria) this;
        }

        public Criteria andFailIsNull() {
            addCriterion("fail is null");
            return (Criteria) this;
        }

        public Criteria andFailIsNotNull() {
            addCriterion("fail is not null");
            return (Criteria) this;
        }

        public Criteria andFailEqualTo(Integer value) {
            addCriterion("fail =", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotEqualTo(Integer value) {
            addCriterion("fail <>", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThan(Integer value) {
            addCriterion("fail >", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail >=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThan(Integer value) {
            addCriterion("fail <", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThanOrEqualTo(Integer value) {
            addCriterion("fail <=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailIn(List<Integer> values) {
            addCriterion("fail in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotIn(List<Integer> values) {
            addCriterion("fail not in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailBetween(Integer value1, Integer value2) {
            addCriterion("fail between", value1, value2, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotBetween(Integer value1, Integer value2) {
            addCriterion("fail not between", value1, value2, "fail");
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