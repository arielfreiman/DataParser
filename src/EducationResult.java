public class EducationResult {
    private String state;
    private String County;
    private double precentLessHSDip;
    private double precentOnlyHS;
    private double someCollege;
    private double bachlorOrHigher;
    private String level;

    public EducationResult(String state, String county, double precentLessHSDip, double precentOnlyHS, double someCollege, double bachlorOrHigher, String level) {
        this.state = state;
        County = county;
        this.precentLessHSDip = precentLessHSDip;
        this.precentOnlyHS = precentOnlyHS;
        this.someCollege = someCollege;
        this.bachlorOrHigher = bachlorOrHigher;
        this.level=level;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "EducationResult{" +
                "state='" + state + '\'' +
                ", County='" + County + '\'' +
                ", precentLessHSDip=" + precentLessHSDip +
                ", precentOnlyHS=" + precentOnlyHS +
                ", someCollege=" + someCollege +
                ", bachlorOrHigher=" + bachlorOrHigher + ", level="+level+
                '}';
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
    public String getLevel(){return level;}
}
