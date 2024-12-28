
/*
В рамках выполнения задачи необходимо:
1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
2. Найдите человека с самым маленьким номером телефона
3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // N1.
        Map<String, String> phones = getPhones();
        System.out.println(phones);

        // N2.
        String nameMinPhone = getNameThenMinPhone(phones);
        System.out.println(nameMinPhone);

        // N3.
        String largeNamePhone = getLarge(phones);
        System.out.println(largeNamePhone);
    }

    // N3.
    private static String getLarge(Map<String, String> phones) {
        return phones.entrySet().stream().max(((o1, o2) -> o1.getValue().compareTo(o2.getValue()))).get().getKey();
    }

    // N2.
    private static String getNameThenMinPhone(Map<String, String> phones) {

        // получение минимального ключа
//        return phones.keySet().stream().min(Comparator.comparing(Integer::parseInt)).get();

        // получение значения по минимальному ключу
//        return phones.get(phones.keySet().stream().min(Comparator.comparing(Integer::parseInt)).get());

        // Адекватный вариант получения самого маленького ном. тел.
        return phones.entrySet().stream().min((o1, o2) -> Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey())).get().getValue();

    }

    // N1.
    private static Map<String, String> getPhones() {
        Map<String, String> phones = new HashMap<>();
        phones.put("123", "Иван");
        phones.put("321", "Мария");
        phones.put("456", "Сергей");
        phones.put("654", "Нина");
        phones.put("789", "Леонид");
        phones.put("916", "Яков");
        return phones;
    }
}