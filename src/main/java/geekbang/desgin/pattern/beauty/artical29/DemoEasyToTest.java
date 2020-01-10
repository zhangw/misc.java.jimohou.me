package geekbang.desgin.pattern.beauty.artical29;


import lombok.extern.slf4j.Slf4j;

/**
 * @author vincent
 * @date 2020/1/9
 */
@Slf4j
public class DemoEasyToTest {
    private Lock locker;

    private BizService bizService;

    public DemoEasyToTest(Lock locker, BizService bizService) {
        this.locker = locker;
        this.bizService = bizService;
    }

    public void doBiz(){
        try {
            locker.lock();
            bizService.request(new Object());
            log.info("do my biz");
        }finally {
            locker.unlock();
        }
    }

    private static class Locker implements Lock {
        @Override
        public void lock() {
            LockSingletonImpl.getInstance().lock();
        }

        @Override
        public void unlock() {
            LockSingletonImpl.getInstance().unlock();
        }
    }

    public interface Lock {
        void lock();

        void unlock();
    }

    public interface BizService {
        void request(Object object);
    }

    private static class SomeBizServiceImpl implements BizService {
        @Override
        public void request(Object object){
        }
    }

    private static class LockSingletonImpl {
        private LockSingletonImpl(){
        }

        private static DemoEasyToTest.LockSingletonImpl singleton;
        public static DemoEasyToTest.LockSingletonImpl getInstance(){
            synchronized (DemoEasyToTest.LockSingletonImpl.class){
                if(singleton == null){
                    singleton = new DemoEasyToTest.LockSingletonImpl();
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
