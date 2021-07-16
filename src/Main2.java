import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;


public class Main2 {
    public static void main(String[] args) throws IOException {
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:\\Users\\Aiz\\Desktop\\text.txt"), StandardCharsets.UTF_8))) {

            while ((line = br.readLine()) != null) {
                String[] splitWords = line.split(" ");                 // считывая "слова", разделенные пробелом, помещаем их в массив

                for (int i = 0; i < splitWords.length; i++) {                // для каждого "слова"
                    StringBuilder clear_word = new StringBuilder();          // переменная для чистых слов
                    for (int j = 0; j < splitWords[i].length(); j++) {       // читаем посимвольно слово
                        if (Character.isLetter(splitWords[i].charAt(j)))     // избавляемся от знаков
                            clear_word.append(splitWords[i].charAt(j));
                    }
                    splitWords[i] = clear_word.toString();                   // преобразуем StringBuilder в String
                    splitWords[i] = splitWords[i].toLowerCase();             // избавляемся от верхнего регистра
                }

                Map<String, Integer> result = new HashMap<>();               //используем map для подсчета вхождений
                for(String s : splitWords){
                    if(result.containsKey(s)){
                        result.put(s, result.get(s)+1);                      // если map содержит ключ, увеличиваем счетчик слова
                    }
                    else {
                        result.put(s, 1);                                    // или создаём новый счётчик с 1
                    }
                }

                result.entrySet().stream()
                        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())) // сортируем по популярности
                        .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
            }
        }
    }
}
