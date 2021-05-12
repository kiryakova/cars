package kiryakova.cars.common;

public final class ConstantsDefinition {

    public final static class BindingModelConstants {
        public static final String NOT_NULL= "Cannot be null !";
        public static final String NOT_EMPTY= "Can not be empty !";
        public static final String NAME_IS_NOT_CORRECT = "The value should be 2-25 symbols !";
        public static final String VALUE_SHOULD_BE_POSITIVE = "Should be positive value !";
        public static final String COLOR_IS_NOT_CORRECT = "The value should be 3-12 symbols !";
        public static final String REG_NUMBER_IS_NOT_CORRECT = "Incorrect register number !";
        public static final String ADDRESS_IS_NOT_CORRECT = "The value should be 5-50 symbols !";
        public static final String PHONE_IS_NOT_CORRECT = "The value should be 7-14 digits !";
        public static final String VALUE_SHOULD_BE_EQUAL_OR_LESS_THAN = "The value should be equal or less than 9000 !";
    }

    public final static class BrandConstants {
        public static final String UNSUCCESSFUL_SAVED_BRAND = "Unsuccessfully creating of brand %s !";
        public static final String UNSUCCESSFUL_UPDATED_BRAND = "Unsuccessfully editing of brand %s !";
        public static final String NO_BRAND_WITH_NAME = "Not found brand %s !";
        public static final String UNSUCCESSFUL_DELETE_BRAND = "Unsuccessfully deleting of brand %s !";
        public static final String NO_SUCH_BRAND = "There is no such brand !";
        public static final String BRAND_ALREADY_EXISTS = "There is already a brand %s !";
        public static final String BRAND_SAVE_ERROR = "Error saving brand !";
        public static final String BRAND_DELETE_ERROR = "Error deleting brand !";
    }

    public final static class ModelConstants {
        public static final String UNSUCCESSFUL_SAVED_MODEL = "Unsuccessfully creating of model %s !";
        public static final String UNSUCCESSFUL_UPDATED_MODEL = "Unsuccessfully editing of model %s !";
        public static final String NO_MODEL_WITH_NAME = "Not found model %s !";
        public static final String UNSUCCESSFUL_DELETE_MODEL = "Unsuccessfully deleting of model %s !";
        public static final String NO_SUCH_MODEL = "There is no such model !";
        public static final String MODEL_ALREADY_EXISTS = "There is already a model %s !";
        public static final String MODEL_SAVE_ERROR = "Error saving model !";
        public static final String MODEL_DELETE_ERROR = "Error deleting model !";
    }

    public final static class OwnerConstants {
        public static final String UNSUCCESSFUL_SAVED_OWNER = "Unsuccessfully creating of owner with EGN %s !";
        public static final String UNSUCCESSFUL_UPDATED_OWNER = "Unsuccessfully editing of owner with EGN %s !";
        public static final String NO_OWNER_WITH_EGN = "Not found owner with EGN %s !";
        public static final String UNSUCCESSFUL_DELETE_OWNER = "Unsuccessfully deleting of owner with EGN %s !";
        public static final String NO_SUCH_OWNER = "There is no such owner !";
        public static final String OWNER_ALREADY_EXISTS = "There is already an owner with EGN %s !";
        public static final String OWNER_SAVE_ERROR = "Error saving owner !";
        public static final String OWNER_DELETE_ERROR = "Error deleting owner !";
    }

    public final static class CarConstants {
        public static final String UNSUCCESSFUL_SAVED_CAR = "Unsuccessfully creating of car with reg. number %s !";
        public static final String UNSUCCESSFUL_UPDATED_CAR = "Unsuccessfully editing of car with reg. number %s !";
        public static final String NO_CAR_WITH_REG_NUMBER = "Not found car with reg. number %s !";
        public static final String UNSUCCESSFUL_DELETE_CAR = "Unsuccessfully deleting of car with reg. number %s !";
        public static final String NO_SUCH_CAR = "There is no such car !";
        public static final String CAR_ALREADY_EXISTS = "There is already a car with reg. numbar %s !";
        public static final String CAR_SAVE_ERROR = "Error saving car !";
        public static final String CAR_DELETE_ERROR = "Error deleting car !";
    }

}
