
package com.look.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 功能描述 : 排列不重复的工具类
 * @author vansee
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class PermutationsUtils implements Serializable
{

    /**
     * 不重复排列
     *
     * @param values 需要排序的元素集合
     * @return 排序后的列表集合
     */
    public static List<String> permutations(List<String> values, String sp)
    {
        List<String> result = new ArrayList<>();
        List<List<String>> lists = PermutationsUtils.permutations(values);
        for (Iterator<List<String>> iterator = lists.iterator(); iterator.hasNext(); ) {
              result.add(sp + String.join(sp, iterator.next()) +sp);
        }
        return  result;
    }

    /**
     * 不重复排列
     *
     * @param values 需要排序的元素集合
     * @return 排序后的列表集合
     */
    public static List<List<String>> permutations(List<String> values)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(values.toArray(new String[values.size()]), 0, result);
        return result;
    }

    /**
     * 递归执行排列不重复
     *
     * @param array 排列的数组集合
     * @param start 排列的开始位置
     * @param results 排列的结果集合
     * @param <E> 对象类型
     */
    private static <E> void dfs(E[] array, int start, List<List<E>> results)
    {
        if (start == array.length)
        {
            List<E> result = new ArrayList<>();
            result.addAll(Arrays.asList(array));
            results.add(result);
        }

        for (int idx = start; idx < array.length; idx++)
        {
            boolean flag = false;
            for (int num = start + 1; num < idx; num++)
            {
                if (array[num].equals(array[idx]))
                {
                    flag = true;
                }
            }

            if (flag)
            {
                continue;
            }

            E tmp = array[start];
            array[start] = array[idx];
            array[idx] = tmp;
            dfs(array, start + 1, results);
            array[idx] = array[start];
            array[start] = tmp;
        }
    }
}