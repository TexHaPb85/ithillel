package edu.ithillel.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class ExternalDataReceivingExample {
    private final static String ENV_VARIABLE_NAME = "Path";

    public static void main(String[] args) throws IOException {

        /* 1. program arguments */
        //System.out.println("program arguments" + Arrays.toString(args));

        /* 2. system variable */
        //getSystemVariables();

        /* 3. properties file */
        getProgramProperties();
    }

    private static void getSystemVariables() {
        String getenv = System.getenv(ENV_VARIABLE_NAME);
        System.out.println("Path: " + getenv + "\n-----------------------------------------\n");

        Map<String, String> envVariables = System.getenv();
        envVariables.keySet().forEach(key -> {
            String systemVariable = System.getenv(key);
            StringBuilder sb = new StringBuilder("Values of environment variable " + key + ": \n");
            for (String s : systemVariable.split(";")){
                sb.append(s).append("\n");
            }
            System.out.println(sb.toString());
        });
    }

    private static void getProgramProperties() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "io/app.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(appProps);
    }
}
