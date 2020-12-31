package config.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class GetProperties extends ArgumentParser {
    private Properties properties;


    public String getProperty(String value) {
        getParameters();
        String property;
        if (argumentListHaveContent()) {
            if (parametersFromGradle.get(value) != null) {
                property = parametersFromGradle.get(value);
            } else {
                property = propertiesFile().getProperty(value);
            }
        } else {
            property = propertiesFile().getProperty(value);
        }
        return property;
    }


    protected Properties propertiesFile() {
        properties = new Properties();
        try {
            if (Paths.get("test.properties").toFile().exists()) {
                try {
                    InputStream file = new FileInputStream("test.properties");
                    properties.load(file);
                } catch (Exception e) {
                    throw new Exception("Unable load properties from file");
                }
            } else {

                throw new Exception(" ::: Properties File not Found !!! ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return properties;
    }


    public String getBrowserName() {
        String browserName;
        try {
            if (getProperty("browser") == null) {
                throw new Exception("Missing parameter " + "\"browser\"" + " in test.properties file");
            } else {
                browserName = getProperty("browser");
                if (!browserName.equals("")) {
                    return browserName.toLowerCase();
                } else {
                    throw new Exception("Parameter : " + "\"browser\"" + " is empty in test.properties file !!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
