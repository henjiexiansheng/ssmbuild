package com.henjie.service;


import com.henjie.dao.BooksMapper;
import com.henjie.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service    //注册为bean
public class BooksServiceImpl implements BooksService{
    //Service层调用DAO层
    @Autowired  //利用set实现自动注入
    private BooksMapper booksMapper;

    //设置set方法，spring便可进行DL的set注入，进行托管。
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int addBooks(Books books) {
        return booksMapper.addBooks(books);
    }

    public int deleteBooksByID(int id) {
        return booksMapper.deleteBooksByID(id);
    }

    public int updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }

    public Books queryBooksByID(int id) {
        return booksMapper.queryBooksByID(id);
    }

    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    public Books searchBooks(String bookname) {
        return booksMapper.searchBooks(bookname);
    }
}
