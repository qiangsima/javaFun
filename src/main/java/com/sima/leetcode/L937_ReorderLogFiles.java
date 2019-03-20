package com.sima.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qisima on 3/19/2019 3:43 PM
 */
public class L937_ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs){
        List<String> digitLogs = new LinkedList<>();
        List<String> letterLog = new LinkedList<>();
        for (String log : logs){
            int idx = log.indexOf(' ');
            String words = log.substring(idx+1);
            if (words.charAt(0) >= 'a' && words.charAt(0) <= 'z'){
                boolean flag = false;
                for (int i = 0; i < letterLog.size(); i++) {
                    String s = letterLog.get(i);
                    if (s.substring(s.indexOf(' ') + 1).compareTo(words) > 0){
                        letterLog.add(i, log);
                        flag = true;
                    }
                }
                if (!flag){
                    letterLog.add(log);
                }
            } else {
              digitLogs.add(log);
            }
        }
        String[] res = new String[logs.length];
        int i = 0;
        for (String str : letterLog){
            res[i++] = str;
        }
        for (String str : digitLogs){
            res[i++] = str;
        }
        return res;
    }

    public String[] reorderLogFiles2(String[] logs){
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int idx1 = s1.indexOf(' ');
                int idx2 = s2.indexOf(' ');

                if (Character.isDigit(s1.charAt(idx1+1))){
                    if (Character.isDigit(s2.charAt(idx2+1))){
                        return 0;
                    }
                    return 1;
                }
                if (Character.isDigit(s2.charAt(idx2+1))){
                    return -1;
                }

                return s1.substring(idx1+1).compareTo(s2.substring(idx2+1));
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
