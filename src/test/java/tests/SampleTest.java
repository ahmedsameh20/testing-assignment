package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void test1(){
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){
        Assert.assertEquals(2+2,4);
    }
}
