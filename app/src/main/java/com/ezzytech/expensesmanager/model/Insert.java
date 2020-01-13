package com.ezzytech.expensesmanager.model;

public class Insert {
    private int id;
    private int image;
    private String amount;
    private String note;
    private long date;
    private String time;
    private String spinnerCategory;
    private String spinnerAmountType;

    public Insert(int id, int image, String amount, String note, long date, String time, String spinnerCategory, String spinnerAmountType) {
        this.id = id;
        this.image = image;
        this.amount = amount;
        this.note = note;
        this.date = date;
        this.time = time;
        this.spinnerCategory = spinnerCategory;
        this.spinnerAmountType = spinnerAmountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpinnerCategory() {
        return spinnerCategory;
    }

    public void setSpinnerCategory(String spinnerCategory) {
        this.spinnerCategory = spinnerCategory;
    }

    public String getSpinnerAmountType() {
        return spinnerAmountType;
    }

    public void setSpinnerAmountType(String spinnerAmountType) {
        this.spinnerAmountType = spinnerAmountType;
    }

    @Override
    public String toString() {
        return "Insert{" +
                "id=" + id +
                ", image=" + image +
                ", amount='" + amount + '\'' +
                ", note='" + note + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", spinnerCategory='" + spinnerCategory + '\'' +
                ", spinnerAmountType='" + spinnerAmountType + '\'' +
                '}';
    }
}