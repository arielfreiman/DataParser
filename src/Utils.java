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
            String[] arrdata = splitData(lines[i]);

            double Votes_dem= Double.parseDouble(arrdata[1]);
            double Votes_gop= (Double.parseDouble(arrdata[2]));
            double Total_votes= (Double.parseDouble(arrdata[3]));
            double Per_dem= (Double.parseDouble(arrdata[4]));
            double Per_gop= (Double.parseDouble(arrdata[5]));
            double Diff= (Double.parseDouble(arrdata[6]));
            double Per_point_diff= (Double.parseDouble(arrdata[7]));
            String State_abbr= (arrdata[8]);
            String Country_name= (arrdata[9]);
            String Combined_fips= (arrdata[10]);
            ElectionResult elect = new ElectionResult(Votes_dem,Votes_gop,Total_votes,Per_dem,Per_gop,Diff,Per_point_diff,State_abbr,Country_name,Combined_fips);
            elect_results.add(elect);
        }
        return elect_results;

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
