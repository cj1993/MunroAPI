package com.project.munroapi.controllers;

import com.project.munroapi.constants.Constants;
import com.project.munroapi.parser.ParseCSV;
import com.project.munroapi.utils.Mapping;
import com.project.munroapi.utils.Validation;
import com.project.munroapi.model.Munro;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MunroAPI {

    private final static Logger logger = LogManager.getLogger(MunroAPI.class);

    @GetMapping(Constants.MUNROS_ENDPOINT)
    public ResponseEntity<Object> getMunro(
            @RequestParam(required = false) String hill,
            @RequestParam(required = false) String height,
            @RequestParam(required = false) String alpha,
            @RequestParam(required = false) String min,
            @RequestParam(required = false) String max,
            @RequestParam(required = false) String limit) {

        logger.info("Get request at " + Constants.MUNROS_ENDPOINT + ". Params: Hill " + hill + " Height " + height +" Alpha " + alpha +
                " Min " + min + " Max " + max + " Limit " + limit);

        if (!Validation.paramsValid(hill, height, alpha, min, max, limit)) return Validation.errorResponse();

        Mapping mappingTool = new Mapping();

        List<Munro> munroData = new ParseCSV().getMunroData();
        List<Munro> munroDataClone = mappingTool.createMunroDataClone(munroData);

        List<Munro> munroDataSorted = mappingTool.handleSorting(munroDataClone, height, alpha);

        return ResponseEntity.ok(mappingTool.handleFiltering(munroDataSorted, hill, min, max, limit));
    }
}
