public class Fish extends Pet implements Foulable{
    public Fish(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Blub blub! My name is " + this.getNickname() + "!");
    }
}
