package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<Food> foodList) {
        return foodList.stream()
                .map(food ->
                        MemberPrefer.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}
