package bupt.sse.SmartCampus.model;

public class StudentStudy {
    private Integer id;

    private String year;

    private Integer term;

    private String studentid;

    private Double weightscore;

    private Integer studentrank;

    private Integer ascend;

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

    public Integer getAscend() {
        return ascend;
    }

    public void setAscend(Integer ascend) {
        this.ascend = ascend;
    }
}