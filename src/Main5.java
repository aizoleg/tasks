import java.util.ArrayList;

    public class Main5 {

        public static void addParen(ArrayList list, int leftRem, int rightRem, char[] str, int index) {
            if (leftRem < 0 || rightRem < leftRem) return; // Некорректное состояние

            if (leftRem == 0 && rightRem == 0) { /* Скобок не осталось */
                list.add(String.copyValueOf(str));
            } else {
                str[index] = '('; /* Добавить левую скобку, если они еще остались . */
                addParen(list, leftRem - 1, rightRem, str, index + 1);

                str[index] = ')'; /* Добавить правую скобку, если выражение корректно */
                addParen(list, leftRem, rightRem - 1, str, index + 1);
            }
        }

        public static ArrayList generateParens(int count) {
            char[] str = new char[count * 2];
            ArrayList list = new ArrayList();
            addParen(list, count, count, str, 0);
            return list;
        }

        public static void main(String[] args) {
            ArrayList list = generateParens(5);  // ввод
            for (Object s : list) {
                System.out.println(s);
            }
            System.out.println(list.size());
        }
    }
