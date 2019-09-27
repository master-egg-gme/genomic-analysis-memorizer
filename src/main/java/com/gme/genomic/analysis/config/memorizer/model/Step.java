package com.gme.genomic.analysis.config.memorizer.model;

import com.gme.genomic.analysis.config.memorizer.model.tool.Tool;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "STEP")
public class Step implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private long toolId;

    @OneToMany(mappedBy = "toolId")
    private List<Tool> tools;

    public Step() {
    }

    public List<Tool> getTools() {
        return tools;
    }

}
