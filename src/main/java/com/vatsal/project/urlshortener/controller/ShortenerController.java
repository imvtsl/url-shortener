package com.vatsal.project.urlshortener.controller;

import com.vatsal.project.urlshortener.service.ShortenerService;
import com.vatsal.project.urlshortener.dto.InputURLDTO;
import com.vatsal.project.urlshortener.dto.OutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * A REST controller for handling all operations related to URL Shortener.
 * @author imvtsl
 * @since v1.0
 */

@Slf4j
@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShortenerController {
    @Autowired
    private ShortenerService shortenerService;

    @Operation(summary = "Get all long links and shortened links")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Long links and shortened links",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = OutputDTO.class)))})})
    @GetMapping(value = "/")
    public ResponseEntity<List<OutputDTO> > getAllLinks() {
        return ResponseEntity.ok(shortenerService.getAllLinks());
    }

    @Operation(summary = "Shorten a URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shortened URL",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OutputDTO.class))})})
    @PostMapping(value = "/shorten", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutputDTO> shorten(@Valid @RequestBody InputURLDTO inputURLDTO) {
        return ResponseEntity.ok(shortenerService.shorten(inputURLDTO));
    }

    @Operation(summary = "Get original URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Original URL",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OutputDTO.class))})})
    @PostMapping(value = "/original", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutputDTO> getOriginal(@Valid @RequestBody InputURLDTO inputURLDTO) {
        return ResponseEntity.ok(shortenerService.getOriginal(inputURLDTO));
    }

}
