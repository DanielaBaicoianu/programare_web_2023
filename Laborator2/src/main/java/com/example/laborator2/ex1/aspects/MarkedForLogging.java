package com.example.laborator2.ex1.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MarkedForLogging {
}
