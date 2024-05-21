package com.mipt.DungeonSuckerServer.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dead_players_table")
public class DeadPlayerEntity {
    @Id
    @Column(name = "id_user")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "data")
    private String data;

    public DeadPlayerEntity(){

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
