
public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.species = "Dog";
        pet.nickname = "Buddy";
        pet.age = 5;
        pet.trickLevel = 8;
        pet.habits = new String[]{"barking", "playing fetch"};

        Human human = new Human();
        human.name = "John";
        human.surname = "Doe";
        human.year = 1990;
        human.iq = 120;
        human.pet = pet;

        System.out.println(human);

        boolean result = human.feedPet(true);


        result = human.feedPet(false);
    }
}