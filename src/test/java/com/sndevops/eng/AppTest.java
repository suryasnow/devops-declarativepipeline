package com.sndevops.eng;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class AppTest {
    private String INPUT = "4";

    @Test
     public void testQETest1() throws Exception {
         // Test with new Dev build 1
         Assert.assertEquals(INPUT,"4");
        Thread.sleep(5000);
     }
    
         @Test
     public void testQETest2() throws Exception{
         // Test with new Dev build 1
         Thread.sleep(5000);
         Assert.assertEquals(INPUT,"44");
     }
    
    //     @Test
    // public void testQETest3() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    //             Thread.sleep(5000);
    // }
    //     @Test
    // public void testQETest4() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    // }
    //     @Test
    // public void testQETest5() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");
  
    // }
    //     @Test
    // public void testQETest6() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    // }
    //     @Test
    // public void testQETest7() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    // }
    //     @Test
    // public void testQETest8() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");
   
    // }
    //     @Test
    // public void testQETest9() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    // }    @Test
    // public void testQETest10() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");
 
    // }
    //     public void testQETest11() throws Exception{
    //     // Test with new Dev build 1
    //     Assert.assertEquals(INPUT,"4");

    // }

    //@Ignore
    @Test public void testQETest13(){}

    
}
