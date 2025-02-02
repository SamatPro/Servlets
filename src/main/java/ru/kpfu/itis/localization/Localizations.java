package ru.kpfu.itis.localization;

import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Localizations {
    @SneakyThrows
    public static Map<String, String> loadLocalization(String locale) {
        Scanner scanner = new Scanner(new File("C:\\Users\\Самат\\Desktop\\ИТИС\\Проекты\\Курсовая работа\\SpringProject\\src\\main\\resources\\messages\\messages_" + locale + ".properties"));
        Map<String, String> localeMap = new HashMap<>();

        while (scanner.hasNext()) {
            String currentValue = scanner.nextLine();
            String localeValue[] = currentValue.split("=");
            localeMap.put(localeValue[0], localeValue[1]);
        }

        return localeMap;
    }
}
