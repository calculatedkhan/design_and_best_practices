public class AnimalFactory {
    public Animal createAnimal(String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            default:
                throw new IllegalArgumentException("Invalid animal type: " + animalType);
        }
    }
}
