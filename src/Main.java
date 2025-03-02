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

        boolean deletedByIndex = myFamily.deleteChild(0);
        System.out.println("Deletion by index 0 successful: " + deletedByIndex);
        System.out.println("After deletion by index 0: " + Arrays.toString(myFamily.getChildren()));
        System.out.println();

        boolean deletedByInvalidIndex = myFamily.deleteChild(5);
        System.out.println("Deletion by invalid index 5 successful: " + deletedByInvalidIndex);
        System.out.println("After deletion by invalid index 5: " + Arrays.toString(myFamily.getChildren()));

        Human child3 = new Human("Charlie", "Smith", 2010);
        myFamily.addChild(child3);
        System.out.println("After adding Charlie again: " + Arrays.toString(myFamily.getChildren()));


        System.out.println("Total family members: " + myFamily.countFamily());

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println("Today is: " + day.name());
        }
        System.out.println();
        //Pet dog1 = new Pet(Species.DOG, "Buddy", 2, 54, new String[]{"can run"});

       // System.out.println(dog1);
    }
}