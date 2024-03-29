package com.vatsal.project.urlshortener.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * DTO class for input url.
 * @author imvtsl
 * @since v1.0
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "link"
})

@Getter
@Setter
@ToString
public class InputURLDTO {
    @Pattern(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")
    @JsonProperty("link")
    private String link;
}
