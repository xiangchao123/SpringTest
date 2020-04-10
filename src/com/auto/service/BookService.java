package com.auto.service;

import com.auto.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiangchao on 2020/4/10.
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public void save(){
        System.out.println("bookservice正在调用dao帮你保存图书。。。");
        bookDao.saveBook();
    }
}
