public class Manager {


    private CompetitorList comp = new CompetitorList("Data.csv");






    public void writeReport(String filename) {
        comp.writeReport(filename);
    }

    public String checkCompetitor(int num) {
        return comp.checkCompetitorExists(num);
    }



}



