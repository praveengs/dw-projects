package com.pgs.dwsamples.one.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by prave_000 on 19/11/2015.
 */
public class SampleAPI {

    private long id;

    @Length(max = 3)
    private String content;


    public SampleAPI() {

    }

    public SampleAPI (long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }


}
