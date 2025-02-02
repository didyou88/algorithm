import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
    }
}
