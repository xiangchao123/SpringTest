package com.auto.service;

import org.springframework.stereotype.Service;

/**
 * Created by xiangchao on 2020/4/10.
 */
@Service
public class BookServiceExt extends BookService {
    @Override
    public void save() {
        System.out.println("kuozhan...");
    }
}
