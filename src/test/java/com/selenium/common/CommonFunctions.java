package com.selenium.common;

public class CommonFunctions {


    public void forceWaitForTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
