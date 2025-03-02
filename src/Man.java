import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq, Family family, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, family, schedule);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hey buddy, %s\n", pet.getNickname());
    }

    public void repairCar() {
        System.out.println("Repairing the car...");
    }
}
