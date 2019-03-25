public class EducationResult {
    private String code;
    private String state;
    private String County;
    private double precentLessHSDip;
    private double precentOnlyHS;
    private double someCollege;
    private double bachlorOrHigher;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public double getPrecentLessHSDip() {
        return precentLessHSDip;
    }

    public void setPrecentLessHSDip(double precentLessHSDip) {
        this.precentLessHSDip = precentLessHSDip;
    }

    public double getPrecentOnlyHS() {
        return precentOnlyHS;
    }

    public void setPrecentOnlyHS(double precentOnlyHS) {
        this.precentOnlyHS = precentOnlyHS;
    }

    public double getSomeCollege() {
        return someCollege;
    }

    public void setSomeCollege(double someCollege) {
        this.someCollege = someCollege;
    }

    public double getBachlorOrHigher() {
        return bachlorOrHigher;
    }

    public void setBachlorOrHigher(double bachlorOrHigher) {
        this.bachlorOrHigher = bachlorOrHigher;
    }
}
