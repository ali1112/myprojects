package com.auction.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Auction {
    Integer id;
    Item item;
    List<User> buyers;
    User seller;
    //Map<Integer, Integer> bids;
    List<Bid> bids;
    Integer minBid;
    Integer maxBid;
    Integer participationCost;
    boolean isClosed = false;
    double profit;

    public Auction(Integer id, Integer  itemId, User seller, Integer minBid, Integer maxBid, Integer participationCost) {
        this.id = id;
        //this.buyers = buyers;
        this.seller = seller;
        this.minBid = minBid;
        this.maxBid = maxBid;
        this.participationCost = participationCost;
        bids = new ArrayList<Bid>();
        profit=0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<User> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<User> buyers) {
        this.buyers = buyers;
    }

    public User getSeller() {
        return seller;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public List<Bid> getActiveBids() {
        List<Bid> bids = this.bids.stream()
                .filter(c -> c.active)
                .collect(Collectors.toList());
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Integer getMinBid() {
        return minBid;
    }

    public void setMinBid(Integer minBid) {
        this.minBid = minBid;
    }

    public Integer getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(Integer maxBid) {
        this.maxBid = maxBid;
    }

    public Integer getParticipationCost() {
        return participationCost;
    }

    public void setParticipationCost(Integer participationCost) {
        this.participationCost = participationCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
