import java.util.*;

public class Family implements HumanCreator{
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

//    static {
//        System.out.println("Loading class Family...");
//    }
//
//    {
//        System.out.println("Creating a new family object");
//    }
    private static final String[] NAMES = {"Alex", "Chris", "Taylor", "Jordan", "Morgan", "Pat", "Sam", "Casey", "Riley", "Cameron"};

    public Family(Human father, Human mother) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("A family must have two parents.");
        }
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }
    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    @Override
    public Human bornChild(){
        Random random = new Random();
        boolean isFemale = random.nextBoolean();
        String surname = father.getSurname();
        String name = NAMES[random.nextInt(NAMES.length)];
        int iq = (mother.getIq() + father.getIq()) / 2;
        Human child;

        if (isFemale) {
            child = new Woman(name, surname, random.nextInt(20), iq, this, null);
        } else {
            child = new Man(name, surname, random.nextInt(20), iq, this, null);
        }
        children.add(child);
        return child;
    }
    public void addChild(Human child) {
        if (child == null) {
            throw new IllegalArgumentException("Child cannot be null.");
        }
        children.add(child);
        child.setFamily(this);
    }
    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }
        children.get(index).setFamily(null);
        children.remove(index);
        return true;
    }
    public boolean deleteChild(Human child) {
        if (child == null || children.isEmpty()) {
            return false;
        }
        boolean removed = children.remove(child);
        if(removed) {
            child.setFamily(null);
        }
        return removed;
    }
    public int countFamily() {
        return 2 + children.size();
    }

    @Override
    public String toString() {
        return String.format("Family\nfather = %s\nmother = %s\nchildren = %s\npet = %s",
                getFather(), getMother(), getChildren(), getPets());
    }
}
