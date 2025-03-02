import java.util.Set;

public class Dog extends Pet implements Foulable{
    public Dog(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }
    @Override
    public void respond() {
        System.out.println("Woof! My name is " + this.getNickname() + "!");
    }
    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }
}
