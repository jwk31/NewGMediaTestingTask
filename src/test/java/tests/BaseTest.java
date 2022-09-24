package tests;

import dataProviders.ConfigReader;
import Helper.HelperMethod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Driver;

public class BaseTest {

    HelperMethod helper = new HelperMethod();

    @BeforeClass
    public void Setup() {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
    }

    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
