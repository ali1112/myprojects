package com.auction.dao;

import com.auction.model.Auction;
import com.auction.model.Item;
import com.auction.model.User;

import java.util.*;

public class AuctionDao {

    public Map<Integer, Item> items = new HashMap<Integer, Item>();
    public Map<Integer, User> users = new HashMap<Integer, User>();
//    Map<Integer, Buyer> buyers = new HashMap<Integer, Buyer>();
//    Map<Integer, Seller> sellers = new HashMap<Integer, Seller>();
    public Map<Integer, Auction> auctions = new HashMap<Integer, Auction>();
    public Map<Integer, Integer> userAmout = new HashMap<Integer, Integer>();
    public Map<Integer, Set<Integer>> participationsAsBuyer = new HashMap<Integer, Set<Integer>>();




    public Set<Integer> participatedAuctions(int userId){
        return participationsAsBuyer.getOrDefault(userId, new HashSet<Integer>());
    }

    public void createItem(Item item){
        items.put(item.getId(), item);
    }

    public Item getItemById(int id){
        return items.get(id);
    }

//    public void createUser(User user){
//        users.put(user.getId(), user);
//    }
//
//    public User getUserById(int id){
//        return users.get(id);
//    }

    public void createAuction(Auction auction){
        auctions.put(auction.getId(), auction);
    }

    public Auction getAuctionById(int id){
        return auctions.get(id);
    }


    public void createUser(User user){
        userAmout.put(user.getId(), 10);
        users.put(user.getId(), user);
    }

    public User getUserById(int id){
        return users.get(id);
    }

//    public void createSeller(User seller){
//        userAmout.put(seller.getId(), 10);
//        sellers.put(seller.getId(), seller);
//    }

//    public Seller getSellerById(int id){
//        return sellers.get(id);
//    }

    public int getUserBalance(int id){
        return userAmout.get(id);
    }

    public void addToUserAmount(int userId, int amount){
        int userAmmount = userAmout.get(userId);
        userAmout.put(userId, userAmmount + amount);
    }


}
