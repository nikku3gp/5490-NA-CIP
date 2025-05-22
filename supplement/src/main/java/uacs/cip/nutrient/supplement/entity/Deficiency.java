package uacs.cip.nutrient.supplement.entity;

import java.time.LocalDate;

public class Deficiency {
    private Long id;
    private String nutrientType;
    private double consumed;
    private double target;
    private double deficit;
    private LocalDate date;

    public Deficiency() {
    }

    public Deficiency(String nutrientType, double consumed, double target, double deficit, LocalDate date) {
        this.nutrientType = nutrientType;
        this.consumed = consumed;
        this.target = target;
        this.deficit = deficit;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNutrientType() {
        return nutrientType;
    }

    public void setNutrientType(String nutrientType) {
        this.nutrientType = nutrientType;
    }

    public double getConsumed() {
        return consumed;
    }

    public void setConsumed(double consumed) {
        this.consumed = consumed;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getDeficit() {
        return deficit;
    }

    public void setDeficit(double deficit) {
        this.deficit = deficit;
    }
}
