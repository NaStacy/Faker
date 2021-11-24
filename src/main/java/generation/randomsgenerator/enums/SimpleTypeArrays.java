package generation.randomsgenerator.enums;

import generation.randomsgenerator.interfaces.Value;
import generation.randomsgenerator.valuesgeneration.RandomValueGenerator;

import java.util.Calendar;

public enum SimpleTypeArrays implements Value {
    BOOLEANARR {
        @Override
        public Boolean[] get() {
            Boolean[] arr = new Boolean[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomBoolean();
            }
            return arr;
        }
    },
    NUMBERARR {
        @Override
        public Number[] get() {
            Number[] arr = new Number[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomNumber();
            }
            return arr;
        }
    },
    BYTEARR {
        @Override
        public byte[] get() {
            byte[] arr = new byte[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomByte();
            }
            return arr;
        }
    },
    CHARACTERARR {
        @Override
        public Character[] get() {
            Character[] arr = new Character[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomCharacter();
            }
            return arr;
        }
    },
    STRINGARR {
        @Override
        public String[] get() {
            String[] arr = new String[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomString();
            }
            return arr;
        }
    },
    DATEARR{
        @Override
        public Calendar[] get() {
            Calendar[] arr = new Calendar[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = RandomValueGenerator.generateRandomDate();
            }
            return arr;
        }
    }
}

