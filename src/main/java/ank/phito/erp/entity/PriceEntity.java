package ank.phito.erp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.*;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */
@Getter
@Setter

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "prices")
public class PriceEntity {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @DocumentReference(collection = "products")
    private ProductEntity product;
}