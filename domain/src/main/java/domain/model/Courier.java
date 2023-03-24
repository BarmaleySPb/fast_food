package domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier {
    private int id;

    private String name;

    private String phone;
}
