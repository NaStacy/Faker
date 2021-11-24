package generation.randomsgenerator.implementation;

import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class ParameterGenerator {
    private final Class<?> clazz;
    private final Constructor<?> constructor;

    public Object[] generateParametersForConstructor() {
        Class<?>[] constructorParametersTypes = constructor.getParameterTypes();
        Object[] generatedParametersForConstructor = new Object[constructorParametersTypes.length];
        int index = 0;
        ValueGetter valueGetter;
        for (Class<?> type: constructorParametersTypes){
            valueGetter = new ValueGetter(type);
            generatedParametersForConstructor[index++] = valueGetter.generateValueOfType();
        }

        return generatedParametersForConstructor;
    }
}
