package defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProopertiesDefs {

    Properties properties = new Properties();

    @Given("{string} property file")
    public void propertyFile(String propertyFileName) throws IOException {
        try(InputStream in = getClass().getClassLoader().getResourceAsStream(propertyFileName)){
            if (in ==null){
                Assert.fail();
            } else {
                properties.load(in);
            }
        }
    }

    @Then("Property {string} is not null")
    public void propertyIsNotNull(String key) {
        String property = properties.getProperty(key);
        System.out.println("property = " + property);
    }
}
