package ank.phito.erp.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */
@Getter
@Setter
public class PriceEntity {
    private Long id;

    private String title;

    private String description;
}