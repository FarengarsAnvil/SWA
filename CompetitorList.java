import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitorList {



    private ArrayList<Competitor> competitorList = new ArrayList<Competitor>();


    /**
     * @param filename = String representing a file to which data is read from for the Constructor.
     */
    public CompetitorList(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                Competitor temp;
                String line = scanner.nextLine();
                String items[] = line.split(",");
                temp = new Competitor(items[0], items[1], items[2], items[3],Integer.parseInt(items[4]), items[5],Integer.parseInt(items[6]), items[7], items[8], items[9]);
                temp.setScore(Integer.parseInt(items[10]), 0);
                temp.setScore(Integer.parseInt(items[11]), 1);
                temp.setScore(Integer.parseInt(items[12]), 2);
                temp.setScore(Integer.parseInt(items[13]), 3);
                temp.setAverage();
                competitorList.add(temp);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * @param filename = String representing name of file to which report is written to.
     */
    public void writeReport(String filename) {
            try {
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                //this keyword pertains to the current Object, so we're saving the current object to a file.
                objectOut.writeObject(this);
                objectOut.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    public String getHighestCompetitorAsString() {
        double highest = 0;
        Competitor temp = null;
        for(int i=0; i<competitorList.size(); i++) {
        if(competitorList.get(i).getOverallScore() > highest) {
            highest = competitorList.get(i).getOverallScore();
            temp = competitorList.get(i);
        }
        }
        return temp.getAllDetails();
    }

    public String getAllCompetitors() {
        String ret = "";
        for(int i=0; i<competitorList.size(); i++){
            ret += competitorList.get(i).getShortDetails() + ",";
        }
        return ret;
    }

    public static void main(String[] args) {

        CompetitorList l1 = new CompetitorList("Data.csv");
        System.out.println(l1.getHighestCompetitorAsString());


    }


}





