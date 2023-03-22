import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
            "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";
    //Main статическое текстовое поле с содержимым из текста выше,
    //Заведите мапу

    public static Map<Character, Integer> map1 = new HashMap<>();


    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                char letter = Character.toUpperCase(text.charAt(i));

                //Он есть в мапе. Значит он нам уже встречался. Вынимаем текущее значение для ключа
                // (нашего символа), увеличиваем это число на 1 и вставляем обратно в мапу
                // Его нет в мапе. Значит, мы встретили его в первый раз и вставляем
                // в мапу пару где ключ это наш символ, а значение это 1 (тк встретили его всего один раз)
                if (map1.containsKey(letter)) {
                    map1.put(letter, count++);
                } else {
                    map1.put(letter, count);
                }

            }

            // в которой для каждого символа будете хранить количество раз,
            // которое вы его встретили. Изначально мапа пустая.
            // Character это ссылочный тип-обёртка для char, как Integer для int

        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        char l = 0;
        char s = 0;

        for (Map.Entry<Character, Integer> symbol : map1.entrySet()) {

            if (symbol.getValue() < min) {
                min = symbol.getValue();
                s = symbol.getKey();
            }
            if (symbol.getValue() > max) {
                max = symbol.getValue();
                l = symbol.getKey();
            }

        }

        System.out.println("Реже всего: " + min + " раз повторяется буква " + s);
        System.out.println("Реже всего: " + max + " раз повторяется буква " + l);
    }

}

