import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type of animal (dog, cat, or bird): ");
        String animalType = scanner.nextLine();
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.createAnimal(animalType);
        animal.speak();
        scanner.close();
    }
}