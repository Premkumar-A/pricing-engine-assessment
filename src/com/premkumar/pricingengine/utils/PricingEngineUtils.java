package com.premkumar.pricingengine.utils;

import com.premkumar.pricingengine.constants.Constants;
import com.premkumar.pricingengine.model.Product;

public class PricingEngineUtils {

    private static boolean checkPromotionOrDataErrors(float averagePrice, float productPrice) {

        boolean promotionOrDataError = false;
        if((productPrice < (averagePrice * 0.5)) || (productPrice > (averagePrice * 0.5))) {
            return true;
        }
        return promotionOrDataError;
    }

    public static void setFinalPriceAndPrint(Product product, float averagePrice) {
        boolean isPromotionOrDataErrors = checkPromotionOrDataErrors(averagePrice, product.getChoosenPrice());
        //
        if((product.getSupply().toLowerCase().equals(Constants.HIGH) && product.getDemand().toLowerCase().equals(Constants.HIGH)) || isPromotionOrDataErrors) {
            product.setFinalPrice(product.getChoosenPrice());
        } else if(product.getSupply().toLowerCase().equals(Constants.LOW) && product.getDemand().toLowerCase().equals(Constants.LOW)) {
            product.setFinalPrice((float) (product.getChoosenPrice() + (product.getChoosenPrice() * 0.1)));
        } else if(product.getSupply().toLowerCase().equals(Constants.LOW) && product.getDemand().toLowerCase().equals(Constants.HIGH)) {
            product.setFinalPrice((float) (product.getChoosenPrice() + (product.getChoosenPrice() * 0.05)));
        } else if(product.getSupply().toLowerCase().equals(Constants.HIGH) && product.getDemand().toLowerCase().equals(Constants.LOW)) {
            product.setFinalPrice((float) (product.getChoosenPrice() - (product.getChoosenPrice() * 0.05)));
        }

        System.out.println("Product Name " + product.getProductName());
        System.out.println("Product Price " + product.getFinalPrice());
    }
}
