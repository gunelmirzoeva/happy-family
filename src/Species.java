public enum Species {
    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    ROBOCAT(false, 4, false),
    FISH(false, 0, false),
    UNKNOWN;

    private final Boolean canFly;
    private final Integer numberOfLegs;
    private final Boolean hasFur;

    Species(Boolean canFly, Integer numberOfLegs, Boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
    Species() {
        this.canFly = null;
        this.numberOfLegs = null;
        this.hasFur = null;
    }
    public Boolean canFly() {
        return canFly;
    }

    public Integer getNumberOfLegs() {
        return numberOfLegs;
    }
    public Boolean hasFur() {
        return hasFur;
    }

    @Override
    public String toString() {
        return String.format("%s\n{canFly=%b, numberOfLegs=%d, hasFur=%b}", name(), canFly, numberOfLegs, hasFur);

    }
}