package ank.phito.erp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */
@Getter
@Setter

@Document(collection = "calenders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderEntity {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;
}