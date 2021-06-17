package com.exam.examPortalServer.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class JwtRequest {
    String username;
    String password;
}
