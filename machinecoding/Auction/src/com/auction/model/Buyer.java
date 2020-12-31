package com.auction.model;

public class Buyer extends User{

    int totalParticipations;
    boolean isPreferredBuyer;
    public Buyer(int id, String name, String address) {
        super(id, name, address);
        totalParticipations=0;
    }
}
