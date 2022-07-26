package com.company.provider;

import org.testng.annotations.DataProvider;

public class InvalidUser {

    @DataProvider(name = "NonValidUserNameProvider")
    public static Object[][] getNonValidUserNameDataprovider(){
        return new Object[][] {
                { "Neispravan user"}
                //     { "" }
        };
    }
    @DataProvider(name= "NonValidPasswordProvider")
    public static Object[][] getNonValidPasswordDataprovider() {
        return new Object[][]{
                {"Neispravan password"}
        };
    }}

