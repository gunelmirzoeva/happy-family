import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel; // from 1 to 100
    private Set<String> habits;

//    static {
//        System.out.println("Loading class Pet...");
//    }
//
//    {
//        System.out.println("Creating a new pet object");
//    }
    public Pet(String nickname) {
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){
        this.species = Species.UNKNOWN;
    }


    public Species getSpecies() {
        return species;
    }
    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public void setTrickLevel(int trickLevel) {
        if (trickLevel < 1) {
            this.trickLevel = 1;
        } else if (trickLevel > 100) {
            this.trickLevel = 100;
        } else {
            this.trickLevel = trickLevel;
        }
    }
    public Set<String> getHabits() {
        return habits;
    }
    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating");
    }
    public abstract void respond();
    public void foul() {
        System.out.println("I need to cover it up");
    }
    @Override
    public String toString() {
        return String.format("%s\nnickname = %s\nage = %d\ntrick level = %d\nhabits = %s",
                getSpecies(), getNickname(), getAge(), getTrickLevel(), habits);
    }

}
