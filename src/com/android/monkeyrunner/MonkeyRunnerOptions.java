package com.android.monkeyrunner;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import java.io.File;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonkeyRunnerOptions {
    private static final Logger LOG = Logger.getLogger(MonkeyRunnerOptions.class.getName());
    private static String DEFAULT_MONKEY_SERVER_ADDRESS = "127.0.0.1";
    private static int DEFAULT_MONKEY_PORT = 12345;
    private final int port;
    private final String hostname;
    private final File scriptFile;
    private final String backend;
    private final Collection<File> plugins;
    private final Collection<String> arguments;
    private final Level logLevel;

    private MonkeyRunnerOptions(String paramString1, int paramInt, File paramFile, String paramString2, Level paramLevel, Collection<File> paramCollection, Collection<String> paramCollection1) {
        this.hostname = paramString1;
        this.port = paramInt;
        this.scriptFile = paramFile;
        this.backend = paramString2;
        this.logLevel = paramLevel;
        this.plugins = paramCollection;
        this.arguments = paramCollection1;
    }

    public int getPort() {
        return this.port;
    }

    public String getHostname() {
        return this.hostname;
    }

    public File getScriptFile() {
        return this.scriptFile;
    }

    public String getBackendName() {
        return this.backend;
    }

    public Collection<File> getPlugins() {
        return this.plugins;
    }

    public Collection<String> getArguments() {
        return this.arguments;
    }

    public Level getLogLevel() {
        return this.logLevel;
    }

    private static void printUsage(String paramString) {
        System.out.println(paramString);
        System.out.println("Usage: monkeyrunner [options] SCRIPT_FILE");
        System.out.println("");
        System.out.println("    -s      MonkeyServer IP Address.");
        System.out.println("    -p      MonkeyServer TCP Port.");
        System.out.println("    -v      MonkeyServer Logging level (ALL, FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE, OFF)");
        System.out.println("");
        System.out.println("");
    }

    public static MonkeyRunnerOptions processOptions(String[] paramArrayOfString) {
        int i = 0;

        String str1 = DEFAULT_MONKEY_SERVER_ADDRESS;
        File localFile1 = null;
        int j = DEFAULT_MONKEY_PORT;
        String str2 = "adb";
        Level localLevel = Level.SEVERE;

        Builder<File> localBuilder1 = ImmutableList.builder();
        Builder<String> localBuilder2 = ImmutableList.builder();
        while (i < paramArrayOfString.length) {
            String str3 = paramArrayOfString[(i++)];

            if ("-s".equals(str3)) {
                if (i == paramArrayOfString.length) {
                    printUsage("Missing Server after -s");
                    return null;
                }
                str1 = paramArrayOfString[(i++)];
            } else if ("-p".equals(str3)) {
                if (i == paramArrayOfString.length) {
                    printUsage("Missing Server port after -p");
                    return null;
                }
                j = Integer.parseInt(paramArrayOfString[(i++)]);
            } else if ("-v".equals(str3)) {
                if (i == paramArrayOfString.length) {
                    printUsage("Missing Log Level after -v");
                    return null;
                }

                localLevel = Level.parse(paramArrayOfString[(i++)]);
            } else if ("-be".equals(str3)) {
                if (i == paramArrayOfString.length) {
                    printUsage("Missing backend name after -be");
                    return null;
                }
                str2 = paramArrayOfString[(i++)];
            } else if ("-plugin".equals(str3)) {
                if (i == paramArrayOfString.length) {
                    printUsage("Missing plugin path after -plugin");
                    return null;
                }
                File localFile2 = new File(paramArrayOfString[(i++)]);
                if (!localFile2.exists()) {
                    printUsage("Plugin file doesn't exist");
                    return null;
                }

                if (!localFile2.canRead()) {
                    printUsage("Can't read plugin file");
                    return null;
                }

                localBuilder1.add(localFile2);
            } else if (!"-u".equals(str3)) {
                if ((str3.startsWith("-")) && (localFile1 == null)) {
                    printUsage("Unrecognized argument: " + str3 + ".");
                    return null;
                }
                if (localFile1 == null) {
                    localFile1 = new File(str3);
                    if (!localFile1.exists()) {
                        printUsage("Can't open specified script file");
                        return null;
                    }
                    if (!localFile1.canRead()) {
                        printUsage("Can't open specified script file");
                        return null;
                    }
                } else {
                    localBuilder2.add(str3);
                }
            }
        }

        return new MonkeyRunnerOptions(str1, j, localFile1, str2, localLevel, localBuilder1.build(), localBuilder2.build());
    }
}