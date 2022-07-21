package org.khasanof.classroomservice.utils;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class BaseUtils {
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;

    public static boolean hasField(final Class<?> clazz, final String fieldName) {
        final List<Field> fields = new ArrayList<>();
        Collections.addAll(fields, clazz.getDeclaredFields());
        return fields.stream().map(Field::getName).anyMatch(f -> f.equalsIgnoreCase(fieldName));
    }

    public static boolean fieldGetType(final Class<?> clazz, final String fieldName, String value) {
        final List<Field> fields = new ArrayList<>();
        Collections.addAll(fields, clazz.getDeclaredFields());
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return equalsValue(field.getType().getSimpleName(), value);
            }
        }
        return false;
    }

    private static boolean equalsValue(String key, String value) {
        return key.equalsIgnoreCase(value);
    }


}
