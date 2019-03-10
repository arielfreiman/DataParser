import java.util.*;
public class ElectionResult {
    private double votes_dem;
    private double votes_gop;
    private double total_votes;
    private double per_dem;
    private double per_gop;
    private double diff;
    private double per_point;
    private double per_point_diff;
    private String state_abbr;
    private String country_name;
    private String combined_fips;

    public ElectionResult(){

    }
    public double getVotes_dem() {
        return votes_dem;
    }

    public void setVotes_dem(double votes_dem) {
        this.votes_dem = votes_dem;
    }

    public double getVotes_gop() {
        return votes_gop;
    }

    public void setVotes_gop(double votes_gop) {
        this.votes_gop = votes_gop;
    }

    public double getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(double total_votes) {
        this.total_votes = total_votes;
    }

    public double getPer_dem() {
        return per_dem;
    }

    public void setPer_dem(double per_dem) {
        this.per_dem = per_dem;
    }

    public double getPer_gop() {
        return per_gop;
    }

    public void setPer_gop(double per_gop) {
        this.per_gop = per_gop;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getPer_point() {
        return per_point;
    }

    public void setPer_point(double per_point) {
        this.per_point = per_point;
    }

    public double getPer_point_diff() {
        return per_point_diff;
    }

    public void setPer_point_diff(double per_point_diff) {
        this.per_point_diff = per_point_diff;
    }

    public String getState_abbr() {
        return state_abbr;
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCombined_fips() {
        return combined_fips;
    }

    public void setCombined_fips(String combined_fips) {
        this.combined_fips = combined_fips;
    }
}
