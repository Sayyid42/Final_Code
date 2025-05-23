public class MovieRental {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Sayyid Safaoui");
        Customer customer2 = new Customer("Test Customer");
        Customer customer3 = new Customer("Third Customer");
        Customer customer4 = new Customer("tenOff Customer");
        
        Movie movie1 = new Movie("Independence Day");
        Movie movie2 = new Movie("Toy Story");
        Movie movie3 = new Movie("The Godfather");
        Movie movie4 = new Movie("Inside Out");

        // Rental Price Startegies
        NewMovieRentalStrategy nMovieStrategy = new NewMovieRentalStrategy();
        ChildrenMovieRentalStrategy childrenMovieStrategy = new ChildrenMovieRentalStrategy();
        RegularMovieRentalStrategy regMovieStrategy = new RegularMovieRentalStrategy();
        // Purchase Price Startegies
        NewMoviePurchaseStrategy nMoviePurchaseStrategy = new NewMoviePurchaseStrategy();
        ChildrenMoviePurchaseStrategy childrenMoviePurchaseStrategy = new ChildrenMoviePurchaseStrategy();
        RegularMoviePurchaseStrategy regMoviePurchaseStrategy = new RegularMoviePurchaseStrategy();
        // Frequent Points Strategy
        // Renters
        NewRenterPointsStrategy new_frp_Strategy = new NewRenterPointsStrategy();
        RegularRenterPointsStrategy reg_frp_Strategy = new RegularRenterPointsStrategy();
        // Purchase
        NewPurchasePointsStrategy new_fpp_Strategy = new NewPurchasePointsStrategy();
        RegularPurchasePointsStrategy reg_fpp_Strategy = new RegularPurchasePointsStrategy();

        // Create Transaction
        // Trans 1:
        Transaction trans1 = new Transaction();
        trans1.addTransactionItem(new Rental(movie1, 3, nMovieStrategy, new_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie1, 3, nMovieStrategy, new_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie1, 3, nMovieStrategy, new_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie1, 3, nMovieStrategy, new_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie2, 5, childrenMovieStrategy, reg_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie3, 2, regMovieStrategy, reg_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie3, 2, regMovieStrategy, reg_frp_Strategy));
        trans1.addTransactionItem(new Rental(movie1, 17, nMovieStrategy, new_frp_Strategy));
        trans1.addTransactionItem(new Purchase(movie2, childrenMoviePurchaseStrategy, reg_fpp_Strategy));
        // Trans 2:(Enough FRP to Purchase free movie)
        Transaction trans2 = new Transaction();
        trans2.addTransactionItem(new Rental(movie3, 2, regMovieStrategy, reg_frp_Strategy));
        trans2.addTransactionItem(new Purchase(movie1, nMoviePurchaseStrategy, new_fpp_Strategy));
        trans2.addTransactionItem(new Purchase(movie2, childrenMoviePurchaseStrategy, reg_fpp_Strategy));
        trans2.addTransactionItem(new Purchase(movie4, regMoviePurchaseStrategy, reg_fpp_Strategy));
        // Trans 3:  (Note Enough FRP to Purchase free movie)
        Transaction trans3 = new Transaction();
        trans3.addTransactionItem(new Purchase(movie1, nMoviePurchaseStrategy, new_fpp_Strategy));
        // Trans 4: ($10 Off of Order Over $50)
        Transaction trans4 = new Transaction();
        trans4.addTransactionItem(new Purchase(movie1, nMoviePurchaseStrategy, new_fpp_Strategy));
        trans4.addTransactionItem(new Purchase(movie2, childrenMoviePurchaseStrategy, reg_fpp_Strategy));
        trans4.addTransactionItem(new Purchase(movie4, regMoviePurchaseStrategy, reg_fpp_Strategy));

        // Add Transactions
        customer1.addTransaction(new fiftyPercDisc(trans1));
        customer2.addTransaction(new fpPurchaseRedemptionDisc(trans2, customer2));
        customer3.addTransaction(new fpPurchaseRedemptionDisc(trans3, customer3));
        customer4.addTransaction(new tenOffDisc(trans4));
        
        
        // Print the transactions
        XmlPrint.printXMLStatement(customer1);
        System.out.println("\n\n");
        XmlPrint.printXMLStatement(customer2);
        System.out.println("\n\n");
        XmlPrint.printXMLStatement(customer3);
        System.out.println("\n\n");
        XmlPrint.printXMLStatement(customer4);
    }
}