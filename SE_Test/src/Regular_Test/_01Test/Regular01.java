package Regular_Test._01Test;

public class Regular01 {
    public static void main(String[] args) {
//        String email = "a_bc@gmail.com.cn";
//        System.out.println(emailCheck(email));
//        String phoneNumber = "13844645781";
//        System.out.println(phoneCheck(phoneNumber));
        String password = "Yxl_0306.";
        System.out.println(passwordCheck(password));
    }
    //邮箱验证
    public static boolean emailCheck(String email) {
        String regex = "(?i)[a-z0-9._%+-]+@([a-z0-9-]+\\.)+[a-z]{2,6}";
        return email.matches(regex);
    }
    //手机号验证
    public static boolean phoneCheck(String phone) {
        String regex = "1[3-9]\\d{9}";
        return phone.matches(regex);
    }
    //密码验证
    public static boolean passwordCheck(String password) {
        String regex = "[A-Za-z0-9._!@#$%^&*]{8,}";
        return password.matches(regex);
    }
    //
}
