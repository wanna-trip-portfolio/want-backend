package com.want.want.domain.file;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;
}
