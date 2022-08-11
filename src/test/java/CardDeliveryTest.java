import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    void shouldSendFormWithValidData() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue("15.08.2022");
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79999999999");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(150));
        $("[data-test-id=notification]").shouldHave(text("Встреча успешно забронирована на 15.08.2022"));
    }

}




