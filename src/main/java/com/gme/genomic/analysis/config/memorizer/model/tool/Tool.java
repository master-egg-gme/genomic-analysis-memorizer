package com.gme.genomic.analysis.config.memorizer.model.tool;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Tool
{

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

}
