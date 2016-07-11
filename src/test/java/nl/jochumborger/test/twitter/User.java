package nl.jochumborger.test.twitter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jochum on 11/07/16.
 */
public class User {

    private Properties props;

    private static User instance;

    private User() {
        this.props = new Properties();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("twitter.properties");
            this.props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public String getUsername() {
        return props.getProperty("twitter.username");
    }

    public String getPassword() {
        return props.getProperty("twitter.password");
    }

    public String getDisplayName() {
        return props.getProperty("twitter.displayname");
    }

    public String getHandle() {
        return props.getProperty("twitter.handle");
    }

}
