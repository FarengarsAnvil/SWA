import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompetitorList {


    private ArrayList<Competitor> competitorList = new ArrayList<Competitor>();


    /**
     * @param filename = String representing a file to which data is read from for the Constructor.
     *                 A filename/path is passed to the Constructor to which a file is read to form the basis of the Class.
     */
    public CompetitorList(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Competitor temp;
                String line = scanner.nextLine();
                String items[] = line.split(",");
                temp = new Competitor(items[0], items[1], items[2], items[3], Integer.parseInt(items[4]), items[5], Integer.parseInt(items[6]), items[7], items[8], items[9]);
                temp.setScore(Integer.parseInt(items[10]), 0);
                temp.setScore(Integer.parseInt(items[11]), 1);
                temp.setScore(Integer.parseInt(items[12]), 2);
                temp.setScore(Integer.parseInt(items[13]), 3);
                temp.setAverage();
                competitorList.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * @param filename = String representing name of file to which report is written to.
     *                 Function creates a File with filename param which is a report of the entire competition with Statistics.
     */
    public void writeReport(String filename) {
        try {
            FileWriter file = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(getAllCompetitors());
            bw.write("\n");
            bw.write(getHighestCompetitorAsString());
            bw.write("\n");
            bw.write("\n");
            bw.write(getTotalsAsString());
            bw.write("\n");
            bw.write(getLowestCompetitorAsString());
            bw.write("\n");
            bw.write(getMaximum());
            bw.write("\n");
            bw.write(getMinimum());
            bw.write("\n");
            bw.write("\n");
            bw.write(getFrequencyReport());
            bw.close();
        } catch (Exception e) {
            System.out.println("Error whilst writing");
        }
    }

    /**
     * Returns the details of the Highest Scoring Competitor as a String
     */
    public String getHighestCompetitorAsString() {
        double highest = 0;
        Competitor temp = null;
        for (int i = 0; i < competitorList.size(); i++) {
            if (competitorList.get(i).getOverallScore() > highest) {
                highest = competitorList.get(i).getOverallScore();
                temp = competitorList.get(i);
            }
        }
        if (temp != null) {
            return "The Highest Scoring Competitor is:\n" + temp.getAllDetails();
        } else {
            return "Error";
        }
    }

    /**
     * Returns the details of the Lowest Competitor as a String
     */
    public String getLowestCompetitorAsString() {
        double lowest = 5;
        Competitor temp = null;
        for (int i = 0; i < competitorList.size(); i++) {
            if (competitorList.get(i).getOverallScore() < lowest) {
                lowest = competitorList.get(i).getOverallScore();
                temp = competitorList.get(i);
            }
        }
        if (temp != null) {
            return "The Lowest scoring competitor is:\n" + temp.getAllDetails();
        } else {
            return "Error";
        }
    }

    /**
     * @return = String of all the Totals listed for each competitor
     */
    public String getTotalsAsString() {
        String ret = "Totals:\n";
        for (int i = 0; i < competitorList.size(); i++) {
            ret += "Competitor:" + competitorList.get(i).getCompNumber() + " " + competitorList.get(i).getTotal() + " \n";
        }
        return ret;
    }

    /**
     * @return = Statistic displaying the Maximum cumulative score.
     */
    public String getMaximum() {
        int highest = 0;
        for (int i = 0; i < competitorList.size(); i++) {
            if (competitorList.get(i).getTotal() > highest) {
                highest = competitorList.get(i).getTotal();
            }
        }
        return "The maximum overall score was: " + highest;
    }

    /**
     * @return = Lowest scored result out of all Competitors
     */
    public String getMinimum() {
        int lowest = 5;
        for (int i = 0; i < competitorList.size(); i++) {
            if (competitorList.get(i).getMinimum() < lowest) {
                lowest = competitorList.get(i).getMinimum();
            }
        }
        return "The minimum competition score was: " + lowest;
    }

    /**
     * @return = String of all the Short details for every Competitor.
     */
    public String getAllCompetitors() {
        String ret = "";
        for (int i = 0; i < competitorList.size(); i++) {
            ret += competitorList.get(i).getAllDetails() + "\n";
        }
        return ret;
    }


    public String getFrequencyReport() {
        int fiveTally = 0;
        int fourTally = 0;
        int threeTally = 0;
        int twoTally = 0;
        int oneTally = 0;
        int zeroTally = 0;
        for (int i = 0; i < competitorList.size(); i++) {
            for (int j = 0; j < competitorList.get(i).getScoreArray().length; j++) {
                if (competitorList.get(i).getScoreArray()[j] == 5) {
                    fiveTally++;
                } else if (competitorList.get(i).getScoreArray()[j] == 4) {
                    fourTally++;
                } else if (competitorList.get(i).getScoreArray()[j] == 3) {
                    threeTally++;
                } else if (competitorList.get(i).getScoreArray()[j] == 2) {
                    twoTally++;
                } else if (competitorList.get(i).getScoreArray()[j] == 1) {
                    oneTally++;

                } else {
                    zeroTally++;
                }
            }
        }
        return "Frequency report\n" + "Number of 5's scored:" + fiveTally + "\nNumber of 4's scored:" + fourTally +
                "\nNumber of 3's scored:" + threeTally + "\nNumber of 2's scored:" + twoTally + "\nNumber of 1's scored:" + oneTally +
                "\nNumber of 0's scored:" + zeroTally;
    }

    /**
     * @param num = Represents the Competitor Number of a Competitor
     * @return = If num is a valid Compeitor number, then the shortDetails of the competitor is returned, else an error message
     */
    public String checkCompetitorExists(int num) {
        for (int i = 0; i < competitorList.size(); i++) {
            if (num == competitorList.get(i).getCompNumber()) {
                return competitorList.get(i).getShortDetails();
            }
        }
        return "Invalid Competitor Number";
    }

    public String checkCompetitor(int num) {
        for (int i = 0; i < competitorList.size(); i++) {
            if (num == competitorList.get(i).getCompNumber()) {
                return competitorList.get(i).getAllDetails();
            }
        }
        return "Invalid Competitor Number";
    }

    /**
     * @param cnt = String representing a Country
     * @return = String of full details of competitors from param country.
     */
    public String getCompByCountry(String cnt) {
        String ret = "";
        for (int i = 0; i < competitorList.size(); i++) {
            if (cnt.equals(competitorList.get(i).getCountry())) {
                ret += competitorList.get(i).getAllDetails() + "\n";
            }
        }
        return ret;
    }

    public String removeCompetitor(int num) {
        for (int i = 0; i < competitorList.size(); i++) {
            if (num == competitorList.get(i).getCompNumber()) {
                competitorList.remove(i);
                return "Competitor has been removed\n" + getAllCompetitors();
            }
        }
        return "Invalid Competitor Number";
    }

    public void save() {

    }

    /**
     * @return = Lists competitors in reverse order
     */
    public String reversal() {
        ArrayList<Competitor> temp = new ArrayList<>();
        String ret = "";
        for (int i = competitorList.size() -1; i >= 0; i--) {
            temp.add(competitorList.get(i));
            ret += competitorList.get(i).getAllDetails() + "\n";
        }
        return ret;
    }

}