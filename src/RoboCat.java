import java.util.Set;

public class RoboCat extends Pet implements Foulable{
    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond(){
        System.out.println("Beep boop! My name is " + this.getNickname() + "! Ready to assist you, human!");
    }
    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }
}
