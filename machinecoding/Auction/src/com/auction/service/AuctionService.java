package com.auction.service;

import com.auction.data.DataStore;
import com.auction.exception.InsufficientBalanceException;
import com.auction.model.Auction;
import com.auction.model.Buyer;
import com.auction.model.Item;
import com.auction.model.Seller;

import java.util.*;

public class AuctionService {

    DataStore dataStore = new DataStore();

    public void addBuyer(int id, String name, String address){
        Buyer buyer = new Buyer(id, name, address);
        dataStore.createBuyer(buyer);
    }

    public void addSeller(int id, String name, String address){
        Seller seller = new Seller(id, name, address);
        dataStore.createSeller(seller);
    }

    public void createAuction(int id, Item item, int min, int max, int participationcCost, Seller seller ){
        Auction auction = new Auction(id, item.getId(), seller, min, max, participationcCost);
        dataStore.createAuction(auction);
    }

    public void addBuyer(int auctionId, int buyerId) throws Exception{
        if(dataStore.getBuyerById(buyerId) != null){
            if(dataStore.getUserBalance(buyerId) < dataStore.getAuctionById(auctionId).getParticipationCost()){
                throw new InsufficientBalanceException("user account doesnt not have enough amount to participate in auction");
            }
            else{
                List<Buyer> buyers = dataStore.getAuctionById(auctionId).getBuyers();
                if(buyers == null) buyers = new ArrayList<Buyer>();
                buyers.add(dataStore.getBuyerById(buyerId));
            }
        }
        else{
            throw new Exception("invalid buyer");
        }
    }

    public void addUpdateBid(int buyerId, int AuctionId, int amount){

        Auction auction = dataStore.getAuctionById(AuctionId);
        auction.getBids().put(buyerId, amount);
    }

    public Buyer closeAuction(int auctionId){

        Integer buyerId= null;
        int maxBid = Integer.MIN_VALUE;
        Auction auction = dataStore.getAuctionById(auctionId);
        Set<Integer> set = new HashSet<Integer>();
        for(Map.Entry<Integer, Integer> entry : auction.getBids().entrySet()){
            if(!set.contains(entry.getValue())){
                if(entry.getValue() > maxBid){
                    maxBid = entry.getValue();
                    buyerId = entry.getKey();
                }

            }
            else{
                if(set.)
            }

        }
    }
}
