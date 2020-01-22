package dataType;

/**
 * 选择排序算法
 */
public class SelectionSort {
    /**
     * 交换小标i 和下表j 处的元素
     */
    public static void swapElements(int[]array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}