package com.example.bank.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Pattern.List({@Pattern(
        regexp = "([0-9]{5}[-]?[0-9]{3})"
), @Pattern(
        regexp = "^(?:(?!00000-?000).)*$"
), @Pattern(
        regexp = "^(?:(?!11111-?111).)*$"
), @Pattern(
        regexp = "^(?:(?!22222-?222).)*$"
), @Pattern(
        regexp = "^(?:(?!33333-?333).)*$"
), @Pattern(
        regexp = "^(?:(?!44444-?444).)*$"
), @Pattern(
        regexp = "^(?:(?!55555-?555).)*$"
), @Pattern(
        regexp = "^(?:(?!66666-?666).)*$"
), @Pattern(
        regexp = "^(?:(?!77777-?777).)*$"
), @Pattern(
        regexp = "^(?:(?!88888-?888).)*$"
), @Pattern(
        regexp = "^(?:(?!99999-?999).)*$"
)})
@ReportAsSingleViolation
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CEP.List.class)
public @interface CEP {
    String message() default "{cep.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        CEP[] value();
    }
}
