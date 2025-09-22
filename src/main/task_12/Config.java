package main.task_12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private final Properties properties = new Properties();

    public Config(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            properties.load(fis);
        }
    }

    public String getRoutePlannerType() {
        return properties.getProperty("route.planner");
    }

}
