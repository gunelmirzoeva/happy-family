import java.util.Set;

public class DomesticCat extends Pet implements Foulable{
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOMESTICCAT);
    }

    @Override
    public void respond(){
        System.out.println("Meow! My name is " + this.getNickname() + "!");
    }
    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }
}
