package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(Code errorCode) {
        super(errorCode);
    }

    public FoodCategoryHandler(Code errorCode, String message) {
        super(errorCode, message);
    }

    public FoodCategoryHandler(Code errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public FoodCategoryHandler(Code errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
