package com.muhammederendemir.producer.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

    private Long id;

    private String firstName;

    private String lastName;
}
