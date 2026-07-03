package model;

public class ValidationResult {

    /**
     * 是否驗證成功
     */
    private final boolean success;

    /**
     * 提示訊息
     */
    private final String message;

    public ValidationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    
    public static ValidationResult success() {

        return new ValidationResult(true, "");

    }

    public static ValidationResult fail(String message) {

        return new ValidationResult(false, message);

    }

}