package com.project.munroapi.controllers;

import com.project.munroapi.parser.ParseCSV;
import com.project.munroapi.constants.Constants;
import com.project.munroapi.utils.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(MunroAPI.class)
public class MunroAPITests {
    @Autowired
    private MockMvc mockMvc;

    private ParseCSV parseCSV;

    @BeforeAll
    public void setup() {
        parseCSV = new ParseCSV();
        parseCSV.setMunroData(new Data().populateTestData());
    }

    @Test
    void testMunroAPIGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].munroName", is(parseCSV.getMunroData().get(0).getName())))
                .andExpect(jsonPath("$[1].heightInMeters", is(parseCSV.getMunroData().get(1).getHeightMeters())))
                .andExpect(jsonPath("$[2].hillCategory", is(Constants.MUNRO_TOP)))
                .andExpect(jsonPath("$[3].heightInMeters", is(parseCSV.getMunroData().get(3).getHeightMeters())))
                .andExpect(jsonPath("$[4].gridReference", is(parseCSV.getMunroData().get(4).getGridRef())));
    }

    @Test
    void testMunroAPIGetWithLimitParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT)
                        .param("limit", "2")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].munroName", is(parseCSV.getMunroData().get(0).getName())))
                .andExpect(jsonPath("$[1].heightInMeters", is(parseCSV.getMunroData().get(1).getHeightMeters())));
    }

    @Test
    void testMunroAPIGetWithHillParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT)
                        .param("hill", "TOP")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].munroName", is(parseCSV.getMunroData().get(2).getName())))
                .andExpect(jsonPath("$[0].hillCategory", is(Constants.MUNRO_TOP)))
                .andExpect(jsonPath("$[1].munroName", is(parseCSV.getMunroData().get(4).getName())))
                .andExpect(jsonPath("$[1].hillCategory", is(Constants.MUNRO_TOP)));
    }

    @Test
    void testMunroAPIGetWithLimitAndAlphaParams() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT)
                        .param("limit", "3")
                        .param("alpha", "ASC")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].munroName", is(parseCSV.getMunroData().get(0).getName())))
                .andExpect(jsonPath("$[1].munroName", is(parseCSV.getMunroData().get(3).getName())))
                .andExpect(jsonPath("$[2].munroName", is(parseCSV.getMunroData().get(1).getName())));
    }

    @Test
    void testMunroAPIGetWithMinParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT)
                        .param("min", "1000")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].munroName", is(parseCSV.getMunroData().get(0).getName())))
                .andExpect(jsonPath("$[1].munroName", is(parseCSV.getMunroData().get(2).getName())))
                .andExpect(jsonPath("$[2].munroName", is(parseCSV.getMunroData().get(3).getName())));
    }

    @Test
    void testMunroAPIGetWithMinAndMaxAndHeightParams() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(Constants.MUNROS_ENDPOINT)
                        .param("min", "900")
                        .param("max", "1000")
                        .param("height", "DESC")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].heightInMeters", is(parseCSV.getMunroData().get(2).getHeightMeters())))
                .andExpect(jsonPath("$[1].heightInMeters", is(parseCSV.getMunroData().get(4).getHeightMeters())))
                .andExpect(jsonPath("$[2].heightInMeters", is(parseCSV.getMunroData().get(1).getHeightMeters())));
    }
}
