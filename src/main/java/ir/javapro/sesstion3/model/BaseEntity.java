package ir.javapro.sesstion3.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private  LocalDateTime lastModificationDate;


    private  LocalDateTime deleted;

}
