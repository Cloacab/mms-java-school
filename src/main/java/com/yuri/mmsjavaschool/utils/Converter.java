package com.yuri.mmsjavaschool.utils;

import java.util.function.Function;

public class Converter {
    public static <F, T> T convert(Function<F, T> func, F source) {
        return func.apply(source);
    }
}
