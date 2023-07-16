package com.coherentsolutions.training.auto.API.pashkovskaya.base;

import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    @BeforeMethod
    public void setUp() throws IOException {
        Specs.instalSpec(Specs.requestSpec(PropertiesFileReader.getBaseURI(), PropertiesFileReader.getBasePath()), Specs.responseSpecOK200());
    }
}
