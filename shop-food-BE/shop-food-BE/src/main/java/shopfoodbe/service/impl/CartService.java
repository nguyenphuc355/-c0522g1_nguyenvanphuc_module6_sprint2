package shopfoodbe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.repository.ICartRepository;
import shopfoodbe.service.ICartService;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public List<ICartDto> getCartList() {
        return cartRepository.getCartList();
    }

    @Override
    public ITotalDto getTotalBill() {
        return cartRepository.getTotalBill();
    }

    @Override
    public void updateCart(Integer id) {
        cartRepository.updateCart(id);
    }

    @Override
    public void insertToCart(Integer id) {
        cartRepository.insertToCart(id);
    }

    @Override
    public void updateQty(Integer id, Integer qty) {
        cartRepository.updateQty(id, qty);
    }

    @Override
    public void deleteProduct(Integer id) {
        cartRepository.deleteProduct(id);
    }

    @Override
    public ICartDto findById(Integer id) {
        return cartRepository.findByIdCosmetic(id);
    }

}
