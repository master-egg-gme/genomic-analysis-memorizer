package com.gme.genomic.analysis.config.memorizer.model.shared;

import com.gme.genomic.analysis.config.memorizer.model.tool.Tool;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ToolParameter implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private long parameterId;

    @Column(name = "KEY")
    private String parameterKey;

    @Column(name = "VALUE")
    private String parameterValue;

    @Column(name = "TOOL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOOL_ID")
    private Tool tool;

    public ToolParameter() {
    }

    public ToolParameter(long parameterId, String parameterKey, String parameterValue) {
        this.parameterId = parameterId;
        this.parameterKey = parameterKey;
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
