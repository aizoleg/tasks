import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main8 {public static void main(String[] args) {
    String s = "Сегодня холодный зимний зимний день день";
    // разделение на слова
    StringTokenizer st = new StringTokenizer(s, " ");
    List<String> list = new LinkedList<>();
    // перебор слов
    while (st.hasMoreTokens()) {
        String buf = st.nextToken();
        // если список не содержит слова, добавим его в конец
        if (!list.contains(buf))
            list.add(buf);
    }
        // вывод
        for (String i : list) System.err.print(i + " ");

    }
}
