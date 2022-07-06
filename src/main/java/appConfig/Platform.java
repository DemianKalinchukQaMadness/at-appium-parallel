package appConfig;

import lombok.Getter;

@Getter
public enum Platform {
    IOS("ios"),
    ANDROID("android");

    private final String platform;

    Platform(String platformName) {
        this.platform = platformName;
    }

    public static boolean isIOS(String value) {
        return Platform.valueOf(value.toUpperCase()).equals(IOS);
    }

    public static boolean isAndroid(String value) {
        return Platform.valueOf(value.toUpperCase()).equals(ANDROID);
    }
}
