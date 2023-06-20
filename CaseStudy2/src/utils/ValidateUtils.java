package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    private static final String REGEX_NAME = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
    private static final String REGEX_PRICE = "^[0-9]{6,19}$";
    private static final String REGEX_AGE = "^[0-9]{2}$";
    private static final String REGEX_PHONE = "^[0-9]{10}$";
    private static final String REGEX_ADDRESS = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
    private static final String REGEX_QUANTITY = "^[0-9]{1,50}$";
    private static final String REGEX_DESCRIBE = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
    private static final String REGEX_TIMESTART = "^[0-9]{1,2}+[-]+[0-9]{1,2}+[-][0-9]{4}$";
    private static final String REGEX_SALARY = "^[0-9]{6,19}$";
    private static final String REGEX_TIMESTARTT = "^[0-9]{1,2}+[:]+[0-9]{1,2}$";
    private static final String REGEX_TIME = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";

    public static boolean isValidCustomerName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }

    public static boolean isValidCustomerAge(String age) {
        return Pattern.matches(REGEX_AGE, age);
    }

    public static boolean isValidCustomerPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }

    public static boolean isValidCustomerAddress(String address) {
        return Pattern.matches(REGEX_ADDRESS, address);
    }

    public static boolean isValidGymPackagesName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }

    public static boolean isValidGymPackagesPrice(String price) {
        return Pattern.matches(REGEX_PRICE, price);
    }

    public static boolean isValidProductName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }

    public static boolean isValidProductQuantily(String quantily) {
        return Pattern.matches(REGEX_QUANTITY, quantily);
    }

    public static boolean isValidProductDescribe(String describe) {
        return Pattern.matches(REGEX_DESCRIBE, describe);
    }

    public static boolean isValidStaffName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }

    public static boolean isValidStaffPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }

    public static boolean isValidStaffAddress(String address) {
        return Pattern.matches(REGEX_ADDRESS, address);
    }

    public static boolean isValidStaffTimeStart(String timeStart) {
        return Pattern.matches(REGEX_TIMESTART, timeStart);
    }

    public static boolean isValidStaffSalary(String salary) {
        return Pattern.matches(REGEX_SALARY, salary);
    }

    public static boolean isValidPtTimeStartt(String timeStartt) {
        return Pattern.matches(REGEX_TIMESTARTT, timeStartt);
    }

    public static boolean isValidTime(String time) {
        return Pattern.matches(REGEX_TIME, time);
    }
}

