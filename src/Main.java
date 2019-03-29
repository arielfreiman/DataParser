import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test of utils
        //String data=Utils.readFileAsString("data/2016_Presidential_Results.csv");
        //System.out.println(data);

        ArrayList<UnemploymentResults> results = Utils.parseUnemploymentResults("data/Unemployment.csv");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        writeDataToFile("UnemploymentParsed.csv",unemploy_presentData(results));
    }





    public static String elect_presentData(ArrayList<ElectionResult> results){
        String out= "State , County , Democrats , Republican , Major Votes "+"\n";
        for (int i = 0; i < results.size(); i++) {
            out += results.get(i).getState_abbr()+" , "+results.get(i).getCountry_name()+" , "
                    +results.get(i).getVotes_dem()+" , "+results.get(i).getVotes_gop()+" , "+results.get(i).getMajor_votes()+"\n";
        }
        return out;
    }
    public static String edu_presentData(ArrayList<EducationResult> results){
        String out= "State , County , Less Than HS Dip , HS Dip , Some College , Bachelor+ , Level "+"\n";
        for (int i = 0; i < results.size(); i++) {
            out += results.get(i).getState()+" , "+results.get(i).getCounty()+" , "
                    +results.get(i).getPrecentLessHSDip()+" , "+results.get(i).getPrecentOnlyHS()+" , "
                    +results.get(i).getSomeCollege()+" , "+results.get(i).getBachlorOrHigher()+" , "+results.get(i).getLevel()+"\n";
        }
        return out;
    }
    public static String unemploy_presentData(ArrayList<UnemploymentResults> results){
        String out= "State , County , Unemployment Rate 2012 , Unemployment Rate 2013 , Unemployment Rate 2014 , Unemployment Rate 2015 , Unemployment Rate 2016 "+"\n";
        for (int i = 0; i < results.size(); i++) {
            out += results.get(i).getState()+" , "+results.get(i).getCounty()+" , "
                    +results.get(i).getUnemployRate2012()+" , "+results.get(i).getUnemployRate2013()+" , "
                    +results.get(i).getUnemployRate2014()+" , "+results.get(i).getUnemployRate2015()+" , "+results.get(i).getUnemployRate2016()+"\n";
        }
        return out;
    }
    public static void writeDataToFile (String filePath, String data){
        File outFile=new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))){
            writer.write(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
