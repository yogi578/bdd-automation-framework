#Author: Yogesh Padekar
Feature: Book Hotels through ClearTrip

  Background: 
    Given User navigates to cleartrip search hotels page "https://www.cleartrip.com/hotels"

@HotelBooking
  Scenario: Book hotel on cleartrip site
     Enter hotel search criteria
    And User enters location as "Goa"
    And User enters check in date as "20/06/2023"
    And User enters check out date as "25/06/2023"
    And User enters rooms and guest as  "1 Room, 2 Adults"
    When User clicks on Search hotels button
    
    # Enter search criteria
   	Then User enters price range from "60000" to "150000" in filter criteria
    
    #Hotel class  e.g. 5star , 4star , 3star , 2star
   And User selects hotel class as "5Star"
   
     #Hotel class  e.g. 5star , 4star , 3star , 2star
   And User selects hotel class as "4Star"
    
    #Trip advisor rating e.g. 4.5 , 4 , 3.5 , 3
    #And User selects tripadvisor rating as "4.5"
   
    # Select Hotel
    Then User selects hotel "Baale Resort Goa"
#
     # Enter room criteria
     And User verifies hotel name "Baale Resort Goa"
    And User clicks on Select room button
    And User clicks on Book room button for desired room as per criteria "Room with Breakfast" 

    #
    #Add contact details
    And User enters mobile number as "9860321816"
    And User enters email as "yog.padekar07@gmail.com"
    #
    # Add customer details
   And User select title as  "Mr"
   And User enters firstname as "yogesh"
    And User enters lastname as "padekar"
    And User clicks on Continue to payment  room button
    #
    # User will do the payment and booking is confirmed
