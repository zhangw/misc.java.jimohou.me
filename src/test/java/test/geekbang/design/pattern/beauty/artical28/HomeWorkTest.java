package test.geekbang.design.pattern.beauty.artical28;

import geekbang.design.pattern.beauty.artical28.HomeWork;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author vincent
 * @date 2020/1/6
 */
public class HomeWorkTest {
    @Test
    public void test(){
        HomeWork homeWork = new HomeWork();
        int value = homeWork.searchFirstGraterOrEqual(new int[]{}, 1, 0);
        Assert.assertEquals(value, -1);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1}, 2, 0);
        Assert.assertEquals(value, -1);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1}, 1, 0);
        Assert.assertEquals(value, 0);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,2}, 2, 0);
        Assert.assertEquals(value, 1);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,2,3,4}, 3, 0);
        Assert.assertEquals(value, 3);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,2,3,4}, 4, 0);
        Assert.assertEquals(value, 4);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,3,3,3}, 3, 0);
        Assert.assertEquals(value, 2);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,3,3,8}, 0, 0);
        Assert.assertEquals(value, 0);
        value = homeWork.searchFirstGraterOrEqual(new int[]{1,2,3,3,8}, 9, 0);
        Assert.assertEquals(value, -1);
    }
}
