import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }
    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }
    public void displayAllFamilies() {
        getAllFamilies().forEach(family -> System.out.println(family.prettyFormat()));
    }
    public List<Family> getFamiliesBiggerThan(int size) {
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() > size)
                .collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThan(int size) {
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() < size)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int number) {
        return (int) getAllFamilies().stream()
                .filter(family-> family.countFamily() == number)
                .count();
    }

    public void createNewFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculine, String feminine) {
        String gender = Math.random() < 0.5 ? "male" : "female";
        String childName = gender.equals("male")? masculine: feminine;
        Human child = new Human(childName, family.getFather().getSurname(), 2025);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : getAllFamilies()) {
            family.getChildren().removeIf(child -> (2025 - child.getBirthDate()) > age);
            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        Family family = getFamilyById(index);
        return (family != null) ? family.getPets() : null;
    }

    public void addPet(int index, Pet pet) {
        Family family = getFamilyById(index);
        if(family != null) {
            family.getPets().add(pet);
            familyDao.saveFamily(family);
        }
    }
}
