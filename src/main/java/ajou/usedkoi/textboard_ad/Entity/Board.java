package ajou.usedkoi.textboard_ad.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String content;

    // 생성자
    public Board(String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
