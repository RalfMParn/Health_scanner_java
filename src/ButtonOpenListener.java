import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonOpenListener implements ActionListener {
    private Model model;
    private View view;


    public ButtonOpenListener(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Open");
        FileNameExtensionFilter ff = new FileNameExtensionFilter("CSV Files", "csv");
        JFileChooser fc = new JFileChooser();//Open dialogi aken
        fc.addChoosableFileFilter(ff);//Filtri lisamine dialogi aknale
        fc.setFileFilter(ff);//Vaikimisi valik
        //Dialoogi aken näitab jooksva projekti kausta
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fc.showOpenDialog(view); //view vs null
        if (result == JFileChooser.APPROVE_OPTION) {
            if(fc.getSelectedFile().toString().toLowerCase().endsWith("csv")) {
                model.setFilename(fc.getSelectedFile().toString());
                //System.out.println(fc.getSelectedFile().toString());
                File f = new File(model.getFilename());
                view.getLblFilename().setText(f.getName());

                model.readFileContents();//Läheb ja loeb faili sisu massiivi (List)
                model.uniqueYears(); // seadista mudelise unikaalsed aastad

                // Comboboxi sisu muutmine
                view.getCmbYears().removeAllItems();  // Eemalda kõik rippmenüüst
                view.getCmbYears().addItem("Vali aasta");
                for(int year : model.getYears()) {
                    view.getCmbYears().addItem(Integer.toString(year));
                }
                view.repaint();  // vajalik kui visuaal jääb katki
                view.revalidate();
            }
        }

    }
}
