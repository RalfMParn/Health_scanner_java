import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private String filename;
    private List<FileContent> contents;//faili sisu
    private List<Integer> years; //Unikaalsed aastad


    public Model() {
        filename = ""; //Mudeli loomisel on failinimi tühi/puudu
        contents = new ArrayList<>();
    }

    public void readFileContents() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int first = 0;
            boolean right = false;
            contents.clear();
            while ((line = br.readLine()) != null) {
                //Käime faili rea kaupa
                String[] parts = line.replace("\"", "").split(";");
                if(first == 0) {//kas on esimene rida
                    if(parts[0].equals("User details")) {//kas on User details
                        right = true;
                }
            }
                if(right && first >= 11) {
                    //teisenduse Õigesse tüüpi (LocalDate, LocalTime, double)
                    LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                    LocalTime time = LocalTime.parse(parts[1], timeFormatter);
                    double weight = Double.parseDouble(parts[2]);
                    double bmi = Double.parseDouble(parts[3]);
                    double body = Double.parseDouble(parts[4]);
                    double water = Double.parseDouble(parts[5]);
                    double muscle = Double.parseDouble(parts[6]);
                    double bone = Double.parseDouble(parts[7]);
                    // Lisa rea osad listi
                    contents.add(new FileContent(date, time, weight, bmi, body, water, muscle, bone));
                }
                first++;//Suurenda rea loendit
            }
           // System.out.println(contents.size());//Testiks

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException( e);
        }
    }

    public void uniqueYears() {
        if(!contents.isEmpty()) {  // Kui list ei ole tühi
            Set<Integer> set = new HashSet<>();  // Unikaalsed aastad
            for(FileContent file: contents) {
                set.add(file.getDate().getYear());  // Fail objektist võetakse kuupäevast aasta
            }
            // Set list teha List-iks
            List<Integer> uniqueYears = new ArrayList<>(set);
            // Seadista mudelise aastad (Comboboxi jaoks)
            setYears(uniqueYears);  // years = uniqueYears
        }
    }

    public Set<LocalDate> findDuplicates(List<LocalDate> dates) {
        Set<LocalDate> setToReturn = new HashSet<>();
        Set<LocalDate> set = new HashSet<>();

        for(LocalDate localDate : dates) {
            if(!set.add(localDate)) {
                setToReturn.add(localDate);  // need on topelt kuupäevad
            }
        }
        return setToReturn;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<FileContent> getContents() {
        return contents;
    }
}
