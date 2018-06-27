import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldValidate {
    enum Status {NotEmpty, NotNull, NoNegativeDecimal, Null}

    Status status() default Status.Null;

    String message() default "";
}
