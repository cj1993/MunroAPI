package com.project.munroapi.utils;

import com.project.munroapi.constants.Constants;
import com.project.munroapi.model.Munro;
import com.project.munroapi.model.MunroResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mapping {

    public List<MunroResponse> handleFiltering(List<Munro> munroData, String hillCategory, String min, String max, String limit) {
        if (Validation.isPresent(hillCategory)) filterOnHillCategory(munroData, hillCategory);
        if (Validation.isPresent(min)) filterOnMin(munroData, min);
        if (Validation.isPresent(max)) filterOnMax(munroData, max);
        if (Validation.isPresent(limit)) filterOnLimit(munroData, limit);

        return munroResponseMapper(munroData);
    }

    public List<Munro> handleSorting(List<Munro> munroDataResponse, String height, String alpha) {
        if (Validation.isPresent(height)) sortOnHeight(munroDataResponse, height);
        if (Validation.isPresent(alpha)) sortOnAlpha(munroDataResponse, alpha);

        return munroDataResponse;
    }

    private void sortOnHeight(List<Munro> data, String height) {
        if (height.equalsIgnoreCase(Constants.ASC)) data.sort(Comparator.comparing(Munro::getHeightMeters));
        if (height.equalsIgnoreCase(Constants.DESC)) data.sort(Comparator.comparing(Munro::getHeightMeters).reversed());
    }

    private void sortOnAlpha(List<Munro> data, String alpha) {
        if (alpha.equalsIgnoreCase(Constants.ASC)) data.sort(Comparator.comparing(Munro::getName));
        if (alpha.equalsIgnoreCase(Constants.DESC)) data.sort(Comparator.comparing(Munro::getName).reversed());
    }

    private void filterOnHillCategory(List<Munro> munroData, String hillCategory) {
        if (hillCategory.equalsIgnoreCase(Constants.MUN))
            munroData.removeIf(munro -> munro.getPost1997().equalsIgnoreCase(Constants.TOP));
        if (hillCategory.equalsIgnoreCase(Constants.TOP))
            munroData.removeIf(munro -> munro.getPost1997().equalsIgnoreCase(Constants.MUN));
    }

    private void filterOnMin(List<Munro> munroData, String min) {
        munroData.removeIf(munro -> munro.getHeightMeters() < Double.parseDouble(min));
    }

    private void filterOnMax(List<Munro> munroData, String max) {
        munroData.removeIf(munro -> munro.getHeightMeters() > Double.parseDouble(max));
    }

    private void filterOnLimit(List<Munro> munroData, String limit) {
        if (Integer.parseInt(limit) <= munroData.size())
            munroData.removeAll(munroData.subList(Integer.parseInt(limit), munroData.size()));
    }

    private List<MunroResponse> munroResponseMapper(List<Munro> munroData) {
        List<MunroResponse> munroDataResponse = new ArrayList<>();

        munroData.forEach(munro -> munroDataResponse.add(
                        new MunroResponse(
                                munro.getName(),
                                munro.getHeightMeters(),
                                transposeHillCategory(munro.getPost1997()),
                                munro.getGridRef()
                        )
                )
        );

        return munroDataResponse;
    }

    public List<Munro> createMunroDataClone(List<Munro> munroData) {
        List<Munro> munroDataClone = new ArrayList<>();
        munroData.forEach(munro -> munroDataClone.add(munro.clone()));

        return munroDataClone;
    }

    private String transposeHillCategory(String hillCategory) {
        if (hillCategory.equalsIgnoreCase(Constants.MUN)) return Constants.MUNRO;
        else if (hillCategory.equalsIgnoreCase(Constants.TOP)) return Constants.MUNRO_TOP;
        else return Constants.EITHER;
    }
}
