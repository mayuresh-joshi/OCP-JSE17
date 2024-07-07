package org.mj.module3.lesson12;

sealed interface BaseIF permits SubEnum, SubRecord {

}

// Notice no final, sealed or non-sealed is required for enums or records

// Marking enums final is actually not permitted
enum SubEnum implements BaseIF {}

// Implicitly final so no need.
record SubRecord() implements BaseIF {
}

public class RecordsAndEnumsWithSealedTypes {
}
