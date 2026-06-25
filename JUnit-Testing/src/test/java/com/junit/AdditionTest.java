package com.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test
    public void testAdd() {
        Addition add = new Addition();
        assertEquals(5, add.add(2, 3));
    }
}
