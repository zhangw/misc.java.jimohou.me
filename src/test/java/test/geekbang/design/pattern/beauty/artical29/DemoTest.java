package test.geekbang.design.pattern.beauty.artical29;

import geekbang.desgin.pattern.beauty.artical29.Demo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author vincent
 * @date 2020/1/7
 */
public class DemoTest {
    @Test
    public void testCaculateDelayDays(){
        TimeZone timeZone = TimeZone.getTimeZone("Asia/ShangHai");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.clear();
        calendar.set(2020, Calendar.FEBRUARY,1,0,0,0);
        Date dueTime = calendar.getTime();
        Demo demo = new DemoClassOne(dueTime);
        Assert.assertEquals(demo.caculateDelayDays(), 0);
        calendar.clear();
        calendar.set(2019, Calendar.DECEMBER, 31, 0,0,0);
        dueTime = calendar.getTime();
        demo = new DemoClassOne(dueTime);
        Assert.assertEquals(demo.caculateDelayDays(), 1);
    }

    public static class DemoClassOne extends Demo {
        public DemoClassOne(Date dueTime) {
            super(dueTime);
        }
        @Override
        protected long getCurrentTimeMillis() {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/ShangHai");
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.clear();
            calendar.set(2020, Calendar.JANUARY,1,0,0,0);
            return calendar.getTimeInMillis();
        }
    }
}
