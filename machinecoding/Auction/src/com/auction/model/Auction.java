package com.auction.model;

import java.util.List;
import java.util.Map;

public class Auction {
    Integer id;
    List<Buyer> buyers;
    Seller seller;
    Map<Buyer, Integer> bids;
    Integer minBid;
    Integer maxBid;
    Integer participationCost;

    public Auction(Integer id, List<Buyer> buyers, Seller seller, Integer minBid, Integer maxBid, Integer participationCost) {
        this.id = id;
        this.buyers = buyers;
        this.seller = seller;
        this.minBid = minBid;
        this.maxBid = maxBid;
        this.participationCost = participationCost;
    }



}
