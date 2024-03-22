package com.cleanarch.ddd.domain.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        modelMapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseObject(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        for (O originItem : origin) {
            destinationObjects.add(parseObject(originItem, destination));
        }
        return destinationObjects;
    }
}
