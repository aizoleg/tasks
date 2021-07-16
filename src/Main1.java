import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum = reader.readLine();
        int num = Integer.parseInt(sNum);
        int fact = 1;
        for (int i = 1; i < num+1; i++){
            fact = fact * i;
        }
        System.out.println(fact);
    }
}
