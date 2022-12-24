package com.example.appapi.util;

import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class CommonUtil {
    public Timestamp getTimeNow(){
        return Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    }
}
