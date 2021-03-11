package firstday;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-03-11 15:08
 **/
@Data
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
}
