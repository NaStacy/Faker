package generation.dtogenerator.utils;

import generation.randomsgenerator.implementation.ValueGetter;
import lombok.Data;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Data
public class FieldFiller<T> {
    private final T instance;
    private final Set<Method> setters;

    public FieldFiller(T instance) {
        this.instance = instance;
        setters = getAllSetters();
    }

    @SneakyThrows
    public void fill() {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field: fields){
            Method setter = getSetterIfExists(field);
            if (!hasValue(field) && setter != null){
                ValueGetter valueGetter = new ValueGetter(field);
                Object value = valueGetter.generateValueOfType();
                setter.invoke(instance, value);
            }
        }
    }

    private Method getSetterIfExists(Field field) {
        return setters.stream()
                .filter
                (method -> method.getName().substring(4).equals(field.getName().substring(1)))
                .findFirst()
                .orElse(null);
    }

    private Set<Method> getAllSetters() {
        return ReflectionUtils.getAllMethods(instance.getClass(),
                ReflectionUtils.withModifier(Modifier.PUBLIC),
                ReflectionUtils.withPrefix("set"));
    }

    @SneakyThrows
    private boolean hasValue(Field field) {
        field.trySetAccessible();
        Object value = field.get(instance);
        return value != null && !isCollection(value.getClass()) && !isMap(value.getClass());
    }

    private boolean isCollection(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    private boolean isMap(Class<?> clazz) {
        return Map.class.isAssignableFrom(clazz);
    }
}
