package uacs.cip.nutrient.supplement.entity;

import java.time.LocalDate;

public class NutrientSummary {
    private String nutrientType;
    private double totalConsumed;
    private double target;
    private boolean met;
    private LocalDate date;

    public NutrientSummary() {
    }

    public NutrientSummary(String nutrientType, double totalConsumed, double target, boolean met, LocalDate date) {
        this.nutrientType = nutrientType;
        this.totalConsumed = totalConsumed;
        this.target = target;
        this.met = met;
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

    public double getTotalConsumed() {
        return totalConsumed;
    }

    public void setTotalConsumed(double totalConsumed) {
        this.totalConsumed = totalConsumed;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public boolean isMet() {
        return met;
    }

    public void setMet(boolean met) {
        this.met = met;
    }
}
