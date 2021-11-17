package ru.omsu.imit.params;

import org.junit.Test;
import ru.omsu.imit.params.Param;
import ru.omsu.imit.params.ParamService;

import static org.junit.Assert.*;

public class ParamServiceTest {
    @Test
    public void testParseParams() {
        String src = "name1=1, name2=2";
        Param[] expected = { new Param("name1", 1), new Param("name2", 2) };
        assertArrayEquals(expected, ParamService.parse(src));
    }

    @Test
    public void testParseParamsOneParam() {
        String src = "name1=1";
        Param[] expected = { new Param("name1", 1) };
        assertArrayEquals(expected, ParamService.parse(src));
    }

    @Test
    public void testParseParamsNoParam() {
        String src = "";
        Param[] expected = {  };
        assertArrayEquals(expected, ParamService.parse(src));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseParamsNoValue() {
        String src = "name=";
        ParamService.parse(src);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseParamsNoName() {
        String src = "=2";
        ParamService.parse(src);
    }
    @Test(expected = NumberFormatException.class)
    public void testParseParamsBadValue() {
        String src = "name=qwe";
        ParamService.parse(src);
    }
}