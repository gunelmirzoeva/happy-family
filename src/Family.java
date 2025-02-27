import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

//    static {
//        System.out.println("Loading class Family...");
//    }
//
//    {
//        System.out.println("Creating a new family object");
//    }
    public Family(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("A family must have two parents.");
        }
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void addChild(Human child) {
        if (child == null) {
            throw new IllegalArgumentException("Child cannot be null.");
        }
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[newChildren.length - 1] = child;
        this.children = newChildren;
        child.setFamily(this);
    }
    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            return false;
        }
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children[index].setFamily(null);
        children = newChildren;
        return true;
    }
    public boolean deleteChild(Human child) {
        if (child == null || children.length == 0) {
            return false;
        }
        int indexToRemove = -1;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove == -1) {
            return false;
        }
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != indexToRemove) {
                newChildren[j++] = children[i];
            }
        }

        children[indexToRemove].setFamily(null);
        children = newChildren;
        return true;
    }
    public int countFamily() {
        return 2 + children.length;
    }

    @Override
    public String toString() {
        return String.format("Family\nmother = %s\nfather = %s\nchildren = %s\npet = %s",
                getMother(), getFather(), Arrays.toString(getChildren()), getPet());
    }
}
