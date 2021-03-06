Feature: Добавяне на класен ръководител

	Background:
		Given Администраторът отваря екран за добавяне на класен ръководител

  Scenario: Добавяне на класен ръководител
    When Избере клас: "free"
    And Избере учител: "free@abv.bg"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Успешно добавяне!"
    
  Scenario: Добавяне на класен ръководител в зает клас
    When Избере клас: "taken"
    And Избере учител: "free@abv.bg"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Зает клас!"
    
  Scenario: Добавяне на зает класен ръководител
    When Избере клас: "free"
    And Избере учител: "taken@abv.bg"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Зает класен ръководител!"
    
   Scenario: Добавяне на невалиден класен ръководител
    When Избере клас: "free"
    And Избере учител: "wrong@abv.bg"
    And Натисне бутон за добавяне
    Then Вижда съобщение: "Невалиден класен ръководител!"
