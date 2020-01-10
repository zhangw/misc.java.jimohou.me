package test.geekbang.design.pattern.beauty.artical29;

import geekbang.desgin.pattern.beauty.artical29.DemoEasyToTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @author vincent
 * @date 2020/1/10
 */
@Slf4j
public class DemoEasyToTestCase {
    @Test
    public void test(){
        DemoEasyToTest.Lock lockMocked = new DemoEasyToTest.Lock() {
            @Override
            public void lock() {
                log.info("locked");
            }

            @Override
            public void unlock() {
                log.info("unlocked");
            }
        };
        DemoEasyToTest.BizService bizServiceMocked = new DemoEasyToTest.BizService() {
            @Override
            public void request(Object object) {
                log.info("do the request");
            }
        };
        DemoEasyToTest easyToTest = new DemoEasyToTest(lockMocked, bizServiceMocked);
        easyToTest.doBiz();
    }
}
