package com.example.data1700_oblig3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kunde {
    private String film, antall, fornavn,
            etternavn, telefonnr, epost;
    private int id;
}



