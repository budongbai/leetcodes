package helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Long> mallIdlIst = Arrays.asList(140118289L, 451473890L, 612536618L);

        for (Long mallId : mallIdlIst) {
            System.out.println(mallId % 128);
            System.out.println(mallId / 128 % 64);
        }

        List<Long> mallIdList = Arrays.asList(100L,200L,300L);
        List<Long> filterMallId = mallIdList.stream()
                .filter(obj -> Objects.equals(obj, 100L))
                .collect(Collectors.toList());

        System.out.println(filterMallId);
    }
}
