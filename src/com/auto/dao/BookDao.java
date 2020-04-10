package com.auto.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by xiangchao on 2020/4/10.
 * id 就是默认类名首字母小写
 */
//@Repository("bookdaohaha")
//@Scope(value = "prototype")
@Repository
public class BookDao {
    public void saveBook(){
        System.out.println("图书已经保存。。。");
    }
}
