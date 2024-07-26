import java.util.Arrays;

public class HareAndCarrots {

    public static void main(String[] args) {
        int[] carrotBeds = {1, 2, 3, 4, 5}; // Вес моркови на каждой грядке
        int maxCarryingCapacity = 5; // Максимальная грузоподъемность зайца
        int numberOfWalkers = 10; // Количество ходок

        int totalCarrots = collectCarrots(carrotBeds, maxCarryingCapacity, numberOfWalkers);

        System.out.println("Заяц унес " + totalCarrots + " кг моркови.");
    }

    // Метод для сбора моркови
    public static int collectCarrots(int[] carrotBeds, int maxCarryingCapacity, int numberOfWalkers) {
        int totalCarrots = 0; // Общее количество собранной моркови
        for (int i = 0; i < numberOfWalkers; i++) {
            totalCarrots += collectCarrotsOnTrip(carrotBeds, maxCarryingCapacity);
        }
        return totalCarrots;
    }

    // Метод для сбора моркови за одну ходку
    public static int collectCarrotsOnTrip(int[] carrotBeds, int maxCarryingCapacity) {
        int remainingCapacity = maxCarryingCapacity; // Оставшееся место на текущую ходку
        int collectedCarrots = 0; // Собранная морковь за эту ходку

        // Сортировка массива по убыванию веса моркови
        Arrays.sort(carrotBeds);
        for (int i = carrotBeds.length - 1; i >= 0; i--) {
            // Если заяц сможет унести всю морковку с этого участка
            if (remainingCapacity >= carrotBeds[i]) {
                collectedCarrots += carrotBeds[i];
                remainingCapacity -= carrotBeds[i];
                carrotBeds[i] = 0; // Удалить морковь с грядки
            } else {
                // Если заяц не может унести всю морковь, он забирает столько, сколько может
                collectedCarrots += remainingCapacity;
                carrotBeds[i] -= remainingCapacity;
                remainingCapacity = 0;
            }
            if (remainingCapacity == 0) {
                break; // Если у зайца закончилось место, прекращаем сбор в этой ходке
            }
        }
        return collectedCarrots;
    }
}
