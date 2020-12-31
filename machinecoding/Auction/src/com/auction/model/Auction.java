package com.auction.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Auction {
    Integer id;
    Item item;
    List<Buyer> buyers;
    Seller seller;
    Map<Integer, Integer> bids;
    Integer minBid;
    Integer maxBid;
    Integer participationCost;

    public Auction(Integer id, Integer  itemId, Seller seller, Integer minBid, Integer maxBid, Integer participationCost) {
        this.id = id;
        //this.buyers = buyers;
        this.seller = seller;
        this.minBid = minBid;
        this.maxBid = maxBid;
        this.participationCost = participationCost;
        bids = new HashMap<Integer, Integer>();
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

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Map<Integer, Integer> getBids() {
        return bids;
    }

    public void setBids(Map<Integer, Integer> bids) {
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
}
