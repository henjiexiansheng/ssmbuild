package com.henjie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private int bookID;     //主键identity
    private String bookName;
    private int bookCounts;
    private String detail;

}
