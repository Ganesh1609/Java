package org.example.StreamCoding.StreamOnObject;

public class Transaction {
    public int amount;
    public String category;

    Transaction(String category, int amount) {
        this.amount = amount;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }
}
