package com.auction.data;

import com.auction.model.*;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class DataStore {

    Map<Integer, Item> items = new HashMap<Integer, Item>();
    Map<Integer, User> users = new HashMap<Integer, User>();
    Map<Integer, Buyer> buyers = new HashMap<Integer, Buyer>();
    Map<Integer, Seller> sellers = new HashMap<Integer, Seller>();
    Map<Integer, Auction> auctions = new HashMap<Integer, Auction>();
    Map<Integer, Integer> userAmout = new HashMap<Integer, Integer>();


    public void createItem(Item item){
        items.put(item.getId(), item);
    }

    public Item getItemById(int id){
        return items.get(id);
    }

    public void createUser(User user){
        users.put(user.getId(), user);
    }

    public User getUserById(int id){
        return users.get(id);
    }

    public void createAuction(Auction auction){
        auctions.put(auction.getId(), auction);
    }

    public Auction getAuctionById(int id){
        return auctions.get(id);
    }


    public void createBuyer(Buyer buyer){
        userAmout.put(buyer.getId(), 10);
        buyers.put(buyer.getId(), buyer);
    }

    public Buyer getBuyerById(int id){
        return buyers.get(id);
    }

    public void createSeller(Seller seller){
        userAmout.put(seller.getId(), 10);
        sellers.put(seller.getId(), seller);
    }

    public Seller getSellerById(int id){
        return sellers.get(id);
    }

    public int getUserBalance(int id){
        return userAmout.get(id);
    }

    public void addToUserAmount(int userId, int amount){
        int userAmmount = userAmout.get(userId);
        userAmout.put(userId, userAmmount + amount);
    }


}
