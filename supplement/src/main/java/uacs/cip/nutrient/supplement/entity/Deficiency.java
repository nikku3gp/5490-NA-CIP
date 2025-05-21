package uacs.cip.nutrient.supplement.entity;

import jakarta.persistence.Entity;
@Entity
public class Deficiency {
    private String nutrientType;
    private double consumed;
    private double target;
    private double deficit;

    public Deficiency() {
    }

    public Deficiency(String nutrientType, double consumed, double target, double deficit) {
        this.nutrientType = nutrientType;
        this.consumed = consumed;
        this.target = target;
        this.deficit = deficit;
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
