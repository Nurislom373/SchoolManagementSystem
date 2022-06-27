package org.khasanof.authservice.response.tokens;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tokens {
    private String access_token;
    private String refresh_token;
}
