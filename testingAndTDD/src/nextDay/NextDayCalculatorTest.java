package nextDay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;


public class NextDayCalculatorTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 01/01/18")
    public void findNextDay(){
//        LocalDate currentDay = LocalDate.now();
//        LocalDate expectedNextDay =currentDay.plusDays(1);
//        LocalDate actualNextDay = NextDayCalculator.getNextDay(currentDay);
//        assertEquals(expectedNextDay,actualNextDay);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        System.out.println(currentDay.format(formatter));

        String currentDayStr = "01/01/2018";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expectedNextDay = LocalDate.parse("02/01/2018",formatter);
        LocalDate actualNextDay = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expectedNextDay,actualNextDay);
    }
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 31/01/18")
    public void findNextDayOf310118(){
        String currentDayStr = "31/01/2018";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expected = LocalDate.parse("01/02/2018",formatter);
        LocalDate actual = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 30/04/18")
    public void findNextDayOf300418(){
        String currentDayStr = "30/04/2018";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expected = LocalDate.parse("01/05/2018",formatter);
        LocalDate actual = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 28/02/18")
    public void findNextDayOf280218(){
        String currentDayStr = "28/02/2018";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expected = LocalDate.parse("01/03/2018",formatter);
        LocalDate actual = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 29/02/20")
    public void findNextDayOf290220(){
        String currentDayStr = "29/02/2020";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expected = LocalDate.parse("01/03/2020",formatter);
        LocalDate actual = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Tìm ngày tiếp theo cho 31/12/18")
    public void findNextDayOf311218(){
        String currentDayStr = "31/12/2018";
        LocalDate currentDay = LocalDate.parse(currentDayStr, formatter);
        LocalDate expected = LocalDate.parse("01/01/2019",formatter);
        LocalDate actual = NextDayCalculator.getNextDay(currentDay);
        assertEquals(expected,actual);
    }
}

