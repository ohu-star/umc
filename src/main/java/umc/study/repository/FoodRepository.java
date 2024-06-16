package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
