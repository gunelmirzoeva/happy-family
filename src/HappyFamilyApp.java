public class HappyFamilyApp {
    public static void main(String[] args) {
        Family myFamily = new Family(new Human("Alice", "Smith", 1980), new Human("Bob", "Smith", 1978));

        Human child1 = new Human("Charlie", "Smith", 2010);
        Human child2 = new Human("David", "Smith", 2012);

        myFamily.addChild(child1);
        myFamily.addChild(child2);


        System.out.println("Before deletion: " + myFamily.getChildren());

        boolean deleted = myFamily.deleteChild(new Human("Charlie", "Smith", 2010));

        System.out.println("Deletion successful: " + deleted);
        System.out.println("After deletion: " + myFamily.getChildren());

        boolean deletedByIndex = myFamily.deleteChild(0);
        System.out.println("Deletion by index 0 successful: " + deletedByIndex);
        System.out.println("After deletion by index 0: " + myFamily.getChildren());
        System.out.println();

        boolean deletedByInvalidIndex = myFamily.deleteChild(5);
        System.out.println("Deletion by invalid index 5 successful: " + deletedByInvalidIndex);
        System.out.println("After deletion by invalid index 5: " + myFamily.getChildren());

        Human child3 = new Human("Charlie", "Smith", 2010);
        myFamily.addChild(child3);
        System.out.println("After adding Charlie again: " + myFamily.getChildren());


        System.out.println("Total family members: " + myFamily.countFamily());

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println("Today is: " + day.name());
        }
        System.out.println();
        //Pet dog1 = new Pet(Species.DOG, "Buddy", 2, 54, new String[]{"can run"});

       // System.out.println(dog1);
        System.out.println("DAO operations");
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(familyService);

        Human father = new Human("John", "Smith", 1980);
        Human mother = new Human("Jane", "Smith", 1982);
        controller.createNewFamily(father, mother);

        controller.displayAllFamilies();

        Human adoptedChild = new Human("Emily", "Smith", 2015);
        controller.adoptChild(controller.getFamilyById(0), adoptedChild);

        controller.displayAllFamilies();

        Human father2 = new Human("John", "Smith", 315532L, 120, null, null);
        System.out.println(father.describeAge());
        System.out.println(father2);

        Human adoptedChild2 = new Human("Emily", "Smith", "20/03/2016", 95);
        System.out.println(adoptedChild.describeAge());

        System.out.println(adoptedChild2);
    }
}