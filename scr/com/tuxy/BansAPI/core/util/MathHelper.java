package com.tuxy.bansapi.core.util;


public class MathHelper {
    public int mins(int days){
        return days*60*60*24;
    }
    public int hours(int seconds){
        return seconds/360;
    }
}
