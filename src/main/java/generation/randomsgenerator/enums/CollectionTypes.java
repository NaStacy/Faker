package generation.randomsgenerator.enums;

import generation.dtogenerator.Faker;
import generation.randomsgenerator.interfaces.ComplexTypeValue;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public enum CollectionTypes implements ComplexTypeValue {
    LIST{
        private ArrayList value;
        @Override
        public ArrayList get() {
            return (value == null) ? new ArrayList() : value;
        }

        @Override
        public void set(Field field) {
            value = new ArrayList();
            Class<?> genericType = getGenericTypeOfCollection(field);
            Faker faker = new Faker();
            for (int i = 0; i < 3; i++) {
                value.add(faker.create(genericType));
            }
        }
    },
    SET{
        private HashSet value;
        @Override
        public HashSet get() {
            return (value == null) ? new HashSet() : value;
        }

        @Override
        public void set(Field field) {
            Class<?> genericType = getGenericTypeOfCollection(field);
            value = new HashSet();
            Faker faker = new Faker();
            for (int i = 0; i < 3; i++) {
                value.add(faker.create(genericType));
            }
        }
    },
    QUEUE{
        private ArrayDeque value;
        @Override
        public ArrayDeque get() {
            return (value == null) ? new ArrayDeque() : value;
        }

        @Override
        public void set(Field field) {
            value = new ArrayDeque();
            Class<?> genericType = getGenericTypeOfCollection(field);
            Faker faker = new Faker();
            for (int i = 0; i < 3; i++) {
                value.add(faker.create(genericType));
            }
        }
    }
}
