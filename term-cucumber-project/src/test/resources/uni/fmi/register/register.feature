Feature: Регистарция на потребител

  Scenario Outline: Регистарция на потребител
    Given Администраторът отваря екрана за регистрация
    When Въведе имейл "<email>" в полето имейл
    And Въведе парола "<password>" в полето парола
    And Въведе парола "<password2>" в полето за втора парола
    And Въведе име "<name>" в полето за име
    And Въведе роля "<role>" в полето за роля
    And Натисне бутон за регистрация
    Then Вижда съобщение "<message>" in step

    Examples: 
      | email  			| password | password2 | name | role | message 							    |
      | stu@abv.bg  | Pass123  | Pass123 	 | Ivan	|	stu	 | Регистриран успешно!     |
      | tea@abv.bg  | Pass123  | Pass123 	 | Rado	|	tea	 | Регистриран успешно!     |
      | par@abv.bg  | Pass123  | Pass123 	 | Jana	|	par, tea	 | Регистриран успешно!     |
      | parabv.bg   | Pass123  | Pass123 	 | Jana	|	par	 | Невалиден имейл!         |
      | te@abv.bg   | Pass123  | Pass123   | Jana	|	par	 | Зает имейл!              |
      | 				    | Pass123  | Pass123 	 | Jana	|	par	 | Въведете имейл!          |
      | par@abv.bg  | Pass123  | Pass1234	 | Jana	|	par	 | Въведете еднакви пароли! |
			| par@abv.bg  | Pass     | Pass	 		 | Jana	|	par	 | Паролата трябва да е десет символа! |
			| par@abv.bg  |          |           | Jana	|	par	 | Паролата трябва да е десет символа! |
			| par@abv.bg  | Pass123  | Pass123   | 			|	par	 | Въведете име! 	 |
			| not@abv.bg  | Pass123  | Pass123   | Jana |	not	 | Невалидни роли! |
			| not@abv.bg  | Pass123  | Pass123   | Jana |	  	 | Въведете роли! |