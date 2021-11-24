package generation.randomsgenerator.enums;

import generation.randomsgenerator.interfaces.Value;
import generation.randomsgenerator.valuesgeneration.RandomValueGenerator;

import java.util.Calendar;

public enum SimpleTypes implements Value {
    NUMBER{
        @Override
        public Number get() {
            return RandomValueGenerator.generateRandomNumber();
        }
    },
    STRING{
        @Override
        public String get() {
            return RandomValueGenerator.generateRandomString();
        }
    },
    CHARACTER{
        @Override
        public Character get() {
            return RandomValueGenerator.generateRandomCharacter();
        }
    },
    BOOLEAN{
        @Override
        public Boolean get() {
            return RandomValueGenerator.generateRandomBoolean();
        }
    },
    DATE{
        @Override
        public Calendar get() {
            return RandomValueGenerator.generateRandomDate();
        }
    }
}
