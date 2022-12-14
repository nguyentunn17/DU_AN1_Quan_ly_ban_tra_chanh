package domainmodels;

public class NhanVienLogin {

    static String tenLogin;
    static String TenCV;
    static String anhNV;

    public NhanVienLogin() {
    }

    public static String getTenLogin() {
        return tenLogin;
    }

    public static void setTenLogin(String tenLogin) {
        NhanVienLogin.tenLogin = tenLogin;
    }

    public static String getTenCV() {
        return TenCV;
    }

    public static void setTenCV(String TenCV) {
        NhanVienLogin.TenCV = TenCV;
    }

    public static String getAnhNV() {
        return anhNV;
    }

    public static void setAnhNV(String anhNV) {
        NhanVienLogin.anhNV = anhNV;
    }

}
