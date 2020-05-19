package com.sample;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        String s = generateUUID();
        System.out.println("uuid: " + s);

    }

    private static String generateUUID(){
        return String.valueOf(UUID.randomUUID());
    }
}
