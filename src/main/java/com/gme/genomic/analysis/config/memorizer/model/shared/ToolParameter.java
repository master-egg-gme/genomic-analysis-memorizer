package com.gme.genomic.analysis.config.memorizer.model.shared;

import com.gme.genomic.analysis.config.memorizer.model.tool.Tool;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ToolParameter implements Serializable {

    @Id
    @Column(name = "PARAMETER_ID", nullable = false, unique = true)
    private long parameterId;

    @Column(name = "PARAMETER_NAME", nullable = false)
    private String parameterName;

    @Column(name = "PARAMETER_VALUE")
    private String parameterValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOOL_ID")
    private Tool tool;

    public ToolParameter() {
    }

    public ToolParameter(long parameterId, String parameterName, String parameterValue) {
        this.parameterId = parameterId;
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
        if (!tool.getToolParameters().contains(this))
        {
            tool.getToolParameters().add(this);
        }
    }

    public Tool getTool() {
        return tool;
    }
}
