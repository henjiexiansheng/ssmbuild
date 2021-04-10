package com.henjie.service;

import com.henjie.pojo.Books;

import java.util.List;

public interface BooksService {
    //增加一本书
    int addBooks(Books books);

    //删除一本书
    int deleteBooksByID(int id);

    //更新一本书
    int updateBooks(Books books);

    //根据BookID查询一本书
    Books queryBooksByID(int id);

    //查询全本的书
    List<Books> queryAllBooks();

    //搜索一本书
    Books searchBooks(String bookname);
}
