package commons;


import java.util.Random;

public class BaseTest {
    public int randomNumber(){
       return new Random().nextInt(9999);
    }
}
