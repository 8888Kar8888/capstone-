package aua.capstone.storeApp.controller;
import aua.capstone.storeApp.exceptions.customerExceptions.CustomerNotLoggedInException;
import aua.capstone.storeApp.model.dto.AddToCartDto;
import aua.capstone.storeApp.model.dto.CartDto;
import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.model.dto.ModifyCartItemDto;
import aua.capstone.storeApp.model.entity.Customer;
import aua.capstone.storeApp.model.responses.ApiResponse;
import aua.capstone.storeApp.service.CartService;
import aua.capstone.storeApp.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController
{
    private final CartService cartService;
    private final CustomerService customerService;
    public CartController(CartService cartService, CustomerService customerService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }


    @PostMapping("/")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,  HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            throw new CustomerNotLoggedInException();
        }
        System.out.println(addToCartDto.getProductId());
        CustomerSessionDto customerSessionDto = (CustomerSessionDto) request.getSession().getAttribute("user");
        Customer customer = customerService.findById(customerSessionDto.getCustomerId());

        cartService.addToCart(addToCartDto, customer);
        return new ResponseEntity<>(new ApiResponse(true, "Added to Cart"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(HttpServletRequest request) {
        CustomerSessionDto customerSessionDto = (CustomerSessionDto)
                request.getSession().getAttribute("user");

        if (customerSessionDto == null) {
            throw new CustomerNotLoggedInException();
        }

        CartDto cartDto = cartService.getCartInfo(customerSessionDto.getCustomerId());
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Integer cartItemId, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            throw new CustomerNotLoggedInException();
        }

        CustomerSessionDto customerSessionDto = (CustomerSessionDto) request.getSession().getAttribute("user");
        Customer customer = customerService.findById(customerSessionDto.getCustomerId());
        cartService.deleteCartItem(cartItemId, customer);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> modifyCartItem(@RequestBody ModifyCartItemDto modifyCartItemDto,
                                                      HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            throw new CustomerNotLoggedInException();
        }

        CustomerSessionDto customerSessionDto = (CustomerSessionDto) request.getSession().getAttribute("user");
        cartService.modifyCartItem(modifyCartItemDto, customerSessionDto);

        return new ResponseEntity<>(new ApiResponse(true, "Item was modified"), HttpStatus.OK);
    }

}
