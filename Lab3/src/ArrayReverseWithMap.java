//V5

import java.util.*;

public class ArrayReverseWithMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Введення розміру масиву
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        // 2. Введення елементів масиву
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // 3. Реверс масиву
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = arr[size - 1 - i];
        }

        // 4. Вивід реверсованого масиву
        System.out.println("Reversed array: " + Arrays.toString(reversed));

        // 5. Створення HashMap з реверсованого масиву (index -> value)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < reversed.length; i++) {
            map.put(i, reversed[i]);
        }

        // 6. Операції з HashMap
        // a) Додати пару ключ-значення
        map.put(99, 999);
        System.out.println("Added (99, 999)");

        // b) Видалити пару
        map.remove(0);
        System.out.println("Removed key 0");

        // c) Перевірити наявність ключа
        int keyToCheck = 2;
        System.out.println("Contains key " + keyToCheck + "? " + map.containsKey(keyToCheck));

        // d) Знайти значення за ключем
        if (map.containsKey(keyToCheck)) {
            System.out.println("Value at key " + keyToCheck + ": " + map.get(keyToCheck));
        }

        // e) Вивести всі ключі та значення
        System.out.println("All key-value pairs:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " -> Value: " + entry.getValue());
        }

        // 7. Приклад ArrayIndexOutOfBoundsException
        try {
            System.out.println("Trying to access invalid index...");
            int invalid = arr[size]; // це викличе помилку
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: You tried to access index " + size +
                    ", but valid indices are 0 to " + (size - 1));
        }

        scanner.close();
    }
}
