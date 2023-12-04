

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UserInterface implements ActionListener{
    private JFrame window1, window2, window3;
    //Window 1 = View and Alter, View Full and Short details given Number, View Competitors of Specific Country.
    //Window 2 = View Competitors sorted in Different Ways
    //Window 3 = Edit Competitor Details and Remove Competitor by Number

    private JTextField findCompetitor, findCountry, findCmp2;
    private JLabel enterNumber, enterCountry, enterNumber2;
    private JButton viewFullBtn, viewShortBtn, viewSpecificBtn,
            window2Btn, sortReverse, sortAscend, window3Btn, removeBtn, saveBtn, saveBtn2, saveBtn3, next2, back2Home;
    private JTextArea text1, text2, text3;
    private CompetitorList c1 = new CompetitorList("Data.csv");

    public UserInterface() {
        initUi();
    }

    public void initUi() {
        window1 = new JFrame("View Competitors");
        window1.setBounds(100,100,600,600);
        window1.setLayout(new FlowLayout());
        findCompetitor = new JTextField(10);
        findCountry = new JTextField(10);
        enterNumber = new JLabel("Enter Competitor Number:");
        enterCountry = new JLabel("Enter Country:");
        viewFullBtn = new JButton("View Full Details");
        viewFullBtn.addActionListener(this);
        viewShortBtn = new JButton("View Short Details");
        viewShortBtn.addActionListener(this);
        viewSpecificBtn = new JButton("View Competitors by Country");
        viewSpecificBtn.addActionListener(this);
        window2Btn = new JButton("Sort All Competitors");
        window2Btn.addActionListener(this);
        window3Btn = new JButton("Remove/Edit Competitors");
        window3Btn.addActionListener(this);
        saveBtn = new JButton("Save and Exit");
        saveBtn.addActionListener(this);
        text1 = new JTextArea(10,60);
        window1.add(enterNumber);
        window1.add(findCompetitor);
        window1.add(viewFullBtn);
        window1.add(viewShortBtn);
        window1.add(enterCountry);
        window1.add(findCountry);
        window1.add(viewSpecificBtn);
        window1.add(window2Btn);
        window1.add(window3Btn);
        window1.add(saveBtn);
        window1.add(text1);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setVisible(true);
    }

    public String getCountry() {
        return findCountry.getText();
    }

    public int getComp() {
        return Integer.parseInt(findCompetitor.getText());
    }
    public int getComp2() {
        return Integer.parseInt(findCmp2.getText());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewFullBtn) {
            text1.setText(c1.checkCompetitor(getComp()));
        }
        else if(e.getSource() == viewShortBtn) {
            text1.setText(c1.checkCompetitorExists(getComp()));
        }
        else if(e.getSource() == viewSpecificBtn) {
            text1.setText(c1.getCompByCountry(getCountry()));
        }

        else if(e.getSource() == window2Btn) {
            window2();
        }
        else if(e.getSource() ==sortAscend) {
            text2.setText(c1.getAllCompetitors());
        }
        else if(e.getSource() ==sortReverse) {
            text2.setText(c1.reversal());
            }

        else if(e.getSource() == window3Btn) {
           window3();
        }

        else if(e.getSource() == removeBtn) {
            text3.setText(c1.removeCompetitor(getComp2()));
        }
        else if(e.getSource() == saveBtn) {
            saveExit();
        }
        else if(e.getSource() == saveBtn2) {
            saveExit();
        }
        else if(e.getSource() == saveBtn3) {
            saveExit();
        }
        else if(e.getSource() == next2) {
            window3();
        }
        else if(e.getSource() == back2Home) {
            initUi();
        }

    }
    public void window2() {
        window2 = new JFrame("Sort Competitors");
        window2.setBounds(100,100,600,600);
        window2.setLayout(new FlowLayout());
        sortReverse = new JButton("Sort By Number Descending");
        sortReverse.addActionListener(this);
        sortAscend = new JButton("Sort by Number Ascending");
        sortAscend.addActionListener(this);
        saveBtn2 = new JButton("Save/Exit");
        saveBtn2.addActionListener(this);
        next2 = new JButton("Next Page");
        next2.addActionListener(this);
        text2 = new JTextArea(10,60);
        window2.add(sortAscend);
        window2.add(sortReverse);
        window2.add(saveBtn2);
        window2.add(next2);
        window2.add(text2);
        window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window2.setVisible(true);
    }
    public void window3() {
        window3 = new JFrame("Remove and Edit Competitors");
        window3.setBounds(100,100,600,600);
        window3.setLayout(new FlowLayout());
        enterNumber2 = new JLabel("Enter Comp Number");
        findCmp2 = new JTextField(10);
        removeBtn = new JButton("Remove Competitor");
        removeBtn.addActionListener(this);
        saveBtn3 = new JButton("Save to File");
        saveBtn3.addActionListener(this);
        back2Home = new JButton("Home Page");
        back2Home.addActionListener(this);
        text3 = new JTextArea(10, 60);
        window3.add(enterNumber2);
        window3.add(findCmp2);
        window3.add(removeBtn);
        window3.add(saveBtn3);
        window3.add(back2Home);
        window3.add(text3);
        window3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window3.setVisible(true);
    }

    public void saveExit() {
        c1.writeReport("Report");
        System.exit(1);
    }
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
    }
}
