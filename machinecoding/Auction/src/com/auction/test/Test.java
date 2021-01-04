package com.auction.test;

import com.auction.dao.AuctionDao;
import com.auction.model.*;
import com.auction.service.AuctionService;

public class Test {

    AuctionService auctionService;

    User buyer1;

    User buyer2 ;
    User buyer3 ;
    User buyer4  ;

    Item item1 ;
    User seller1 ;
    User seller2 ;

    @org.junit.Before
    public void setup(){
        auctionService = new AuctionService();
        AuctionDao auctionDao = new AuctionDao();
        auctionService.setAuctionDao(auctionDao);
        item1 = new Item(1, "item1");
        seller1 = new User(1, "user1");
        seller2 = new User(2, "user1");
        //Seller seller3 = new Seller(3, "user1", "address1");
        //Seller seller4 = new Seller(4, "user1", "address1");
        auctionDao.createItem(item1);
        auctionDao.createUser(seller1);
        auctionDao.createUser(seller2);

        buyer1 = new User(5, "user5");

        buyer2 = new User(6, "user6");
        buyer3 = new User(7, "user7");
        buyer4 = new User(8, "user8");

        auctionDao.createUser(buyer1);
        auctionDao.createUser(buyer2);
        auctionDao.createUser(buyer3);
        auctionDao.createUser(buyer4);
    }
    @org.junit.Test
    public void testAuction() {

        try{
            Auction auction = auctionService.createAuction(1, item1, seller1, 10, 50, 1);
            auctionService.addBuyer(auction,buyer1);

            auctionService.addBuyer(auction,buyer2);
            auctionService.addBuyer(auction,buyer3);
            auctionService.addBuyer(auction,buyer4);


            auctionService.addUpdateBid( buyer1, auction, 17);
            auctionService.addUpdateBid( buyer2, auction, 15);
            auctionService.addUpdateBid( buyer2, auction, 19);
            auctionService.addUpdateBid( buyer4, auction, 19);

            Bid res = auctionService.closeAuction(auction);
            if(res == null){
                System.out.println("Auction has no winner");

            }
            auctionService.getProfit(auction);
            System.out.println("Auction profit = "+auction.getProfit());
            assert(res.getBuyerId() == 5);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }

    @org.junit.Test
    public void testAuction2() {

        try{
            Auction auction = auctionService.createAuction(1, item1, seller2, 5, 20, 2);
            auctionService.addBuyer(auction,buyer1);

            auctionService.addBuyer(auction,buyer2);
            auctionService.addBuyer(auction,buyer3);
            auctionService.addBuyer(auction,buyer4);


           try{
               auctionService.addUpdateBid( buyer3, auction, 25);
           }catch (Exception ex){
               System.out.println("Bid amount greater that maxbid amount for this auction, Cannot add bid");
           }
            auctionService.addUpdateBid( buyer2, auction, 5);
            auctionService.withdraw(auction, buyer2);

            Bid res = auctionService.closeAuction(auction);
            if(res == null){
                System.out.println("Auction has no winner");

            }
            auctionService.getProfit(auction);
            System.out.println("Auction profit = "+auction.getProfit());
            assert(res.getBuyerId() == 5);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}

