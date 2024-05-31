import java.time.LocalDate;
import java.time.LocalTime;

public class FileContent {
    private final LocalDate date;
    private final LocalTime time;
    private final double weight;
    private final double bmi;
    private final double body;
    private final double water;
    private final double muscle;
    private final double bone;

    public FileContent(LocalDate date, LocalTime time, double weight, double bmi, double body, double water, double muscle, double bone) {
        this.date = date;
        this.time = time;
        this.weight = weight;
        this.bmi = bmi;
        this.body = body;
        this.water = water;
        this.muscle = muscle;
        this.bone = bone;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }

    public double getBody() {
        return body;
    }

    public double getWater() {
        return water;
    }

    public double getMuscle() {
        return muscle;
    }

    public double getBone() {
        return bone;
    }
}
