import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : Administrator
 * @date : 2018/6/27 0027 17:16
 * @description : 检查对象属性是否为空
 */
public final class CheckObjEmptyUtil {

    private static final BigDecimal ZERO = new BigDecimal(0);

    public static String checkField(Object objOri) {
        try {
            for (Field field : objOri.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(FieldValidate.class)) {
                    field.setAccessible(true);
                    String checkResult = checkAnnotation(field, objOri);
                    if (checkResult != null) {
                        return checkResult;
                    }
                    Object object = field.get(objOri);
                    if (object instanceof List) {
                        for (Object obj : (List) object) {
                            String result = checkField(obj);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String checkAnnotation(Field field, Object object) throws Exception {
        FieldValidate checkFiledAnnotation = field.getAnnotation(FieldValidate.class);
        Object obj = field.get(object);
        if (!FieldValidate.Status.Null.equals(checkFiledAnnotation.status()) && obj == null){
            return field.getName()+":传入参数为非法，不能为空！";
        }
        switch (checkFiledAnnotation.status()) {
            case NotEmpty:
                if (obj instanceof String && ((String) obj).trim().length() < 1) {
                    return checkFiledAnnotation.message();
                }
                if (obj instanceof List && ((List) obj).size() < 1) {
                    return checkFiledAnnotation.message();
                }
                break;
            case NoNegativeDecimal:
                if (obj instanceof String) {
                    String str = (String) obj;
                    System.out.println(obj);
                    if (isNotNumber(str)) {
                        return "数据格式不对";
                    }
                    if (ZERO.compareTo(new BigDecimal(str)) > 0) {
                        return checkFiledAnnotation.message();
                    }
                }
                break;
        }
        return null;
    }

    //^(([1-9]{1}\d*)|([0]{1}))(\.(\d){2}){1}$ 强制保留小数点后两位
    private static final Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
    //金额验证
    public static boolean isNotNumber(String str) {
        // 判断小数点后2位的数字的正则表达式
        Matcher match = pattern.matcher(str);
        if (match.matches()) {
            return false;
        }
        return true;
    }
}
