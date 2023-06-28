package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@Disabled
class Generator1Test {

    @Test
    public void whenTemplateDontHaveKeys() {
        Generator generator = new Generator1();
        Map<String, String> args = new HashMap<>();
        String template =  "I am  name, Who are subject?";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenTempalateHasUnknowKeys() {
        Generator generator = new Generator1();
        Map<String, String> args = new HashMap<>();
        String template = "I am  ${name}, Who are ${subject}?I am from ${city}";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapHasUnknowKeys() {
        Generator generator = new Generator1();
        Map<String, String> args = new HashMap<>();
        String template = "I am ${name}, Who are ${subject}";
        args.put("name", "ivan");
        args.put("subject", "you");
        args.put("city", "Moscow");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenWorks() {
        Map<String, String> args = new HashMap<>();
        String template = "I am ${name}, Who are ${subject}";
        Generator generator = new Generator1();
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThat("I am ivan, Who are you").isEqualTo(generator.produce(template, args));
    }
}