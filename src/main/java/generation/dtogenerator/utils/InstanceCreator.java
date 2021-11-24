package generation.dtogenerator.utils;

import generation.randomsgenerator.implementation.ParameterGenerator;
import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@Data
public class InstanceCreator<T> {
    private final Class<T> clazz;

    public Constructor<?> getConstructor(){
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0){
            return null;
        }
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);
        return constructor;
    }

    @SneakyThrows
    public T create() {
        Constructor<?> constructor = getConstructor();
        if (constructor == null){
            return null;
        }
        ParameterGenerator parameterGenerator = new ParameterGenerator(clazz, constructor);
        Object[] generatedParametersForConstructor = parameterGenerator.generateParametersForConstructor();
        return (T) constructor.newInstance(generatedParametersForConstructor);
    }
}
