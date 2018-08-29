package com.first;
/**
 * 实例类
 * @author aran
 *
 */
public class Common {
	/**
	 * 返回list中的最大值
	 * @param list
	 * @return
	 */
	public static int getMaxNumByList(int[] list) {
        if(list == null || list.length == 0) {
            throw new RuntimeException("Empty list");
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.length; i++) {
            if(list[i] > max) {
                max = list[i];
            }
        }
        return max; 
    }
}
