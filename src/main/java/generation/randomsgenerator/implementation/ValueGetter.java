package generation.randomsgenerator.implementation;

import generation.dtogenerator.Faker;
import generation.randomsgenerator.enums.CollectionTypes;
import generation.randomsgenerator.enums.MapTypes;
import generation.randomsgenerator.interfaces.Value;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Field;

public class ValueGetter {

    public Field field;

    private Class<?> typeOfValue;
    private Class<?> typeOfKey;

    private Class<?> instanceOwner;

    private Boolean isArray = false;

    public ValueGetter() {
    }

    public ValueGetter(Class<?> typeOfValue) {
        this.typeOfValue = typeOfValue;
    }

    public ValueGetter(Field field) {
        this.field = field;
        typeOfValue = field.getType();
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Object generateValueOfType() {
        if (typeOfValue.isArray()){
            typeOfValue = typeOfValue.getComponentType();
            isArray = true;
        }
        if (typeOfValue.isPrimitive() && (typeOfValue != byte.class)){
            typeOfValue = ClassUtils.primitiveToWrapper(typeOfValue);
        }
        if (typeOfValue.getSuperclass() == Number.class && typeOfValue != byte.class){
            typeOfValue = Number.class;
        }
        if (TypesToMap.getSimpleTypeArrays().containsKey(typeOfValue) && isArray){
            Value value = TypesToMap.getSimpleTypeArrays().get(typeOfValue);
            return value.get();
        }
        if (TypesToMap.getSimpleTypes().containsKey(typeOfValue)){
            Value value = TypesToMap.getSimpleTypes().get(typeOfValue);
            return value.get();
        }
        if (TypesToMap.getCollectionTypes().containsKey(typeOfValue)){
            CollectionTypes value = TypesToMap.getCollectionTypes().get(typeOfValue);
            if (hasEnoughDataForComplexDataGeneration()){
                value.set(field);
            }
            return value.get();
        }
        if (TypesToMap.getMapTypes().containsKey(typeOfValue)){
            MapTypes value = TypesToMap.getMapTypes().get(typeOfValue);
            if (hasEnoughDataForComplexDataGeneration()){
                value.set(field);
            }
            return value.get();
        }
        Faker faker = new Faker<>();
        return faker.create(typeOfValue);
    }

    private boolean hasEnoughDataForComplexDataGeneration(){
        return field != null;
    }


}
