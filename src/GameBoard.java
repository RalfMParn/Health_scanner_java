import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private JButton btnAvaFail;
    private JButton btnResult;
    private JTextArea txtArea;
    private JComboBox<String> cmbvaliFail;

    public GameBoard() {
        setPreferredSize(new Dimension(325, 300));
        setLayout(new BorderLayout());

        createComponents();
    }

    private void createComponents() {
        //Loome taustavärvi
        Color background = new Color(177, 250, 239);
        //loome kolm paneeli
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel bottomPanel = new JPanel();
        //JPanel rightPanel = new JPanel(); //Default on FlowLayout

        //centerPanel.setBackground(background);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5,5));
        //rightPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        //rightPanel.setBackground(background);
        //rightPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setPreferredSize(new Dimension(250,5));

        //topPaneli sisu


        //cmbTimes = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        //topPanel.add(cmbTimes);

        btnAvaFail = new JButton("Ava fail");
        topPanel.add(btnAvaFail);
        cmbvaliFail = new JComboBox<>(new String[]{"Valifail", "Vali teine fail"});
        topPanel.add(cmbvaliFail);
        btnResult = new JButton("Näita tulemusi");
        topPanel.add(btnResult);
        JLabel lblTime = new JLabel("Siia tuleb failinimi");
        centerPanel.add(lblTime);

        //centerPanel sisu
        txtArea = new JTextArea(10,15);
        txtArea.setFont(new Font("Courier", Font.PLAIN, 14));
        //centerPanel.add(new JScrollPane(txtArea));

        bottomPanel.add(txtArea);

        //ButtonGroup btnGroup = new ButtonGroup(); //Raadionuppude grupeerimiseks
        //rdoKmh = new JRadioButton("Kmh");
        //rdoKmh.setBackground(background);
        //rdoMph = new JRadioButton("Mph");
        //rdoMph.setBackground(background);
        //rdoKmh.setSelected(true);
        //btnGroup.add(rdoKmh);

        //btnGroup.add(rdoMph);
        //rightPanel.add(rdoKmh);
        //rightPanel.add(rdoMph);




        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        //add(rightPanel, BorderLayout.EAST);



    }//meetodi lõpp

    public JButton getBtnAvaFail() {
        return btnAvaFail;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

}//Klassi lõpp
