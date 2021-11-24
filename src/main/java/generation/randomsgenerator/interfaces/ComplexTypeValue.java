package generation.randomsgenerator.interfaces;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public interface ComplexTypeValue extends Value{
    void set(Field field);

    @SneakyThrows
    default Class<?> getGenericTypeOfCollection(Field field) {
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        return (Class<?>) genericType.getActualTypeArguments()[0];
    }

    @SneakyThrows
    default Class<?>[] getGenericTypesOfMap(Field field) {
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        Class<?>[] types = new Class[2];
        types[0] = (Class<?>) genericType.getActualTypeArguments()[0];;
        types[1] = (Class<?>) genericType.getActualTypeArguments()[1];;
        return types;
    }
}
