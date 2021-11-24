package generation.randomsgenerator.valuesgeneration;

import java.util.Calendar;

public class RandomValueGenerator {
    private static int max = 200;
    private static int min = 10;


    public static Number generateRandomNumber(){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static String generateRandomString(){
        return String.valueOf(generateRandomNumber());
    }

    public static Boolean generateRandomBoolean(){
        return generateRandomString().length() > 2;
    }

    public static Character generateRandomCharacter(){
        return (char)generateRandomNumber().byteValue();
    }

    public static Byte generateRandomByte(){
        return generateRandomNumber().byteValue();
    }

    public static Calendar generateRandomDate(){
        return Calendar.getInstance();
    }
}
