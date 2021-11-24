package generation.randomsgenerator.implementation;

import generation.randomsgenerator.enums.CollectionTypes;
import generation.randomsgenerator.enums.MapTypes;
import generation.randomsgenerator.enums.SimpleTypeArrays;
import generation.randomsgenerator.enums.SimpleTypes;

import java.util.*;

public class TypesToMap {
    private static Map<Class<?>, SimpleTypes> simpleTypes;
    private static Map<Class<?>, SimpleTypeArrays> simpleTypeArrays;
    private static Map<Class<?>, CollectionTypes> collectionTypes;
    private static Map<Class<?>, MapTypes> mapTypes;

    static {
        simpleTypeArrays = Map.of(
                Number.class, SimpleTypeArrays.NUMBERARR,
                byte.class, SimpleTypeArrays.BYTEARR,
                Boolean.class, SimpleTypeArrays.BOOLEANARR,
                Character.class, SimpleTypeArrays.CHARACTERARR,
                String.class, SimpleTypeArrays.STRINGARR,
                Calendar.class, SimpleTypeArrays.DATEARR
        );
        simpleTypes = Map.of(
                Number.class, SimpleTypes.NUMBER,
                Boolean.class, SimpleTypes.BOOLEAN,
                Character.class, SimpleTypes.CHARACTER,
                String.class, SimpleTypes.STRING,
                Calendar.class, SimpleTypes.DATE
        );
        collectionTypes = Map.of(
                ArrayList.class, CollectionTypes.LIST,
                HashSet.class, CollectionTypes.SET,
                ArrayDeque.class, CollectionTypes.QUEUE
        );
        mapTypes = Map.of(
                HashMap.class, MapTypes.HASHMAP,
                TreeMap.class, MapTypes.TREEMAP
        );
    }

    public static Map<Class<?>, SimpleTypes> getSimpleTypes() {
        return simpleTypes;
    }

    public static Map<Class<?>, SimpleTypeArrays> getSimpleTypeArrays() {
        return simpleTypeArrays;
    }

    public static Map<Class<?>, CollectionTypes> getCollectionTypes() {
        return collectionTypes;
    }

    public static Map<Class<?>, MapTypes> getMapTypes() {
        return mapTypes;
    }
}


