package com.hcl.oop.model;

public class AccessDemo {

    public String publicValue = "Public";
    private String privateValue = "Private";
    protected String protectedValue = "Protected";
    String defaultValue = "Default";

    public void showValues() {
        System.out.println(publicValue);
        System.out.println(privateValue);
        System.out.println(protectedValue);
        System.out.println(defaultValue);
    }
}