import java.io.File;
import java.io.IOException;
import java.util.*;
public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        data=readFileAsString(data);
        ArrayList <ElectionResult> elect_results = new ArrayList<>();
        String[] lines = data.split("\n");
        for (int i = 1; i <lines.length ; i++) {
            String[] arrdata = cleanLines(lines[i]);
            if(arrdata != null) {
                double Votes_dem = Double.parseDouble(arrdata[1]);
                double Votes_gop = (Double.parseDouble(arrdata[2]));
                double Total_votes = (Double.parseDouble(arrdata[3]));
                double Per_dem = (Double.parseDouble(arrdata[4]));
                double Per_gop = (Double.parseDouble(arrdata[5]));
                double Diff = (Double.parseDouble(arrdata[6]));
                double Per_point_diff = (Double.parseDouble(arrdata[7]));
                String State_abbr = (arrdata[8]);
                String Country_name = (arrdata[9]);
                String Combined_fips = (arrdata[10]);
                ElectionResult elect = new ElectionResult(Votes_dem, Votes_gop, Total_votes, Per_dem, Per_gop, Diff, Per_point_diff, State_abbr, Country_name, Combined_fips);
                elect_results.add(elect);
            }
        }
        return elect_results;

    }

    public static ArrayList<EducationResult> parseEducationResults (String data){
        data=readFileAsString(data);
        ArrayList <EducationResult> educationResults=new ArrayList<>();
        String[] lines = data.split("\n");
        for (int i = 7; i <lines.length ; i++) {
            String[] arrdata = cleanLines(lines[i]);
            if(arrdata != null) {
                String stateName = arrdata[1];
                String county = arrdata[2];
                double precentLessHSDip = Double.parseDouble(arrdata[40]);
                double precentOnlyHS = Double.parseDouble(arrdata[41]);
                double someCollege = Double.parseDouble(arrdata[42]);
                double bachlorOrHigher = Double.parseDouble(arrdata[43]);
                EducationResult result = new EducationResult(stateName,county,precentLessHSDip,precentOnlyHS,someCollege,bachlorOrHigher);
                educationResults.add(result);
            }
        }
        return educationResults;
    }

    private static String[] cleanLines(String line){

        if (line.indexOf(",")+1 != line.substring(line.indexOf(",")+1).indexOf(",")) {
            int indexFirstQ = line.indexOf("\"");
            int indexSecQ = line.indexOf("\"", indexFirstQ + 1);
            while (indexFirstQ != -1 && indexSecQ != -1) {

                while (line.substring(indexFirstQ, indexSecQ).indexOf(",") != -1) {
                    int indexCom = line.substring(indexFirstQ, indexSecQ).indexOf(",");
                    if (indexCom!=-1) {
                        line = line.substring(0, indexCom) + line.substring(indexCom + 1);
                    }
                }
                line = line.substring(0, indexFirstQ) + line.substring(indexFirstQ + 1, indexSecQ) + line.substring(indexSecQ + 1);
                indexFirstQ = line.indexOf("\"");
                indexSecQ = line.indexOf("\"");

            }
            int indexPerc = line.indexOf("%");
            while (indexPerc != (-1)) {
                line = line.substring(0, indexPerc) + line.substring(indexPerc + 1);
                indexPerc = line.indexOf("%");
            }
            int indexDollar = line.indexOf("$");
            while (indexDollar != (-1)) {
                line = line.substring(0, indexDollar) + line.substring(indexDollar + 1);
                indexDollar = line.indexOf("$");
            }
            return line.split(",");
        }
        else return null;
    }

    private static String[] splitData(String line) {
        int index_firstQuot=0,index_coma=0;
        index_firstQuot=line.indexOf("\"");
        if (index_firstQuot==-1){
            String out = line.substring(0, line.indexOf("%")) + line.substring(line.indexOf("%") + 1);
            return out.split(",");
        }
        index_coma = line.indexOf(",", index_firstQuot);
        String temp = line.substring(0, index_coma) + line.substring(index_coma + 1);
        String[] arr = temp.split("\"");
        String temp2 = "";
        for (int i = 0; i < arr.length; i++) {
            temp2 += arr[i];
        }
        String output = temp2.substring(0, temp2.indexOf("%")) + temp2.substring(temp2.indexOf("%") + 1);
        return output.split(",");


    }

}
