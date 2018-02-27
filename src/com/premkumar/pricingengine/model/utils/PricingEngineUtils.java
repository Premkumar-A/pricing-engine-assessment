package com.premkumar.pricingengine.model.utils;

import com.premkumar.pricingengine.model.Product;

public class PricingEngineUtils {

    private static boolean checkPromotionOrDataErrors(float averagePrice, float productPrice) {

        boolean promotionOrDataError = false;
        if(productPrice < (averagePrice - (averagePrice * 0.5)) || productPrice > (averagePrice + (averagePrice * 0.5))) {
            return true;
        }
        return promotionOrDataError;
    }

    public static void setFinalPriceAndPrint(Product product, float averagePrice) {
        boolean isPromotionOrDataErrors = checkPromotionOrDataErrors(averagePrice, product.getProductPrice());
        if((product.getSupply().toLowerCase().equals("h") && product.getDemand().toLowerCase().equals("h")) || isPromotionOrDataErrors) {
            product.setFinalPrice(product.getProductPrice());
        } else if(product.getSupply().toLowerCase().equals("l") && product.getDemand().toLowerCase().equals("l")) {
            product.setFinalPrice((float) (product.getProductPrice() + (product.getProductPrice() * 0.1)));
        } else if(product.getSupply().toLowerCase().equals("l") && product.getDemand().toLowerCase().equals("h")) {
            product.setFinalPrice((float) (product.getProductPrice() + (product.getProductPrice() * 0.05)));
        } else if(product.getSupply().toLowerCase().equals("h") && product.getDemand().toLowerCase().equals("l")) {
            product.setFinalPrice((float) (product.getProductPrice() - (product.getProductPrice() * 0.05)));
        }

        System.out.println("Product Name " + product.getProductName());
        System.out.println("Product Price " + product.getFinalPrice());
    }
}
