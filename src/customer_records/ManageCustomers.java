package customer_records;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManageCustomers {

    public static void main(String[] args) throws Exception {

        //part A - read the file line by line and print the file content        
        File directory = new File("./");
        String region = directory.getAbsolutePath() + "//customers.txt";
        
        //create a scanner
        Scanner sc = new Scanner(new File(region));
        
        //create a Customer object
        Customer myCustomer = new Customer();
        
        //create an array to store Customer objects
        Customer[] customers = new Customer[20];

        // this will just print the header
        System.out.println(sc.nextLine());
        System.out.println();

        int i = 0;
        String st = "";

        while (sc.hasNextLine()) //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            //write data in customers array
            customers[i++] = new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
        }
        sc.close();  //closes the scanner

        //print the customer records
        System.out.println("Customer records:");
        for (Customer element : customers) {
            System.out.println(element);
        }
        
        //part B
        selectItalianCustomers(customers);
        
        //part C
        customersWithMissingCountry(customers);

    }

    //part B - select Italian customers and save in a separate file
    public static void selectItalianCustomers(Customer[] customers) throws IOException {
        //craete a new FileWriter and a new BufferedWriter to write in data
        BufferedWriter writer = new BufferedWriter(new FileWriter("Italian_customers.txt"));
        
        //write in Customer objects data if the country is "Italy" 
        for (Customer customer : customers) {
            if (customer.getCountry().equalsIgnoreCase("Italy")) {
                writer.write(customer.toString());
                writer.newLine();
            }
        }

        writer.close();
    }

    //part C - 
    public static void customersWithMissingCountry(Customer[] customers) throws IOException {
        //craete a new FileWriter and a new BufferedWriter to write in data
        BufferedWriter writer = new BufferedWriter(new FileWriter("MissingCountry.txt"));

        //write in Customer objects data if the country is null or empty 
        for (Customer customer : customers) {
            if (customer.getCountry() == null || customer.getCountry().isEmpty()) {
                writer.write(customer.toString());
                writer.newLine();
            }
        }

        writer.close();
    }
}
