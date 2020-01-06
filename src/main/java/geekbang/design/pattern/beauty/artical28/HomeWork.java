package geekbang.design.pattern.beauty.artical28;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * https://time.geekbang.org/column/article/185684
 * @author vincent
 * @date 2020/1/6
 */
public class HomeWork {
    /**
     * 二分查找第一个大于等于目标数的位置
     * @param numbers 要查找的升序排序的数组
     * @param theNumber 目标数
     * @param originIndex 起始位置
     * @return 数组里的位置，如果找到；否则返回-1
     */
    public int searchFirstGraterOrEqual(int[] numbers, int theNumber, int originIndex){
        int size = numbers.length;
        if(size == 0){
            return -1;
        }
        if(size == 1){
            if(numbers[0] >= theNumber){
                return originIndex;
            }
            return -1;
        }
        int start = 0;
        int end = start + size - 1;
        int middle = (start + end) >>> 1;
        if(numbers[middle] >= theNumber){
            int[] left = Arrays.copyOfRange(numbers, start, middle + 1);
            return searchFirstGraterOrEqual(left, theNumber, originIndex);
        }
        if(numbers[middle] < theNumber){
            int[] right = Arrays.copyOfRange(numbers, middle + 1, end + 1);
            return searchFirstGraterOrEqual(right, theNumber, middle + 1 + originIndex);
        }
        return -1;
    }
}
