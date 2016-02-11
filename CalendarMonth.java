import java.time.*;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

public class CalendarMonth {
    // Создан объект представляющий текущую дату.
    private LocalDate date;
    //Период 1 день
    private final Period period = Period.of(0,0,1);

    private int todayDayOfMonth;
    private DayOfWeek dayOfWeek;
    private DayOfWeek firstDayOfWeek;
    private Month month;


    public CalendarMonth() {
        date = LocalDate.now();
        todayDayOfMonth = date.getDayOfMonth();
        dayOfWeek = date.getDayOfWeek();
        firstDayOfWeek = date.with(DayOfWeek.MONDAY).getDayOfWeek();
        month = date.getMonth();
    }


    // Определить необходимый отступ для первой строки
    public void findSpaceFirstLine(){
        date = date.with(firstDayOfMonth());
        while (dayOfWeek.getValue()!= getFirstDayOfWeek().getValue()){
            date = getDate().plus(period);
            dayOfWeek = getDate().getDayOfWeek();
        }
    }


    //         Напечатать названия дней недели.
    public void printDaysOfWeek(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
        do {
            System.out.printf("%4s", formatter.format(getDayOfWeek()));
            date = getDate().plus(period);
            dayOfWeek = getDate().getDayOfWeek();
        }while (getDayOfWeek().getValue()!= getFirstDayOfWeek().getValue());
        System.out.println();
    }


    //         Напечатать даты месяца.
    public void printAllDaysOfMonth(){
        // отступ в первой строке дат
        for (int i = 2; i <= date.with(firstDayOfMonth()).getDayOfWeek().getValue(); i++){
            System.out.printf("%4s", " ");
        }

        setDate(getDate().with(firstDayOfMonth()));

        do {
            int day = date.getDayOfMonth();
            System.out.printf("%3d",day);

            if (day == getTodayDayOfMonth()){
                System.out.print("*");
            }else System.out.print(" ");

            date = getDate().plus(period);
            dayOfWeek = getDate().getDayOfWeek();

            if (getDayOfWeek().getValue() == getFirstDayOfWeek().getValue()){
                System.out.println();
            }
        }while (getMonth().getValue() == getDate().getMonth().getValue());
    }

    //         Напечатать календарь
    public void printAllCalendar(){
        findSpaceFirstLine();
        printDaysOfWeek();
        printAllDaysOfMonth();
    }


    //getter and setter
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(DayOfWeek firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getTodayDayOfMonth() {
        return todayDayOfMonth;
    }

    public void setTodayDayOfMonth(int todayDayOfMonth) {
        this.todayDayOfMonth = todayDayOfMonth;
    }

}
