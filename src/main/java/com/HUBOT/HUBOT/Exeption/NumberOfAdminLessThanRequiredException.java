package com.HUBOT.HUBOT.Exeption;
/*used in admin class in method edit admin access degree to throw an
    exception when number of admin with the highest access are degree less than 1 */
public class NumberOfAdminLessThanRequiredException extends Exception{
    public NumberOfAdminLessThanRequiredException() {
    }

    public NumberOfAdminLessThanRequiredException(String message) {
        super(message);
    }

     public NumberOfAdminLessThanRequiredException(Throwable cause) {
         super(cause);
     }

     public NumberOfAdminLessThanRequiredException(String message, Throwable cause) {
         super(message, cause);
     }
 }
