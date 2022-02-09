Feature: Вход в системата

	Background:
		Given Потребителят отваря екрана за вход в ситемата


  Scenario: Вход в системата с валидни потребителски данни
    When Въведе "petrovaT@abv.bg" имейл адрес
    And въведе "passwordPetrovaT" парола
    And натисне бутона за вход в системата
    Then Вижда съжбщение: "Успешно влизане!"
    
  Scenario: Вход в системата с невалидни потребителски данни
    When Въведе "wrong@abv.bg" имейл адрес
    And въведе "passwordPetrovaT" парола
    And натисне бутона за вход в системата
    Then Вижда съжбщение: "Грешни данни!"

	Scenario: Вход в системата с невалидна парола
    When Въведе "petrovaT@abv.bg" имейл адрес
    And въведе "worngPasswordPetrovaT" парола
    And натисне бутона за вход в системата
    Then Вижда съжбщение: "Грешни данни!"

	Scenario: Вход в системата без парола
    When Въведе "petrovaT@abv.bg" имейл адрес
    And натисне бутона за вход в системата
    Then Вижда съжбщение: "Въведете имейл и парола!"
    
  Scenario: Вход в системата без имейл
    When въведе "passwordPetrovaT" парола
    And натисне бутона за вход в системата
    Then Вижда съжбщение: "Въведете имейл и парола!"
    
  Scenario: Вход в системата без потребителски данни
    When натисне бутона за вход в системата
    Then Вижда съжбщение: "Въведете имейл и парола!"