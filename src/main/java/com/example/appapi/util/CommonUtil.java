package com.example.appapi.util;

import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static Timestamp getTimeNow(){
        return Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    }

    public static String formatTime(Date time){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }
}
