package com.sima.leetcode;

/**
 * Created by qisima on 8/15/2019 5:23 PM
 */
public class L1154_DayOfYear {
    public int dayOfYear(String date){
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int res = isLeapYear(year) && month > 2 ? 1 : 0;
        res += days[month-1] + day;
        return res;
    }
    private boolean isLeapYear(int year){
        if (year % 100 == 0){
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}
