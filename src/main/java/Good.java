import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Comento_Board")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String view;
    private String hello;

}
