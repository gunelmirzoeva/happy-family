import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel; // from 1 to 100
    String[] habits;

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){
        
    }

    public void eat() {
        System.out.println("I'm eating");
    }
    public void respond() {
        System.out.printf("Hello owner. I'm %s. I miss you!\n", nickname);
    }
    public void foul() {
        System.out.println("I need to cover it up");
    }
    @Override
    public String toString() {
        return String.format("%s\n{nickname = %s\nage = %d\ntrick level = %d\nhabits = %s}",
                species, nickname, age, trickLevel, Arrays.toString(habits));
    }

}
