package io.joamit.caresearch.api.commons.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Media {

    @Id
    private String id;
    private String url;
}
