import java.util.Random;

public class Human {
    String name;
    String surname;
    int year;//date of birth
    int iq; // from 1 to 100
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human(){

    }

    public void greetPet() {
        System.out.printf("Hello %s\n", pet.nickname);
    }

    public void describePet() {
        String slyLevel = pet.trickLevel > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old, he/she is %s", pet.nickname, pet.age, slyLevel);
    }

    public boolean feedPet(boolean isTimeForFeeding) {
        if(isTimeForFeeding) {
            System.out.println("Hm... I will feed " + name + "'s " + pet.species);
            return true;
        } else {
            Random random = new Random();
            int randomNum = random.nextInt(101);
            if(pet.trickLevel > randomNum) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.species);
                return true;
            } else {
                System.out.println("I think " + name + "'s " + pet.species + " is not hungry.");
                return false;
            }
        }
    }
    @Override
    public String toString() {
        return String.format("Human\n{name = %s\nsurname = %s\nyear = %d\niq = %d\nmother = %s\nfather = %s}\n\n%s",
                name, surname, year, iq, mother, father, pet.toString());
    }

}
