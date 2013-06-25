package com.android.monkeyrunner;

import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MonkeyFormatter extends Formatter {
    public static final Formatter DEFAULT_INSTANCE = new MonkeyFormatter();

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyMMdd HH:mm:ss.SSS");

    private static final Map<Level, String> LEVEL_TO_STRING_CACHE = Maps.newHashMap();

    private static String levelToString(Level paramLevel) {
        String str = (String) LEVEL_TO_STRING_CACHE.get(paramLevel);
        if (str == null) {
            str = paramLevel.getName().substring(0, 1);
            LEVEL_TO_STRING_CACHE.put(paramLevel, str);
        }
        return str;
    }

    private static String getHeader(LogRecord paramLogRecord) {
        StringBuilder localStringBuilder = new StringBuilder();

        localStringBuilder.append(FORMAT.format(new Date(paramLogRecord.getMillis()))).append(":");
        localStringBuilder.append(levelToString(paramLogRecord.getLevel())).append(" ");

        localStringBuilder.append("[").append(Thread.currentThread().getName()).append("] ");

        String str = paramLogRecord.getLoggerName();
        if (str != null) {
            localStringBuilder.append("[").append(str).append("]");
        }
        return localStringBuilder.toString();
    }

    public String format(LogRecord paramLogRecord) {
        Throwable localThrowable = paramLogRecord.getThrown();

        String str = getHeader(paramLogRecord);

        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" ").append(formatMessage(paramLogRecord));
        localStringBuilder.append("\n");

        if (localThrowable != null) {
            localThrowable.printStackTrace();
        }

        return localStringBuilder.toString();
    }

}