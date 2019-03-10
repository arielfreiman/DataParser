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
        ArrayList <ElectionResult> elect_results = new ArrayList<>();
        String[] lines = data.split("\n");
        for (int i = 1; i <lines.length ; i++) {
            String[] arrdata = lines[i].split(",");
            ElectionResult elect = new ElectionResult();
            for (int j = 0; j < arrdata.length; j++) {
                if (arrdata[i].indexOf("\"")!=-1){
                    arrdata[i]=deleteQuotes(arrdata[i]);
                }
                if (arrdata[i].indexOf("%")!=-1){
                    arrdata[i]=deletePrecent(arrdata[i]);
                }
                if (arrdata[i].indexOf(",")!=-1){
                    arrdata[i]=deleteComa(arrdata[i]);
                }
            }
            elect.setVotes_dem(Double.parseDouble(arrdata[1]));
            elect.setVotes_gop(Double.parseDouble(arrdata[2]));
            elect.setTotal_votes(Double.parseDouble(arrdata[3]));
            elect.setPer_dem(Double.parseDouble(arrdata[4]));
            elect.setPer_gop(Double.parseDouble(arrdata[5]));
            elect.setDiff(Double.parseDouble(arrdata[6]));
            elect.setPer_point_diff(Double.parseDouble(arrdata[7]));
            elect.setState_abbr(arrdata[8]);
            elect.setCountry_name(arrdata[9]);
            elect.setCombined_fips(arrdata[10]);
            elect_results.add(elect);
        }
        return elect_results;

}

    private static String deleteComa(String str) {
        String[] newStringArr=str.split(",");
        String output="";
        for (int i = 0; i < newStringArr.length; i++) {
            output+=newStringArr[i];
        }
        return output;
    }

    private static String deletePrecent(String str) {
        return str.substring(0,str.length()-1);
    }

    private static String deleteQuotes(String str) {
        return str.substring(1,str.length()-1);
    }
}
