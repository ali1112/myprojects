package com.auction.service;

import com.auction.dao.AuctionDao;
import com.auction.exception.AuctionException;
import com.auction.exception.InsufficientBalanceException;
import com.auction.model.*;

import java.util.*;

public class AuctionService {

    AuctionDao auctionDao;
    final Integer preferredBuyerParticipation = 2;

//    public void addBuyer(int id, String name){
//        User buyer = new User(id, name);
//        auctionDao.createUser(buyer);
//    }
//
//    public void addSeller(int id, String name, String address){
//        User seller = new User(id, name);
//        auctionDao.createUser(seller);
//    }

    public Auction createAuction(int id, Item item,  User seller, int min, int max, int participationcCost){
        Auction auction = new Auction(id, item.getId(), seller, min, max, participationcCost);
        auctionDao.createAuction(auction);
        return auction;
    }

    public void addBuyer(Auction auction, User buyer) throws Exception{
        if(auction != null){
            if(auctionDao.getUserBalance(buyer.getId()) < auctionDao.getAuctionById(auction.getId()).getParticipationCost()){
                throw new InsufficientBalanceException("user account doesnt not have enough amount to participate in auction");
            }
            else{
                List<User> buyers = auctionDao.getAuctionById(auction.getId()).getBuyers();
                if(buyers == null) buyers = new ArrayList<User>();
                buyers.add(auctionDao.getUserById(buyer.getId()));
            }
        }
        else{
            throw new Exception("aution is null");
        }
    }

    public void addUpdateBid(User user, Auction auction, int amount) throws AuctionException{
        //Auction auction = auctionDao.getAuctionById(auctionId);
        if(auction == null){
            throw new AuctionException(" Invalid auctio id");
        }
        if(amount < auction.getMinBid() || amount > auction.getMaxBid()){
            throw new AuctionException("Bid amount should be within bidding limits");
        }
        boolean bindFound = false;
        for(Bid bid : auction.getBids()){
            if(bid.getBuyerId() == user.getId()) {
                bindFound = true;
                bid.setBidAmount(amount);
                break;
            }
        }
        if(!bindFound){
            auction.getBids().add(new Bid(user.getId(), amount));
        }

    }

    public double getProfit(Auction auction) throws AuctionException{

        if(!auction.isClosed()){
            throw new AuctionException("Auction is not yet closed");
        }
        int sum=0;
        int numOfBids = 0;
        //int minBid = Integer.MAX_VALUE;
        //int maxBid = Integer.MIN_VALUE;
        int winnerBidAmount =0;
        boolean hasWinner = false;
        for(Bid bid : auction.getBids()){
            if(bid.isActive()) {
               // if(bid.getBidAmount() > maxBid) maxBid = bid.getBidAmount();
                //if(bid.getBidAmount() < minBid) minBid = bid.getBidAmount();
                numOfBids++;
                if(bid.isWinner()){
                    hasWinner = true;
                    winnerBidAmount = bid.getBidAmount();
                }

            }
        }
        numOfBids = numOfBids == 0 ? 1 : numOfBids;
        double profit =  numOfBids*0.2*auction.getParticipationCost();

        if(!hasWinner) auction.setProfit(profit);
        else auction.setProfit(profit + winnerBidAmount - (auction.getMaxBid() + auction.getMinBid())/2);
        return auction.getProfit();

    }
    public void withdraw(Auction auction, User buyer) throws AuctionException{
        boolean bidFound = false;
        for(Bid bid : auction.getBids()){
            if(bid.getBuyerId() == buyer.getId()) {
                bidFound = true;
                bid.setActive(false);
                break;
            }
        }

        if(!bidFound){
            throw new AuctionException("Bid with buyer + "+buyer.getId()+" not found");
        }

    }

    public Bid closeAuction(Auction auction) throws AuctionException{

        Integer buyerId= null;
        int maxBid = Integer.MIN_VALUE;
        //Auction Auction = auctionDao.getAuctionById(auctionId);

        List<Bid> bids = auction.getActiveBids();
        Collections.sort(bids, Collections.reverseOrder());
        if(bids.isEmpty()){
            auction.setClosed(true);
            return null;
        }
       if(bids.size() == 1) return bids.get(0);
       int i=1;
       while(i < bids.size() && bids.get(i).equals(bids.get(i-1))){
           if(auctionDao.participatedAuctions(bids.get(i-1).getBuyerId()).size() >= preferredBuyerParticipation) return bids.get(i-1);
           else if (auctionDao.participatedAuctions(bids.get(i).getBuyerId()).size() >= preferredBuyerParticipation) return bids.get(i-1);
           i++;

       }
       for(Bid bid : bids){
           updateBuyerParticipation(auctionDao.getUserById(bid.getBuyerId()), auction, true );
       }
       if(i == bids.size()){
           // all bids are equal, no winned
           return null;
       }
       else{
           auction.setClosed(true);
           bids.get(i).setWinner(true);
           return bids.get(i);
       }

    }


    public void updateBuyerParticipation(User user, Auction auction, boolean addRemove){
        Map<Integer, Set<Integer>> participationsAsBuyer = auctionDao.participationsAsBuyer;
        Set<Integer> participatedAutions =  participationsAsBuyer.getOrDefault(user.getId(), new HashSet<Integer>());
        if(!addRemove) {
            if(participatedAutions.contains(auction.getId())){
                participatedAutions.remove(auction.getId());
            }

        }
        else{
            if(!participatedAutions.contains(auction.getId()))
                participatedAutions.add(auction.getId());
        }
    }

    public void setAuctionDao(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }
}
