

import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
            Float f=new Float(72.0);
        System.out.println(f.intValue());
        String s="{'code':'Success','data':{'items':[{'id':'shout_caddie','name':'Snowflake','created_at':'2020-03-10T20:56:41.757287Z'}],'next_cursor':'eyJza2lwIjoxfQ'}}";
       // final Map<String, Object> fivetranApiResponse = JacksonFactory.mapper().readerFor(HashMap.class).readValue(s);
       // System.out.println(fivetranApiResponse.get("data"));

       /* Subscription newPlan = new Subscription(1, 1, 4);

        User[] userSignedUp = {
                new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
                new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1),
                new User(3, "Employee #3", LocalDate.of(2019, 01, 10), null, 1),
        };
        User[] constantUsers = {
                new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
                new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1)
        };
        LocalDate d1=LocalDate.parse("2019-01-31");
        LocalDate d2=LocalDate.parse("2018-11-04");
              Period period = Period.between(d2, d1);
              System.out.println(period);


        System.out.println( Challenge.billFor("2019-01", newPlan, userSignedUp));*/

    }
    private static int totalDays(String date){
        String[] ymd = date.split("-");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        return daysInMonth;
    }

}
class Subscription {
    public Subscription() {}
    public Subscription(int id, int customerId, int monthlyPriceInDollars) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInDollars;
}

class User {
    public User() {}
    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        // your code here!
        List<Double>bill=new ArrayList<Double>();
        YearMonth yearMonth=YearMonth.parse(month);
        String[] ymd = month.split("-");
        int monthData = Integer.parseInt(ymd[1]);
        int totalDay=totalDaysOfMonth(month);
        LocalDate presetMonth=LocalDate.parse(month+"-01");
        for(User user:users) {
            Period period= Period.between(
                    user.activatedOn,presetMonth);
            if (period.getDays()>0) {
                int cal = 0;
                if (user.deactivatedOn != null && user.deactivatedOn.getMonth().getValue() < yearMonth.getMonthValue()) {
                    cal = user.deactivatedOn.getDayOfMonth() - user.activatedOn.getDayOfMonth();
                } else if (user.deactivatedOn == null || user.deactivatedOn.getMonth().getValue() > yearMonth.getMonthValue()) {
                    cal=totalDays(period);
                    System.out.println(cal);
                }
                double totalbill =cal * (activeSubscription.monthlyPriceInDollars / Float.valueOf(totalDay));
                bill.add(totalbill);

            }
        }
        if(!bill.isEmpty()){
            double result= bill.stream().collect(Collectors.summingDouble(Double::doubleValue));
            DecimalFormat df = new DecimalFormat("0.00");
            return Double.valueOf( df.format(result))  ;
        }
        return -1;
    }

    private static int totalDaysOfMonth(String date){
       YearMonth yearMonth= YearMonth.parse("2014-09");
        YearMonth yearMonthObject = YearMonth.of(yearMonth.getYear(), yearMonth.getMonthValue());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        return daysInMonth;
    }
    private static Integer totalDays( Period period){
        return (period.getYears()*12*365+period.getMonths()*30+period.getDays()-2);
    }
    /*******************
     * Helper functions *
     *******************/

    /**
     Takes a LocalDate object and returns a LocalDate which is the first day
     of that month. For example:

     firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the last day
     of that month. For example:

     lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the next day.
     For example:

     nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
     nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}