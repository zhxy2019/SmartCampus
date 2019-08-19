package bupt.sse.SmartCampus.model;

public class Student {
    private String studentid;

    private String password;

    private String studentname;

    private String classid;

    private String grade;

    private Double weightscore;

    private Integer studentrank;

    private Integer failurenum;

    private Integer failurecredit;

    private Integer grind;

    private Integer fail;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Double getWeightscore() {
        return weightscore;
    }

    public void setWeightscore(Double weightscore) {
        this.weightscore = weightscore;
    }

    public Integer getStudentrank() {
        return studentrank;
    }

    public void setStudentrank(Integer studentrank) {
        this.studentrank = studentrank;
    }

    public Integer getFailurenum() {
        return failurenum;
    }

    public void setFailurenum(Integer failurenum) {
        this.failurenum = failurenum;
    }

    public Integer getFailurecredit() {
        return failurecredit;
    }

    public void setFailurecredit(Integer failurecredit) {
        this.failurecredit = failurecredit;
    }

    public Integer getGrind() {
        return grind;
    }

    public void setGrind(Integer grind) {
        this.grind = grind;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }
}