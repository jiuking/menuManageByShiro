import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldValidate {
    enum Status {NotEmpty, NotNull, NoNegativeDecimal, Null}

    //添加default 默认的值，在添加该自定义注解时，不需要强制指定一种类型。如果不指定类型报错：'status' missing though required
//    Error:(27, 13) java: 对于元素 'status', 注释 @FieldValidate 缺少默认值
    Status status() default Status.Null;

    String message() default "";
}
