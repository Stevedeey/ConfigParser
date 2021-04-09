import configparser.ConfigParserClass;


import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);



       // String programArgument = (args[0]);


        if (args.length==0||args[0].equalsIgnoreCase("production")) {
            ConfigParserClass config = new ConfigParserClass("config.txt");
            display(config);
        } else if (args[0].equalsIgnoreCase("development")) {
            ConfigParserClass configDev = new ConfigParserClass("config.txt.dev");
            display(configDev);
        } else if (args[0].equalsIgnoreCase("staging")) {
            ConfigParserClass configStaging = new ConfigParserClass("config.txt.staging");
            display(configStaging);
        } else System.out.println("Invalid Argument. ");




    }
    public static void display(ConfigParserClass config) throws IOException
    {
        System.out.println("name = " + config.getFieldValue("application.name"));
        System.out.println(" dbname = " + config.getFieldValue("dbname"));
        System.out.println(" host = " + config.getFieldValue("application.host"));
        System.out.println(" mode = " + config.getFieldValue("mode"));
        System.out.println(" contest URL = " + config.getFieldValue("application.context-url"));
        System.out.println(" host = " + config.getFieldValue("theme"));
        System.out.println("pipeline = " + config.getFieldValue("pipeline"));
        System.out.println("port = " + config.getFieldValue("port"));

    }
}
