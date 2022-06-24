package org.khasanof.authservice.enums.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@ParameterObject
@RequiredArgsConstructor
public enum LoginEnums {
    STUDENT("student"),
    TEACHER("teacher"),
    PARENT("parent");
    private final String value;
}
