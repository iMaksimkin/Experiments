package io.mart.selenide_straightforward;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
  @Test
  public void search_selenide_in_google() {
    open("https://google.com/ncr");
    $(By.name("q")).val("selenide").pressEnter();
    $$("#ires .g").shouldHave(sizeGreaterThan(1));
    $("#ires .g").shouldBe(visible).shouldHave(
        text("Selenide: concise UI tests in Java"),
        text("selenide.org"));
  }
}
