package com.sima.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qisima on 1/2/2019 10:24 PM
 */
public class L929_UniqueEmailAddress {
    public int numUniqueEmails(String[] emails){
        Set<String> set = new HashSet<>();
        for (String email : emails){
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0];
            local = local.replaceAll(".", "");
            set.add(local+"@"+parts[1]);
        }
        return set.size();
    }
}
