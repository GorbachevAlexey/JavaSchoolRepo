package com.sbt.lesson6;


public class Week extends Month {
    static final String SUNDAY = "SUNDAY";
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    private static final String WEDNESDAY = "WEDNESDAY";
    private static final String THURSDAY = "THURSDAY";
    protected static final String FRIDAY = "FRIDAY!";
    protected static final String SATURDAY = "SATUDRAY!";

    public Week() {
    }

    private int weakPrivate(int a) {
        System.out.println("weakPrivate return:" + a);
        return a;
    }

    public void weakPublic() {
        System.out.println("weakPublic have  printed this.");
    }

    public static String getSUNDAY() {
        return SUNDAY;
    }

    public static String getWEDNESDAY() {
        return WEDNESDAY;
    }

    public static String getTHURSDAY() {
        return THURSDAY;
    }

    public static String getFRIDAY() {
        return FRIDAY;
    }

    public static String getSATURDAY() {
        return SATURDAY;
    }
}
