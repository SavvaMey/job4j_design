package templatetdd;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tdd.Ticket3D;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GenerateTest {

    @Ignore
    @Test
    public void whenGetTrueTemplate() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> mapTemplates = Map.of(
                "name", "Petr",
                "subject", "Arsentev");
        String result = new GeneratorTemplates()
                .produce(template, mapTemplates);
        String expected = "I am a Petr, Who are Arsentev";
        assertThat(expected, is(result));
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenWhereIsNoTemplateInAMap() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> mapTemplates = Map.of(
                "name", "Petr");
        String result = new GeneratorTemplates()
                .produce(template, mapTemplates);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenWhereIsExtraTemplateInAMap() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> mapTemplates = Map.of(
                "name", "Petr",
                "subject", "Arsentev",
                "pc", "lenovo");
        String result = new GeneratorTemplates()
                .produce(template, mapTemplates);
    }

    @Ignore
    @Test
    public void whenWhereIsClearTemplate() {
        String template = "I am a Petr";
        Map<String, String> mapTemplates = Map.of(
                "name", "Petr",
                "subject", "Arsentev",
                "pc", "lenovo");
        String result = new GeneratorTemplates()
                .produce(template, mapTemplates);
        assertThat(template, is(result));
    }

}