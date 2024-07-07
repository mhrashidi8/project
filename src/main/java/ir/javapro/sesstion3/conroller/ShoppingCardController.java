package ir.javapro.sesstion3.conroller;

import ir.javapro.sesstion3.dto.request.ShoppingCardRequest;
import ir.javapro.sesstion3.dto.response.ShoppingCardResponse;
import ir.javapro.sesstion3.model.ShoppingCard;
import ir.javapro.sesstion3.service.shippingcard.ShoppingCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shoppingCard")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }



    @PostMapping
    public ResponseEntity<ShoppingCardResponse> addBook(@RequestBody @Valid ShoppingCardRequest shoppingCardRequest) {

        return ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardRequest));


    }



}
