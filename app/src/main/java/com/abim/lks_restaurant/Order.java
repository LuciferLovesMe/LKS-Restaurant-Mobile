package com.abim.lks_restaurant;

public class Order {
    private int qty, price, total, tableNum;
    private String menu, status, paymentStatus;

    public Order(int qty, int price, int total, String menu, String status, String paymentStatus, int tableNum) {
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.menu = menu;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.tableNum = tableNum;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return total;
    }

    public String getMenu() {
        return menu;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public int getTableNum() {
        return tableNum;
    }
}
