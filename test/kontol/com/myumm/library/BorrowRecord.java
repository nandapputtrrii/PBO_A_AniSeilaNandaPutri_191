package com.myumm.library.model;

public class BorrowRecord {
    private String bookId;
    private String bookTitle;
    private String borrowDate;
    private String dueDate;
    private String status;

    public BorrowRecord(String bookId, String bookTitle, String borrowDate, String dueDate, String status) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}