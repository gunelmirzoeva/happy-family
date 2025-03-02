import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private long birthDate;//date of birth
    private int iq; // 50 to 200 will be more accurate
    private Family family;
    private Map<DayOfWeek, String> schedule;
//    static {
//        System.out.println("Loading class Human...");
//    }
//
//    {
//        System.out.println("Creating a new human object");
//    }
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        try {
            Date date = dateFormat.parse(birthDate);
            this.birthDate = date.getTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid birth date format. Use dd/MM/yyyy");
        }

    }

    public Human(String name, String surname, long birthDate, int iq, Family family, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
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
    public long getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }
    public int getIq() {
        return iq;
    }
    public void setIq(int iq) {
        this.iq = Math.min(200, Math.max(50, iq));
    }
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }
    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public String describeAge() {
        if(birthDate < 0) {
            return "Unknown age";
        }
        LocalDate birth = new Date(birthDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period period = Period.between(birth, today);

        return String.format("%d years, %d months, %d days", period.getYears(), period.getMonths(), period.getDays());
    }

    public void greetPet(Pet pet) {
        System.out.printf("Hello %s\n", pet.getNickname());
    }

    public void describePet(Pet pet) {
        String slyLevel = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s named %s , he/she is %d years old, he/she is %s\n", pet.getSpecies(), pet.getNickname(), pet.getAge(), slyLevel);
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
        String formattedDate = dateFormat.format(new Date(birthDate));
        return String.format("\n----------------------\nname = %s\nsurname = %s\nbirthday = %s\niq = %d\nschedule = %s\n",
                getName(), getSurname(), formattedDate, getIq(), schedule);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq);
    }

}
