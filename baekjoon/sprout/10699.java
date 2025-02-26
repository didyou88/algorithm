// link: https://www.acmicpc.net/problem/10699

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(simpleDateFormat.format(date));
    }
}
