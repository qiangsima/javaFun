package com.sima.leetcode;

/**
 * Created by qisima on 7/31/2019 4:42 PM
 */
public class L1108_DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args){
        String addr = "127.0.0.1";
        System.out.println(new L1108_DefangIPaddr().defangIPaddr(addr));
    }
}
