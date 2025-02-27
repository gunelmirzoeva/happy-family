import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Family myFamily = new Family(new Human("Alice", "Smith", 1980), new Human("Bob", "Smith", 1978));

        Human child1 = new Human("Charlie", "Smith", 2010);
        Human child2 = new Human("David", "Smith", 2012);

        myFamily.addChild(child1);
        myFamily.addChild(child2);

        System.out.println("Before deletion: " + Arrays.toString(myFamily.getChildren()));

        boolean deleted = myFamily.deleteChild(new Human("Charlie", "Smith", 2010));

        System.out.println("Deletion successful: " + deleted);
        System.out.println("After deletion: " + Arrays.toString(myFamily.getChildren()));

    }
}