package jjw34g.ire.entity;

public enum LakokTypeEntity {
    tartozik("tartozik"),
    ok("ok"),
    elkoltozott("elkoltozott");
    

    private final String label;

    LakokTypeEntity(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
