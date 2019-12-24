import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {

    public static void main(String[] args) {
        show();
    }

    public static void show() {
        LocalDate date = LocalDate.now(); //获取当前时间对象
        int month = date.getMonthValue(); //获取当前月
        int today = date.getDayOfMonth(); // 获取当前日
        date = date.minusDays(today - 1); //给当前月第一天赋值
        DayOfWeek dayOfWeek = date.getDayOfWeek(); //获取第一天的星期
        int value = dayOfWeek.getValue(); //获取当天对应的星期数值1-7
        System.out.println(" 一 二 三 四  五 六 日");
        //控制第一天位置
        for (int i = 1; i < value; i++) { System.out.print("   "); }
        //输出剩余日期
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            date = date.plusDays(1);  //每次加一天
            if (date.getDayOfWeek().getValue() == 1) {  //星期一，另起一行
                System.out.println();
            }
        }
    }

}
