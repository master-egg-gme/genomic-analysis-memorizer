package com.gme.genomic.analysis.config.memorizer.model;

import com.gme.genomic.analysis.config.memorizer.model.tool.Tool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "STEP")
public class Step implements Serializable {

    @Id
    @Column(name = "STEP_ID", nullable = false, unique = true)
    private long  stepId;

    @Column(name = "STEP_NAME", nullable = false)
    private  String stepName;

    @OneToMany(mappedBy = "toolId")
    private List<Tool> tools;

    public Step() {
    }

    public Step(long stepId, String stepName) {
        this.stepId = stepId;
        this.stepName = stepName;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public String getStepName() {
        return stepName;
    }
}
