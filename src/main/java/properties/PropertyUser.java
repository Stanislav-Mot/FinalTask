package properties;

import logs.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUser {
    public static String getPropertyValue(String propertyKey) throws IOException {
        String result = "";
        InputStream inputStream = null;

        try {
            Log.info("Using the property");
            Properties prop = new Properties();
            String propFileName = "user.properties";
            inputStream = PropertyUser.class.getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
            result = prop.getProperty(propertyKey);
        } catch (Exception e) {
            Log.error(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return result;
    }
}
