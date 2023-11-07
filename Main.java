public class Main {
    public static void main(String[] args) {
        ToyStorage toyStorage = new ToyStorage();
    
        // Создание массива игрушек
        Toy[] toysArray = {
            new Toy(1, "Car", 10, 20),
            new Toy(2, "Robot", 5, 30),
            new Toy(3, "Doll", 15, 25),
            new Toy(4, "Teddy bear", 20, 15),
            new Toy(5, "Puzzle", 12, 25),
            new Toy(6, "Train", 8, 30),
            new Toy(7, "Board Game", 5, 40),
            new Toy(8, "Lego Blocks", 18, 22),
            new Toy(9, "Doll's house", 3, 30),
            new Toy(10, "Rocket", 2, 15),
            new Toy(11, "Clockwork toys", 4, 30),
            new Toy(12, "Scooter", 6, 10),
            new Toy(13, "Roller Skates", 7, 30),
            new Toy(14, "Musical Instrument", 9, 20),
            new Toy(15, "Remote Control Car", 11, 30),
            new Toy(16, "Plane", 14, 20),
            new Toy(17, "Spinning top", 16, 10),
            new Toy(18, "Frisbee", 13, 12),
            new Toy(19, "Bouncy Ball", 17, 15),
            new Toy(20, "Water Gun", 7, 40)
        };
    
        // Добавляем игрушки в хранилище
        for (Toy toy : toysArray) {
            toyStorage.addToy(toy);
        }
    
        // Создаем объект ToyRaffle, передавая список игрушек из хранилища
        ToysLotery toysLotery = new ToysLotery(toyStorage.getToys());
    
        // Выбираем случайную игрушку
        for (int i = 0; i < 10; i++) {
            Toy randomToy = toysLotery.getRandomToy();
            if (randomToy != null && randomToy.getQuantity() > 0) {
                System.out.println("Выиграна игрушка: " + randomToy.getName());
                randomToy.setQuantity(randomToy.getQuantity() - 1);
                // если количество игрушек равно 0, удаляем игрушку из хранилища
                if (randomToy.getQuantity() == 0) {
                    toyStorage.removeToy(randomToy);
                }
                // и записываем её id и название в файл
                FileOutput.writeToFile("winToys.txt", "id: " + randomToy.getId() + " toy: " + randomToy.getName());
            } else {
                System.out.println("Игрушка не найдена или закончилась");
            }
        }
    }        
}
