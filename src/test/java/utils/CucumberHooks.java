package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before
    public void setUp() {
        DriverSetup.getDriver();
    }

    @After
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}


