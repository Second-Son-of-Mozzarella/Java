package edu.wctc.distjavajpainclass.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Sighting")
public class Sighting {

    @Id
    @Column(name = "sighting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sq_id")
    private int squirrelId;


    @Column(name = "spotter_name")
    private String spotterName;

    @Column(name = "loc_id")
    private int locationId;


    @Column(name = "count")
    private int count;

    @Column(name = "spotted_at")
    private LocalDateTime spottedAt;

}
