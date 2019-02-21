package com.sima.leetcode;

import java.util.*;

/**
 * Created by qisima on 2/21/2019 3:14 PM
 *
 * Example:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class L811_SubDomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains){
            String[] cp = str.split(" ");
            int cnt = Integer.parseInt(cp[0]);
            String domain = cp[1];
            map.put(cp[1], cnt+map.getOrDefault(domain, 0));
            int idx = cp[1].indexOf('.');
            while (idx > 0) {
                domain = domain.substring(idx+1);
                map.put(domain, cnt+map.getOrDefault(domain, 0));
                idx = domain.indexOf('.');
            }
        }
        List<String> list = new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            int cnt = map.get(key);
            list.add(cnt + " " + key);
        }
        return list;
    }
}
