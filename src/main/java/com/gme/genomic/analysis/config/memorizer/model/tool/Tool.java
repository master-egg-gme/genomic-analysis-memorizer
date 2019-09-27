package com.gme.genomic.analysis.config.memorizer.model.tool;

import com.gme.genomic.analysis.config.memorizer.model.shared.ToolParameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Tool implements Serializable
{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "tool")
    private Set<ToolParameter> toolParameters;

    public Tool() {
    }

    public Set<ToolParameter> getToolParameters() {
        return toolParameters;
    }

    public void setToolParameters(Set<ToolParameter> toolParameters) {
        this.toolParameters = toolParameters;
    }

    public void addToolParameter(ToolParameter toolParameter)
    {
        this.toolParameters.add(toolParameter);
        if (toolParameter.getTool() != this)
        {
            toolParameter.setTool(this);
        }
    }

}
