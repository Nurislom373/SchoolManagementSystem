package org.khasanof.authservice.enums.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@RequiredArgsConstructor
public enum LoginEnums {
    STUDENT("STUDENT"),
    TEACHER("TEACHER"),
    PARENT("PARENT");
    private final String value;

    public static boolean checkRole(String role) {
        for (LoginEnums loginEnums : values()) {
            if (loginEnums.getValue().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}
