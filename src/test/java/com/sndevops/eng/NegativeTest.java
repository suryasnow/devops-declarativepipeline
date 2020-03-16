package com.sndevops.eng;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class NegativeTest {
    private String INPUT = "4";
    
    @Test
    public void negativeTest1() throws Exception{
        Thread.sleep(5000);
        Assert.assertEquals(INPUT,"44");
        
    }

    @Test
    //@Ignore
    public void negativeTest2()throws Exception {
        Thread.sleep(5000);
    }

    
}
