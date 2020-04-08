package com.xc;

/**
 * Created by xiangchao on 2020/4/6.
 */
public class Book {
    private String author;
    private String bookName;
    public void myInit(){
        System.out.println("这是图书的初始化方法。。。");
    }
    public void myDestory(){
        System.out.println("这是图书的销毁方法。。。");
    }
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
