package com.example.comento.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BoardDTO {
        private Long bno;
        private String name;
        private String title;
        private String context;
        private LocalDate createdDate;
        private LocalDate modifiedDate;
        private Long views;
}
