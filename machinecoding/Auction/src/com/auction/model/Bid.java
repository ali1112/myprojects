package com.auction.model;

public class Bid implements Comparable<Bid>{
    int buyerId;
    Integer bidAmount;
    boolean active;
    boolean isWinner;


    public Bid(int buyerid, Integer bidAmount) {
        this.buyerId = buyerid;
        this.bidAmount = bidAmount;
        active = true;
        isWinner = false;
    }

    public int compareTo(Bid other){
        return bidAmount - other.bidAmount;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;
        Bid bid = (Bid) o;
        return bidAmount.equals(bid.bidAmount);
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        this.isWinner = winner;
    }
}
