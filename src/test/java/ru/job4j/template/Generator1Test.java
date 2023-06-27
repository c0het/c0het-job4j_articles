package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class Generator1Test {

    Map<String, String> args = new HashMap<>();
    String template = new String();

    @Ignore
    @Test
    public void whenTemplateDontHaveKeys() {
        Generator generator = new Generator1();
        args.put("name", "ivan");
        args.put("subject", "you");
        template = "I am  name, Who are subject?";
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenTempalateHasUnknowKeys() {
        Generator generator = new Generator1();
        template = "I am  ${name}, Who are ${subject}?I am from ${city}";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenMapHasUnknowKeys() {
        Generator generator = new Generator1();
        template = "I am ${name}, Who are ${subject}";
        args.put("name", "ivan");
        args.put("subject", "you");
        args.put("city", "Moscow");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenWorks() {
        Generator generator = new Generator1();
        template = "I am ${name}, Who are ${subject}";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThat("I am ivan, Who are you").isEqualTo(generator.produce(template, args));
    }
}