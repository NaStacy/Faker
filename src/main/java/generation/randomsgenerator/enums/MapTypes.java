package generation.randomsgenerator.enums;

import generation.dtogenerator.Faker;
import generation.randomsgenerator.interfaces.ComplexTypeValue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.TreeMap;

public enum MapTypes implements ComplexTypeValue {
    HASHMAP{
        private HashMap map;
        @Override
        public HashMap get() {
            return (map == null) ? new HashMap() : map;
        }

        @Override
        public void set(Field field) {
            Class<?>[] types = getGenericTypesOfMap(field);
            Faker faker = new Faker();
            map = new HashMap();
            for (int i = 0; i < 3; i++) {
                Object key = faker.create(types[0]);
                Object value = faker.create(types[1]);
                map.put(key, value);
            }
        }
    },
    TREEMAP{
        private TreeMap map;
        @Override
        public TreeMap get() {
            return (map == null) ? new TreeMap() : map;
        }

        @Override
        public void set(Field field) {
            Class<?>[] types = getGenericTypesOfMap(field);
            map = new TreeMap();
            Faker faker = new Faker();
            for (int i = 0; i < 3; i++) {
                Object key = faker.create(types[0]);
                Object value = faker.create(types[1]);
                map.put(key, value);
            }
        }
    }
}
