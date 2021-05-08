package kiryakova.cars.common;

public final class ConstantsDefinition {

    public final static class BindingModelConstants {
        public static final String NOT_NULL= "Не може да бъде null !";
        public static final String NOT_EMPTY= "Не може да бъде празно !";
        public static final String NAME_IS_NOT_CORRECT = "Името трябва да бъде от 2 до 25 символа !";
        public static final String VALUE_SHOULD_BE_POSITIVE = "Стойността трябва да е положителна !";
        public static final String COLOR_IS_NOT_CORRECT = "Цветът трябва да е от 3 до 12 символа !";
        public static final String REG_NUMBER_IS_NOT_CORRECT = "Некоректен регистрационен номер !";
        public static final String VALUE_SHOULD_BE_EQUAL_OR_LESS_THAN = "Стойността трябва да е равна или по-малка от 9000 !";
    }

    public final static class BrandConstants {
        public static final String UNSUCCESSFUL_SAVED_BRAND = "Неуспешно създаване на марка %s !";
        public static final String NO_BRAND_WITH_NAME = "Не е намерена марка %s !";
        public static final String UNSUCCESSFUL_DELETE_BRAND = "Неуспешно изтриване на марка %s !";
        public static final String NO_SUCH_BRAND = "Няма такава марка !";
        public static final String BRAND_ALREADY_EXISTS = "Вече има марка %s !";
        public static final String BRAND_SAVE_ERROR = "Грешка при запис на марка !";
        public static final String BRAND_DELETE_ERROR = "Грешка при изтриване на марка !";
    }

    public final static class ModelConstants {
        public static final String UNSUCCESSFUL_SAVED_MODEL = "Неуспешно създаване на модел %s !";
        public static final String NO_MODEL_WITH_NAME = "Не е намерен модел %s !";
        public static final String UNSUCCESSFUL_DELETE_MODEL = "Неуспешно изтриване на модел %s !";
        public static final String NO_SUCH_MODEL = "Няма такъв модел !";
        public static final String MODEL_ALREADY_EXISTS = "Вече има модел %s !";
        public static final String MODEL_SAVE_ERROR = "Грешка при запис на модел !";
        public static final String MODEL_DELETE_ERROR = "Грешка при изтриване на модел !";
    }

    public final static class OwnerConstants {
        public static final String UNSUCCESSFUL_SAVED_OWNER = "Неуспешно създаване на собственик с ЕГН %s !";
        public static final String NO_OWNER_WITH_EGN = "Не е намерен собственик с ЕГН %s !";
        public static final String UNSUCCESSFUL_DELETE_OWNER = "Неуспешно изтриване на собственик с ЕГН %s !";
        public static final String NO_SUCH_OWNER = "Няма такъв собственик !";
        public static final String OWNER_ALREADY_EXISTS = "Вече има собственик с ЕГН %s !";
        public static final String OWNER_SAVE_ERROR = "Грешка при запис на собственик !";
        public static final String OWNER_DELETE_ERROR = "Грешка при изтриване на собственик !";
    }

    public final static class CarConstants {
        public static final String UNSUCCESSFUL_SAVED_CAR = "Неуспешно създаване на кола с рег. номер %s !";
        public static final String UNSUCCESSFUL_UPDATE_CAR = "Неуспешно редактиране на кола с рег. номер %s !";
        public static final String NO_CAR_WITH_REG_NUMBER = "Не е намерена кола с рег. номер %s !";
        public static final String UNSUCCESSFUL_DELETE_CAR = "Неуспешно изтриване на кола с рег. номер %s !";
        public static final String NO_SUCH_CAR = "Няма такъва кола !";
        public static final String CAR_ALREADY_EXISTS = "Вече има кола с рег. номер %s !";
        public static final String CAR_SAVE_ERROR = "Грешка при запис на кола !";
        public static final String CAR_DELETE_ERROR = "Грешка при изтриване на кола !";
    }

}
