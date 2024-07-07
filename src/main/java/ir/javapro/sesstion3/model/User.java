package ir.javapro.sesstion3.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{


    private String username;
    private String password;
    @Column(columnDefinition =  "boolean default true")
    private Boolean enabled = true;
}
