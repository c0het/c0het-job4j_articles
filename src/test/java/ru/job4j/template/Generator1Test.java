package ru.job4j.template;

import org.junit.Ignore;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Generator1Test {

    Map<String, String> args = new HashMap<>();
    String template = new String();

    @Ignore
    public void whenTemplateDontHaveKeys() {
        Generator generator = new Generator1();
        args.put("name", "ivan");
        args.put("subject", "you");
        template = "I am  name, Who are subject?";
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    public void whenTempalateHasUnknowKeys() {
        Generator generator = new Generator1();
        template = "I am  ${name}, Who are ${subject}?I am from ${city}";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    public void whenMapHasUnknowKeys() {
        Generator generator = new Generator1();
        template = "I am ${name}, Who are ${subject}";
        args.put("name", "ivan");
        args.put("subject", "you");
        args.put("city", "Moscow");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    public void whenWorks() {
        Generator generator = new Generator1();
        template = "I am ${name}, Who are ${subject}";
        args.put("name", "ivan");
        args.put("subject", "you");
        assertThat("I am ivan, Who are you").isEqualTo(generator.produce(template, args));
    }
}