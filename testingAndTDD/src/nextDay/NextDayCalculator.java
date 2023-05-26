package nextDay;

import java.time.LocalDate;
public class NextDayCalculator {
    public static LocalDate getNextDay(LocalDate currentDay){
        return currentDay.plusDays(1);
    }
}