package geekbang.desgin.pattern.beauty.artical29;

import java.util.concurrent.locks.Lock;

/**
 * @author vincent
 * @date 2020/1/9
 */
public class DemoHardToTest {
    /**
     * hard to test this feature
     */
    public void doBiz(){
        LockSingletonImpl locker = LockSingletonImpl.getInstance();
        try {
            locker.lock();
            SomeBizServiceImpl someBizService = new SomeBizServiceImpl();
            someBizService.request(new Object());
        }finally {
            locker.unlock();
        }
    }

    private static class SomeBizServiceImpl {
        public void request(Object object){
        }
    }

    private static class LockSingletonImpl {
        private LockSingletonImpl(){
        }

        private static LockSingletonImpl singleton;
        public static LockSingletonImpl getInstance(){
            synchronized (LockSingletonImpl.class){
                if(singleton == null){
                    singleton = new LockSingletonImpl();
                    return singleton;
                }
                return singleton;
            }
        }

        public void lock(){
        }

        public void unlock(){
        }
    }
}
