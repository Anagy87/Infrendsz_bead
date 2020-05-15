package jjw34g.ire.entity;

public enum LakokStatusEntity {
    fizetetlen("fizetetlen‘"),
    fizetett("fizetett"),
    elkoltozott("elkoltozott");

    private final String label;

    LakokStatusEntity(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
