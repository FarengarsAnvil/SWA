
public class Manager {

    private CompetitorList comp = new CompetitorList("Data.csv");
    private UserInterface ui = new UserInterface();

    public Manager() {

    }
    public void writeReport(String filename) {
        comp.writeReport(filename);
    }

    public String checkCompetitor(int num) {
        return comp.checkCompetitorExists(num);
    }
    public void initGUI() {
        ui.initUi();
    }

    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.initGUI();
    }
}









