package org.khasanof.authservice.enums.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("Active"),
    NO_ACTIVE("No Active"),
    BLOCK("Block");
    private final String value;
}
