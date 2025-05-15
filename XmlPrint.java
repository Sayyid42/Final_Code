import java.util.List;

public class XmlPrint {
    public static void printXMLStatement(Customer customer){
        double totalCharge = 0;
        StringBuilder statement = new StringBuilder("<customer>\n");
        statement.append("\t").append("Transaction Record for <name>" + customer.getName() + "</name>\n");
        
        for (disTransaction transaction : customer.getTransactionsList()) {
            statement.append("\t<transaction>\n");

            List<Movie> movieList = transaction.getMovie();
            String movieNames = "";
            double rentalCharge = transaction.getCharge();
            for (Movie movie : movieList){
                if (movieNames == ""){
                    movieNames = movie.getTitle();
                }
                else{
                    movieNames += ", " + movie.getTitle();
                }
            }
            statement.append("\t\t").append("<movies>"+movieNames+"</movies>")
                .append("\n\t\t").append("<charge>"+rentalCharge+"</charge>").append("\n");
                totalCharge += rentalCharge;


            statement.append("\t</transaction>\n");
        }
        
        statement.append("\tAmount owed is <amountOwed>").append(totalCharge).append("</amountOwed>\n");
        statement.append("\tYou earned <freqRenterPoints>").append(customer.getFrequentRenterPoints()).append("</freqRenterPoints> frequent renter points\n</customer>\n");
        System.out.println(statement.toString());
        return;
    }
}
