import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ButtonShowListener implements ActionListener {

        private Model model;
        private View view;

    public  ButtonShowListener(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Show");
        int year = Integer.parseInt(view.getCmbYears().getSelectedItem().toString());
        List<LocalDate> dates = new ArrayList<>();  // Kõik kuupäevad
        List<LocalTime> times = new ArrayList<>();  // Kõikkellajad
        List<Double> weights = new ArrayList<>();  // Kõik kaalud
        List<Double> muscles = new ArrayList<>();  // Kõik musklid
        List<Double> bmi = new ArrayList<>();  // Kõik bmi
        int errors = 0; // Vigade lugemiseks (vigane rida)
        for(FileContent file : model.getContents()) {
            if(file.getDate().getYear() == year) {  // Kas on õige aasta
                dates.add(file.getDate());
                times.add(file.getTime());
                weights.add(file.getWeight());
                muscles.add(file.getMuscle());
                bmi.add(file.getBmi());
                if(file.getBody() == 0.0) {
                    errors += 1;
                }
            }
        }
        // System.out.println(dates.size() + " " + errors); // TESTIKS

        LocalDate minDate = Collections.min(dates);  // Väikseim kuuüpäev
        LocalDate maxDate = Collections.max(dates);  // Suurim kuupäev
        LocalTime minTime = Collections.min(times);
        LocalTime maxTime = Collections.min(times);
        double minWeight = Collections.min(weights);
        double maxWeight = Collections.max(weights);
        double avgWeight = weights.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double musclesum = muscles.stream().mapToDouble(Double::doubleValue).sum();
        double avgBmi = bmi.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        Set<LocalDate> duplicates = model.findDuplicates(dates);
        List<LocalDate> ld = new ArrayList<>(duplicates);
        List<String> result = new ArrayList<>();

        for(LocalDate date : ld) {
            result.add(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        String duplicatesDate = String.join(", ",result);

        // System.out.println(minDate + " " + maxDate);  // TESTIKS
        // System.out.println(minTime + " " + maxTime);  // TESTIKS
        // System.out.println(minWeight + " " + maxWeight);  // TESTIKS
        // System.out.println(avgWeight);  // TESTIKS
        // System.out.println(duplicatesDate);  // TESTIKS  // [2021.12.13]

        view.getTxtArea().setText(""); // Tühjendab tekstiast
        view.getTxtArea().append("01. " + minDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n");
        view.getTxtArea().append("02. " + maxDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n");
        view.getTxtArea().append("03. " + duplicatesDate + "\n");

        view.getTxtArea().append("04. " + minTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n");
        view.getTxtArea().append("05. " + maxTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n");

        view.getTxtArea().append("06. " + (dates.size() - errors) + "\n");
        view.getTxtArea().append("07. " + weights.size() + "\n");

        view.getTxtArea().append("08. " + minWeight + "\n");
        view.getTxtArea().append("09. " + maxWeight + "\n");


        view.getTxtArea().append("10. " + avgWeight + "\n");

        view.getTxtArea().append("11. " + String.format("%.3f", musclesum) + "\n");  // maksimum Bone
        view.getTxtArea().append("12. " + String.format("%.3f", avgBmi) + "\n");  // BMI keskmine

    }
}
