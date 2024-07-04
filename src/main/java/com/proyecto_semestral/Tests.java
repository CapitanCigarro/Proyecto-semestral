package com.proyecto_semestral;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.proyecto_semestral.Logic.BusMicrobus;

public class Tests {
    @Test
    public void testing() {
        assertTrue(new BusMicrobus(null, null) != new BusMicrobus(null, null));

    }

}
