package es.daw.foodexpressapi.service;

import es.daw.foodexpressapi.dto.RestaurantDTO;
import es.daw.foodexpressapi.entity.Restaurant;
import es.daw.foodexpressapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private RestaurantDTO toDTO(Restaurant restaurant) {
//        RestaurantDTO dto = new RestaurantDTO();
//        dto.setName(restaurant.getName());
//        dto.setAddress(restaurant.getAddress());
//        dto.setPhone(restaurant.getPhone());
//
//        return dto;
        return RestaurantDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phone(restaurant.getPhone())
                .build();

    }

    // Pendiente: METER MAPSTRUCT!!!!
}
