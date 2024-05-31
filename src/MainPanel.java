import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JButton btnOpen, btnShow;
    private JComboBox<String> cmbYears;
    private JLabel lblFilename;
    private JTextArea txtArea;
    private GridBagConstraints gbc = new GridBagConstraints();

    public MainPanel() {
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 25; // Laius kõigil lahtritel
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Täida kogu lahter

        firstLine();
        secondLine();
        thirdLine();
    }

    private void firstLine() {
        btnOpen = new JButton("Ava fail");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnOpen, gbc);

        cmbYears = new JComboBox<>(new String[] {"Vali aasta"});
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cmbYears, gbc);

        btnShow = new JButton("Näita tulemusi");
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(btnShow, gbc);
    }
    private void secondLine() {
        lblFilename = new JLabel("Siia tuleb failinimi");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(lblFilename, gbc);
    }
    private void thirdLine() {
        txtArea = new JTextArea(15, 25);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        // gbc.gridwidth = 3; // Siin on sama mis varem muudetud 3
        add(scrollPane, gbc);
    }

    public JButton getBtnOpen() {
        return btnOpen;
    }

    public JButton getBtnShow() {
        return btnShow;
    }

    public JComboBox<String> getCmbYears() {
        return cmbYears;
    }

    public JLabel getLblFilename() {
        return lblFilename;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }
}
