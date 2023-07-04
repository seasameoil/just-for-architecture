package com.example.architecture.model.network;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("unchecked")
public class Header<T> {

    private LocalDateTime transaction_time;
    private String status;
    private String description;

    private T data;

    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .transaction_time(LocalDateTime.now())
                .status("OK")
                .description("From MemberApi")
                .build();
    }

    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder()
                .transaction_time(LocalDateTime.now())
                .status("DATA-OK")
                .description("From MemberApi")
                .build();
    }

    public static <T> Header<T> ERROR() {
        return (Header<T>) Header.builder()
                .transaction_time(LocalDateTime.now())
                .status("ERROR")
                .description("From MemberApi")
                .build();
    }
}
