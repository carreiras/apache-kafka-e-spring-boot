package carreiras.com.github.shopapi.dto;

import carreiras.com.github.shopapi.entity.Shop;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ShopDTO {

    private String identifier;
    private LocalDate dateShop;
    private String status;
    private List<ShopItemDTO> items = new ArrayList<>();

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDto = new ShopDTO();
        shopDto.setIdentifier(shop.getIdentifier());
        shopDto.setDateShop(shop.getDateShop());
        shopDto.setStatus(shop.getStatus());
        shopDto.setItems(
                shop.getItems()
                        .stream()
                        .map(i -> ShopItemDTO.convert(i))
                        .collect(Collectors.toList())
        );

        return shopDto;
    }
}
