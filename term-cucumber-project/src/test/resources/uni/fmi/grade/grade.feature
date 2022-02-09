Feature: Добавяне на оценка

	Background:
		Given Администраторът отваря екрана за добавяне на оценка

  Scenario: Добавяне на валидна оценка
    When Въведе оценка: "6"
    And Въведе имейл на ученик: "stu15@abv.bg"
    And Въведе предмет: "History"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Успешно добавяне!"
    
  Scenario: Добавяне на невалидна оценка
    When Въведе оценка: "3.5"
    And Въведе имейл на ученик: "stu15@abv.bg"
    And Въведе предмет: "History"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Оценката трябва да е цяло число от 2 до 6!"
    
  Scenario: Добавяне на невалиднен имейл
    When Въведе оценка: "6"
    And Въведе имейл на ученик: "wrong@abv.bg"
    And Въведе предмет: "History"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Невалиден имейл!"
    
  Scenario: Добавяне на невалидна предмет
    When Въведе оценка: "6"
    And Въведе имейл на ученик: "stu15@abv.bg"
    And Въведе предмет: "WrongSubject"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Невалиден предмет!"