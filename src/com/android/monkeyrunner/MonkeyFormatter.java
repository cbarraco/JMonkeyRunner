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
    private static Map<Level, String> LEVEL_TO_STRING_CACHE = Maps.newHashMap();

    private static String levelToString(Level level) {
        String str = LEVEL_TO_STRING_CACHE.get(level);
        if (str == null) {
            str = level.getName().substring(0, 1);
            LEVEL_TO_STRING_CACHE.put(level, str);
        }
        return str;
    }

    private static String getHeader(LogRecord logRecord) {
        StringBuilder localStringBuilder = new StringBuilder();

        localStringBuilder.append(FORMAT.format(new Date(logRecord.getMillis()))).append(":");
        localStringBuilder.append(levelToString(logRecord.getLevel())).append(" ");

        localStringBuilder.append("[").append(Thread.currentThread().getName()).append("] ");

        String str = logRecord.getLoggerName();
        if (str != null) {
            localStringBuilder.append("[").append(str).append("]");
        }
        return localStringBuilder.toString();
    }

    public String format(LogRecord logRecord) {
        Throwable localThrowable = logRecord.getThrown();

        String str = getHeader(logRecord);

        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" ").append(formatMessage(logRecord));
        localStringBuilder.append("\n");

        if (localThrowable != null) {
            localThrowable.printStackTrace();
        }

        return localStringBuilder.toString();
    }

}