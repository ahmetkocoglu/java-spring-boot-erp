package ank.phito.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */
@Getter
@Setter
public class UserEntity {
    private Long id;

    private String email;

    @JsonIgnore
    private String password;

    private String role;

    private String extraInfo;
}