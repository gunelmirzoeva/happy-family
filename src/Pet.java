import java.util.Arrays;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel; // from 1 to 100
    private String[] habits;

//    static {
//        System.out.println("Loading class Pet...");
//    }
//
//    {
//        System.out.println("Creating a new pet object");
//    }
    public Pet(Species species, String nickname) {
        this.nickname = nickname;
    }
    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){
        
    }


    public Species getSpecies() {
        return species;
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
    public String[] getHabits() {
        return habits;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating");
    }
    public void respond() {
        System.out.printf("Hello owner. I'm %s. I miss you!\n", getNickname());
    }
    public void foul() {
        System.out.println("I need to cover it up");
    }
    @Override
    public String toString() {
        return String.format("%s\nnickname = %s\nage = %d\ntrick level = %d\nhabits = %s",
                getSpecies(), getNickname(), getAge(), getTrickLevel(), Arrays.toString(getHabits()));
    }

}
