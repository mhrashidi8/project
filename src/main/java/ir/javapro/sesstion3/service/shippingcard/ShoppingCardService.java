package ir.javapro.sesstion3.service.shippingcard;

import ir.javapro.sesstion3.dto.request.ShoppingCardRequest;
import ir.javapro.sesstion3.dto.response.ShoppingCardResponse;


public interface ShoppingCardService {

    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
