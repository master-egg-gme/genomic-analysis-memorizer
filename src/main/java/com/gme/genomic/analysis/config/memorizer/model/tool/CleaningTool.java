package com.gme.genomic.analysis.config.memorizer.model.tool;

import com.gme.genomic.analysis.config.memorizer.model.shared.ToolParameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class CleaningTool extends Tool implements Serializable
{

    @Column(name = "PARAMETER_ID")
    @OneToMany
    @JoinColumn(name = "PARAMETER_ID")
    private Set<ToolParameter> toolParameters;

    public CleaningTool() {
    }

    public Set<ToolParameter> getToolParameters() {
        return toolParameters;
    }

    public void setToolParameters(Set<ToolParameter> toolParameters) {
        this.toolParameters = toolParameters;
    }
}
