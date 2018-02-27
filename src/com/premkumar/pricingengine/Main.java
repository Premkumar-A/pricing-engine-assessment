package com.premkumar.pricingengine;

import com.premkumar.pricingengine.model.CompetitorProduct;
import com.premkumar.pricingengine.model.Product;
import com.premkumar.pricingengine.utils.PricingEngineUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Getting Input
        // Can also be moved to Separate Utils Function
        System.out.println("Enter No. Of Products");
        Scanner input1 = new Scanner(System.in);
        int noOfProducts = input1.nextInt();

        ArrayList<Product> productArrayList = new ArrayList<Product>();
        ArrayList<CompetitorProduct> competitorProductArrayList = new ArrayList<CompetitorProduct>();

        for(int i = 1; i <= noOfProducts; i++) {
            System.out.println("Enter Products Supply and Demand Parameters");

            Product product = new Product();

            System.out.println("Enter Product Name");
            product.setProductName(new Scanner(System.in).next());

            System.out.println("Enter Product Supply, Enter 'H' or 'L'");
            product.setSupply(new Scanner(System.in).next());

            System.out.println("Enter Product Demand, Enter 'H' or 'L'");
            product.setDemand(new Scanner(System.in).next());

            productArrayList.add(product);
        }

        System.out.println("Enter No. Of Surveyed Prices");
        Scanner input2 = new Scanner(System.in);
        int noOfCompetitorProducts = input2.nextInt();

        for(int j = 1; j <= noOfCompetitorProducts; j++) {

            System.out.println("Enter Competitor  Prices");

            CompetitorProduct competitorProduct = new CompetitorProduct();

            System.out.println("Enter Competitor Product Name");
            competitorProduct.setProductName(new Scanner(System.in).next());

            System.out.println("Enter Competitor Name");
            competitorProduct.setCompetitorName(new Scanner(System.in).next());

            System.out.println("Enter Competitor Price");
            competitorProduct.setPrice(new Scanner(System.in).nextFloat());

            competitorProductArrayList.add(competitorProduct);
        }

        // Alternate approach using Java 8 Streams
        productArrayList.forEach((product) -> {
            int count = 0;
            float totalPrice = 0;
            for(CompetitorProduct competitorProduct : competitorProductArrayList) {
                if (product.getProductName().toLowerCase().equals(competitorProduct.getProductName().toLowerCase())) {
                    totalPrice = totalPrice + competitorProduct.getPrice();
                    ++count;
                }
            }
            product.setChoosenPrice(totalPrice / count);
            // Using Utils to Print the Output
            PricingEngineUtils.setFinalPriceAndPrint(product, totalPrice / count);

        });
    }

}
