package geekbang.desgin.pattern.beauty.artical29;

import java.util.Date;

/**
 * 重构前，有关未决逻辑不好写单元测试
 * @author vincent
 * @date 2020/1/7
 */
public class Demo {
    /**
     * currentTimeMillis造成了关于当前时间的未决逻辑
     * @param dueTime
     * @return
     */
    @Deprecated
    public long caculateDelayDays(Date dueTime) {
        long currentTimestamp = System.currentTimeMillis();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400_000;
        return delayDays;
    }

    /*
     * 改造后，方便测试未决逻辑的实现
     */
    private long currentTimeMillis;
    private Date dueTime;
    public Demo(Date dueTime){
        this.dueTime = dueTime;
        this.currentTimeMillis = getCurrentTimeMillis();
    }

    protected long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
    public long caculateDelayDays() {
        if(dueTime.getTime() >= currentTimeMillis){
            return 0;
        }
        long delayTime = currentTimeMillis - dueTime.getTime();
        long delayDays = delayTime / 86400_000;
        return delayDays;
    }
}