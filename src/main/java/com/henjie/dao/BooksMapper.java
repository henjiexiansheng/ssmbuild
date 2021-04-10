package com.henjie.dao;

import com.henjie.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BooksMapper {
    //增加一本书
    int addBooks(Books books);

    //删除一本书
    int deleteBooksByID(@Param("bookID") int id);

    //更新一本书
    int updateBooks(Books books);

    //根据BookID查询一本书
    Books queryBooksByID(@Param("bookID") int id);

    //查询全本的书
    List<Books> queryAllBooks();

    //搜索一本书
    Books searchBooks(@Param("bookName") String bookName);
}
