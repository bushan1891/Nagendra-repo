package JCS_test.JCS_Test;

import jcs.contorller.UserController;
import jcs.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new UserController(new UserService()); 
    }
}
