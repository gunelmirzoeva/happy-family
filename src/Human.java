import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;//date of birth
    private int iq; // 50 to 200 will be more accurate
    private Family family;
    private String[][] schedule;
//    static {
//        System.out.println("Loading class Human...");
//    }
//
//    {
//        System.out.println("Creating a new human object");
//    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;

    }

    public Human(String name, String surname, int year, int iq, Family family, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.family = family;
        this.schedule = schedule;
    }

    public Human(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getIq() {
        return iq;
    }
    public void setIq(int iq) {
        if (iq < 50) {
            this.iq = 50;
        } else if (iq > 200) {
            this.iq = 200;
        } else {
            this.iq = iq;
        }
    }
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    public String[][] getSchedule() {
        return schedule;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greetPet(Pet pet) {
        System.out.printf("Hello %s\n", pet.getNickname());
    }

    public void describePet(Pet pet) {
        String slyLevel = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old, he/she is %s", pet.getNickname(), pet.getAge(), slyLevel);
    }

    public boolean feedPet(boolean isTimeForFeeding, Pet pet) {
        if(isTimeForFeeding) {
            System.out.println("Hm... I will feed " + getName() + "'s " + pet.getSpecies());
            return true;
        } else {
            Random random = new Random();
            int randomNum = random.nextInt(101);
            if(pet.getTrickLevel() > randomNum) {
                System.out.println("Hm... I will feed " + getName() + "'s " + pet.getSpecies());
                return true;
            } else {
                System.out.println("I think " + getName() + "'s " + pet.getSpecies() + " is not hungry.");
                return false;
            }
        }
    }
    @Override
    public String toString() {
        return String.format("\n----------------------\nname = %s\nsurname = %s\nyear = %d\niq = %d\nschedule = %s\n" ,
                getName(), getSurname(), getYear(), getIq(), Arrays.deepToString(getSchedule()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq);
    }

}
