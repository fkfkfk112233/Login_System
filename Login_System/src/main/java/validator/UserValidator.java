package validator;

import java.util.regex.Pattern;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.ValidationResult;

public class UserValidator {

    private final UserDao userDao = new UserDaoImpl();

    //========================
    // Regular Expression
    //========================

    // 中文、英文、空白
    private static final String NAME_REGEX =
            "^[\\u4e00-\\u9fa5A-Za-z\\s]+$";

    // 英文開頭，可英文數字底線
    private static final String ACCOUNT_REGEX =
            "^[A-Za-z][A-Za-z0-9_]*$";

    
    // 至少一英文、一數字、一特殊符號
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&]).+$";
    
    
    //驗證姓名
    public ValidationResult validateName(String name) {

        ValidationResult result;

        result = checkRequired(name, "請輸入姓名");
        if (!result.isSuccess()) return result;

//        result = checkLength(name, 2, 20, "姓名");
//        if (!result.isSuccess()) return result;

        result = checkRegex(
                name,
                NAME_REGEX,
                "姓名只能輸入中文、英文");

        if (!result.isSuccess()) return result;

        return ValidationResult.success();

    }
    
    //驗證帳號
    public ValidationResult validateAccount(String account) {

        ValidationResult result;

        result = checkRequired(account, "請輸入帳號");
        if (!result.isSuccess()) return result;

//        result = checkLength(account, 4, 20, "帳號");
//        if (!result.isSuccess()) return result;

        result = checkRegex(
                account,
                ACCOUNT_REGEX,
                "帳號格式錯誤");

        if (!result.isSuccess()) return result;

        result = checkAccountDuplicate(account);
        if (!result.isSuccess()) return result;

        return ValidationResult.success();

    }
    
    //驗證密碼
    public ValidationResult validatePassword(String password) {

        ValidationResult result;

        result = checkRequired(password, "請輸入密碼");
        if (!result.isSuccess()) return result;

//        result = checkLength(password, 8, 20, "密碼");
//        if (!result.isSuccess()) return result;

        result = checkRegex(
                password,
                PASSWORD_REGEX,
                "密碼需包含英文、數字及特殊符號");

        if (!result.isSuccess()) return result;

        return ValidationResult.success();

    }
    
    //驗證確認密碼
    public ValidationResult validateConfirmPassword(
            String password,
            String confirmPassword) {

        return checkEquals(
                password,
                confirmPassword,
                "密碼不一致");

    }
    
    //檢查是否為空
    private ValidationResult checkRequired(
            String value,
            String message) {

        if (value == null || value.trim().isEmpty()) {

            return ValidationResult.fail(message);

        }

        return ValidationResult.success();

    }
    
    //檢查長度
    private ValidationResult checkLength(
            String value,
            int min,
            int max,
            String fieldName) {

        if (value.length() < min || value.length() > max) {

            return ValidationResult.fail(
                    fieldName +
                    "長度需介於" +
                    min +
                    "~" +
                    max +
                    "字");

        }

        return ValidationResult.success();

    }
    
    private ValidationResult checkRegex(
            String value,
            String regex,
            String message) {

        if (!Pattern.matches(regex, value)) {

            return ValidationResult.fail(message);

        }

        return ValidationResult.success();

    }
    
    //檢查兩次密碼是否一致
    private ValidationResult checkEquals(
            String value1,
            String value2,
            String message) {

        if (!value1.equals(value2)) {

            return ValidationResult.fail(message);

        }

        return ValidationResult.success();

    }
    
    //檢查帳號是否存在
    private ValidationResult checkAccountDuplicate(
            String account) {

        if (userDao.selectByAccount(account) != null) {

            return ValidationResult.fail("帳號已存在");

        }

        return ValidationResult.success();

    }
    


}