package ank.phito.erp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */
@Getter
@Setter

@Document(collection = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Indexed
    @Field("productId")
    private ProductEntity productId;
}