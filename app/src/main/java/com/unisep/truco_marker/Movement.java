package com.unisep.truco_marker;

/**
 * Created by bruno on 3/1/15.
 */
public class Movement {
    private int id;
    private String quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity;
    }
}
