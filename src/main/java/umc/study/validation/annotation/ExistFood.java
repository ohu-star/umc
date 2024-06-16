package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.FoodExistValidator;

import java.lang.annotation.*;

public @interface ExistFood {
    @Documented
    @Constraint(validatedBy = FoodExistValidator.class)
    @Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExistCategories {

        String message() default "해당하는 음식 카테고리가 존재하지 않습니다.";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
