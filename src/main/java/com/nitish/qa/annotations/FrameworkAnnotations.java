package com.nitish.qa.annotations;

import com.nitish.qa.enums.CategoryType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FrameworkAnnotations {

    public String[] authors() default {"NO_NAME_MENTIONED"};
    public CategoryType[] categories() default {CategoryType.ALL};

}
