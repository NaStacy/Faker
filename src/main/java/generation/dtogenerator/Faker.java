package generation.dtogenerator;

import generation.dtogenerator.utils.FieldFiller;
import generation.dtogenerator.utils.InstanceCreator;

public class Faker<T>{

    public T create(Class<T> clazz){
        InstanceCreator<T> instanceCreator = new InstanceCreator<>(clazz);
        T instance = instanceCreator.create();
        FieldFiller<T> fieldFiller = new FieldFiller<T>(instance);
        fieldFiller.fill();
        return instance;
    }
}
