package com.example.homework3;

import android.widget.EditText;

import java.io.Serializable;

public class Card implements Serializable {
    private EditText name;
    private EditText category;
    private EditText discount;

    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public EditText getCategory() {
        return category;
    }

    public void setCategory(EditText category) {
        this.category = category;
    }

    public EditText getDiscount() {
        return discount;
    }

    public void setDiscount(EditText discount) {
        this.discount = discount;
    }
}
