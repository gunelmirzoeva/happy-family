import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, int year, int iq, Family family, Map<String, String> schedule) {
        super(name, surname, year, iq, family, schedule);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hi sweetie, %s\n", pet.getNickname());
    }

    public void applyMakeup() {
        System.out.println("Applying makeup...");
    }
}
